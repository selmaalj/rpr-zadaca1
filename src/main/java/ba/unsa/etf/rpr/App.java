package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        String s = "";
        double rez=0;
       for (String a : args)
        s = s + a + " ";
        try {
             rez = ExpressionEvaluator.evaluate(s);
            System.out.println("Rezultat izraza "+ rez);
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
