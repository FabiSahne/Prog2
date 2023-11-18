package aufgabe4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author oliverbittel
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {

    private int size = 0;
    private Element<T>[] fqTable;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // Ihr Code:
        int DEFAULT_SIZE = 100;
        fqTable = new Element[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(T w, int f) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // Ihr Code:

        // Array verlängern, falls voll.
        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, 2 * size);
        }

        // Prüfen, ob Wort bereits in Tabelle
        boolean hasWord = false;
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (fqTable[i].getWord().equals(w)) {
                hasWord = true;
                ind = i;
            }
        }
        if (hasWord) {
            int total = fqTable[ind].getFrequency() + f;
            int i = ind;
            Element<T> element = fqTable[ind];
            for (; i > 0 && total > fqTable[i-1].getFrequency(); i--) {
                fqTable[i] = fqTable[i - 1];
            }
            fqTable[i] = element;
            fqTable[i].addFrequency(f);
        } else {
            int i = size;
            if (size > 0) {
                while (i > 0 && f > fqTable[i-1].getFrequency()) {
                    fqTable[i] = fqTable[i - 1];
                    i--;
                }
            }
            fqTable[i] = new Element<>(w, f);
            size++;
        }

    }

    @Override
    public Element<T> get(int pos) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // Ihr Code:
        if (pos >= 0 && pos < size) {
            return fqTable[pos];
        }
        System.out.println("Pos: " + pos + ", Size: " + size);
        throw new IndexOutOfBoundsException(pos);
    }

    @Override
    public int get(T w) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // Ihr Code:
        for (int i = 0; i < size; i++) {
            if (fqTable[i].getWord().equals(w)) {
                return fqTable[i].getFrequency();
            }
        }
        return 0;
    }

    @Override
    public Iterator<Element<T>> iterator() {
        return new Iterator<>() {
            private int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public Element<T> next() {
                if (hasNext()) {
                    return fqTable[pos++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
