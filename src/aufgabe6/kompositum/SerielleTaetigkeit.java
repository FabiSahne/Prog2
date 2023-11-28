package kompositum;

import java.util.ArrayList;

public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit{

    public SerielleTaetigkeit(){
        super.meineTaetigkeiten = new ArrayList<>();
    }

    @Override
    public double getTime(){
        double time = 0;
        for (Taetigkeit taetigkeit : meineTaetigkeiten) {
            time += taetigkeit.getTime();
        }
        return time;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Seriell: {");
        for (Taetigkeit x : meineTaetigkeiten){
            s.append(x.toString());
            s.append("; ");
        }
        s.append("}");
        return s.toString();
    }

}
