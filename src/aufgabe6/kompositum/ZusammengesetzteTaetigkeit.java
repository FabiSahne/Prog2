package kompositum;

import java.util.List;

public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit{

    protected List<Taetigkeit> meineTaetigkeiten;

    public double getTime(){
        return 0;
    }

    public void add(Taetigkeit tk){
        meineTaetigkeiten.add(tk);
    }

    public void remove(Taetigkeit tk){
        meineTaetigkeiten.remove(tk);
    }

    public int getAnzahl(){
        int a = 0;
        for (Taetigkeit x : meineTaetigkeiten){
            a += x.getAnzahl();
        }
        return a;
    }

}
