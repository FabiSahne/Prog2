package kompositum;

public class ElementareTaetikgeit implements Taetigkeit{
    private double time;
    private String beschr;

    public ElementareTaetikgeit(String b, double t){
        time = t;
        beschr = b;
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public void add(Taetigkeit tk) {
        throw new UnsupportedOperationException("Kann zu Elementarer Tätigkeit keine weitere hinzufügen.");
    }

    @Override
    public void remove(Taetigkeit tk) {
        throw new UnsupportedOperationException("Kann aus Elementarer Tätigkeit keine entfernen.");
    }

    @Override
    public int getAnzahl() {
        return 1;
    }

    @Override
    public String toString(){
        return beschr + ", " + time + " min";
    }
}
