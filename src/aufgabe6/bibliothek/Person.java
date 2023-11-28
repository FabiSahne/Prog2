package bibliothek;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Buch> ausgelieheneBuecher;

    public Person(String name){
        this.name = name;
        ausgelieheneBuecher = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public boolean leihtAus(Buch b){
        if (ausgelieheneBuecher.contains(b)){
            return false;
        }
        if (b.getEntleiher() != null && b.getEntleiher() != this){
            return false;
        }
        ausgelieheneBuecher.add(b);
        b.wirdAusgeliehen(this);
        return true;
    }


    public boolean gibtZurueck(Buch b) {
        if (!ausgelieheneBuecher.contains(b) || b.getEntleiher() == null){
            return false;
        }
        ausgelieheneBuecher.remove(b);
        b.wirdZurueckGegeben();
        return true;
    }

    public void print() {
        System.out.print("Name: " + name + "; Geliehene Bücher: ");
        for (Buch x : ausgelieheneBuecher){
            System.out.print(x.getName() + ", ");
        }
        System.out.println();
    }
}
