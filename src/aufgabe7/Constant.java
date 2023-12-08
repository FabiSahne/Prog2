package aufgabe7;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Constant implements Expression {

    private final double constant;

    public Constant(double constant){
        this.constant = constant;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return constant;
    }

    @Override
    public Set<String> getVars() {
        return new HashSet<>();
    }
    @Override
    public String toString(){
        return String.valueOf(constant);
    }
}
