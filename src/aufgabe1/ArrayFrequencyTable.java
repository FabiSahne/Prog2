package aufgabe1;

// import aufgabe1.AbstractFrequencyTable;
// import aufgabe1.Word;
import java.util.Arrays;

/**
 *
 * @author oliverbittel
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {

    private int size = 0;
    private Word fqTable[];
    private final int DEFAULT_SIZE = 100;

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
        fqTable = new Word[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(String w, int f) {
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
            Word word = fqTable[ind];
            for (; i > 0 && total > fqTable[i-1].getFrequency(); i--) {
                fqTable[i] = fqTable[i - 1];
            }
            fqTable[i] = word;
            fqTable[i].addFrequency(f);
        } else {
            int i = size;
            if (size > 0) {
                while (i > 0 && f > fqTable[i-1].getFrequency()) {
                    fqTable[i] = fqTable[i - 1];
                    i--;
                }
            }
            fqTable[i] = new Word(w, f);
            size++;
        }

    }

    @Override
    public Word get(int pos) {
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
    public int get(String w) {
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
}
