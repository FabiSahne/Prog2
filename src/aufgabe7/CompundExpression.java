package aufgabe7;

import java.util.Map;
import java.util.Set;

public class CompundExpression implements Expression{
    protected Expression a, b;

    @Override
    public double eval(Map<String, Double> varBel) {
        return 0;
    }

    @Override
    public Set<String> getVars() {
        Set<String> vars = a.getVars();
        vars.addAll(b.getVars());
        return vars;
    }
}
