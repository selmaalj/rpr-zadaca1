package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class for expression evaluator
 * @author Selma Ljuhar
 * @version 1.0
 */
public class ExpressionEvaluator {
    /**
     * Returns double value of given string based on Dijkstra's two stack algorithm
     * @param str expression
     * @throws RuntimeException
     * @return double
     */
    public static double evaluate(String str) {
        str=str.trim();
        Stack<String> ops;
        Stack<Double> val;
        ops = new Stack<>();
        val = new Stack<>();
        int broj_zagrada=0;
        for (String s : str.split(" ")) {
            if (s.equals("(")) {
                broj_zagrada = broj_zagrada + 1;
            }
            else if (s.equals("+")  || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
                ops.add(s);
            else if (s.equals(")")) {
                broj_zagrada = broj_zagrada - 1;
                if(ops.size()==0)
                    throw new RuntimeException("Izraz nije validan");
                String op = ops.pop();
                if ((op.equals("sqrt") && val.size() < 1) ||(!op.equals("sqrt") && val.size() < 2))
                    throw new RuntimeException("Izraz nije validan");
                double vr = val.pop();
                if (op.equals("+")) vr = val.pop() + vr;
                else if (op.equals("-")) vr = val.pop() - vr;
                else if (op.equals("*")) vr = val.pop() * vr;
                else if (op.equals("/")) {
                    if(vr==0)
                        throw new RuntimeException("Dijeljenje s nulom!");
                    vr = val.pop() / vr;
                }
                else if (op.equals("sqrt")) vr = Math.sqrt(vr);
                val.push(vr);
            }
            else
                val.push(Double.parseDouble(s));
        }
        if(ops.size()!=0 || broj_zagrada!=0)
            throw new RuntimeException("Izraz nije validan");
        return val.pop();
    }
}

