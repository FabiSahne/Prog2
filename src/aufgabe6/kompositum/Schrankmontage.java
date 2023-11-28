package kompositum;

public class Schrankmontage {
    public static void main(String[] args) {
        Taetigkeit tk1 = new ParalleleTaetigkeit();
        tk1.add(new ElementareTaetikgeit("Linke Seitenwand montieren", 5.0));
        tk1.add(new ElementareTaetikgeit("Rechte Seitenwand montieren", 5.0));

        Taetigkeit tk2 = new ParalleleTaetigkeit();
        tk2.add(new ElementareTaetikgeit("Linke Türe montieren", 7.0));
        tk2.add(new ElementareTaetikgeit("Rechte Türe mit Griff montieren", 9.0));

        Taetigkeit schrankMontage = new SerielleTaetigkeit();
        schrankMontage.add(new ElementareTaetikgeit("Füße an Boden montieren", 6.0));
        schrankMontage.add(tk1);
        schrankMontage.add(new ElementareTaetikgeit("Decke montieren", 8.0));
        schrankMontage.add(tk2);

        System.out.println(schrankMontage.getTime() + " min");
        System.out.println(schrankMontage.getAnzahl());
        System.out.println(schrankMontage);
    }
}
