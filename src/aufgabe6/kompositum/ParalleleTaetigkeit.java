package kompositum;

import java.util.ArrayList;

public class ParalleleTaetigkeit extends ZusammengesetzteTaetigkeit{

    public ParalleleTaetigkeit(){
        super.meineTaetigkeiten = new ArrayList<>();
    }

    @Override
    public double getTime(){
        double time = 0;
        for (Taetigkeit x : meineTaetigkeiten){
            if (x.getTime() > time) {
                time = x.getTime();
            }
        }
        return time;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Parallel: {");
        for (Taetigkeit x : meineTaetigkeiten){
            s.append(x.toString());
            s.append("; ");
        }
        s.append("}");
        return s.toString();
    }
}
