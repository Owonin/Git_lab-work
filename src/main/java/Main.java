import javax.script.ScriptException;

public class Main {
    public static void main(String arg[]){
        RiemannSum sum = new RiemannSum(0,2, "cos(x*x)");
        System.out.println(sum.calculate() + " "+ sum.getRate());

    }
}
