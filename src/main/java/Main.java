import javax.script.ScriptException;

public class Main {
    public static void main(String arg[]){
        RiemannSum sum = new RiemannSum(0,2, "sin(x-1)");
        System.out.println(sum.calculate());

    }
}
