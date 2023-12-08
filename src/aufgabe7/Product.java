package aufgabe7;

import java.util.Map;

public class Product extends CompundExpression{
    public Product(Expression a, Expression b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double eval(Map<String, Double> varBel) {
        double result = a.eval(varBel);
        result *= b.eval(varBel);
        return result;
    }
    @Override
    public String toString(){
        return "(" + a +
                " * " +
                b +
                ")";
    }
}
