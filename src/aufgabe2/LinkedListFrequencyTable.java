package aufgabe2;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {

    public LinkedListFrequencyTable() {
        clear();
    }

    private static class Node {
        private Node next;
        private Node prev;
        private final Word word;

        public Node(Word word, Node next, Node prev) {
            this.word = word;
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
        size = 0;
    }

    @Override
    public void add(String w, int f) {

        if(isEmpty()) {
            begin.next = new Node(new Word(w, f), end, begin);
            end.prev = begin.next;
            size++;
            return;
        }

        Node p = begin.next;
        int total = f;
        // Alle Wörter durchlaufen
        while (p != end) {
            // Falls Wort schon existiert...
            if (p.word != null && p.word.getWord().equals(w)) {
                // Neue Frequenz ausrechnen und..
                total += p.word.getFrequency();
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
        while (p != end && p.word.getFrequency() > total) {
            p = p.next;
        }
        Node r = new Node(new Word(w, total), p, p.prev);
        p.prev.next = r;
        p.prev = r;
        size++;

    }

    @Override
    public Word get(int pos) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(pos);
        }
        Node toGet = begin.next;
        for (int i = 0; i < pos; i++) {
            toGet = toGet.next;
        }
        return toGet.word;
    }

    @Override
    public int get(String w) {
        Node toGet = begin.next;
        while (toGet != end) {
            if (toGet.word.getWord().equals(w)) {
                return toGet.word.getFrequency();
            } else {
                toGet = toGet.next;
            }
        }
        return 0;
    }
}
