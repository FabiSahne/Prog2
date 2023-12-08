package aufgabe7;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Var implements Expression{

    private final String var;

    public Var(String var){
        this.var = var;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        double value = 0;
        if (varBel.containsKey(var)) {
            value = varBel.get(var);
        }
        return value;
    }

    @Override
    public Set<String> getVars() {
        Set<String> vars = new HashSet<>();
        vars.add(var);
        return vars;
    }
    @Override
    public String toString(){
        return var;
    }
}
