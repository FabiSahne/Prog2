package aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    public LinkedListFrequencyTable() {
        clear();
    }

    @Override
    public Iterator<Element<T>> iterator() {
        return new Iterator<>() {
            private Node pos = begin;
            @Override
            public boolean hasNext() {
                return pos != end.prev;
            }

            @Override
            public Element<T> next() {
                if (hasNext()) {
                    pos = pos.next;
                    return pos.element;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    private class Node {
        private Node next;
        private Node prev;
        private final Element<T> element;

        public Node(Element<T> element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node begin;
    private Node end;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        begin = new Node(null, end, null);
        end = new Node(null, null, begin);
        begin.next = end;
        size = 0;
    }

    @Override
    public void add(T w, int f) {

        if(isEmpty()) {
            begin.next = new Node(new Element<>(w, f), end, begin);
            end.prev = begin.next;
            size++;
            return;
        }

        Node p = begin.next;
        int total = f;
        // Alle Wörter durchlaufen
        while (p != end) {
            // Falls Wort schon existiert...
            if (p.element != null && p.element.getWord().equals(w)) {
                // Neue Frequenz ausrechnen und..
                total += p.element.getFrequency();
                // Node löschen
                p.prev.next = p.next;
                p.next.prev = p.prev;
                size--;
                break;
            }
            p = p.next;
        }

        // Neues Wort mit evtl neuer Frequenz einfügen...
        p = begin.next;
        while (p != end && p.element.getFrequency() > total) {
            p = p.next;
        }
        Node r = new Node(new Element<>(w, total), p, p.prev);
        p.prev.next = r;
        p.prev = r;
        size++;

    }

    @Override
    public Element<T> get(int pos) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(pos);
        }
        Node toGet = begin.next;
        for (int i = 0; i < pos; i++) {
            toGet = toGet.next;
        }
        return toGet.element;
    }

    @Override
    public int get(T w) {
        Node toGet = begin.next;
        while (toGet != end) {
            if (toGet.element.getWord().equals(w)) {
                return toGet.element.getFrequency();
            } else {
                toGet = toGet.next;
            }
        }
        return 0;
    }
}
