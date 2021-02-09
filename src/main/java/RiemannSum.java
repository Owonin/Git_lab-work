import javax.script.ScriptException;

public class RiemannSum implements ICalculator{
    private Double a;
    private Double b;
    public double n = 10;
    private String function;
    private Function f = new Function();

    public <T extends Number> RiemannSum(T a, T b, String s) {
        try{
            this.a = (Double) a;
        }
        catch (Exception e){
            this.a = (Double)((Integer)a*1.0);
        }
        try{
            this.b = (Double) b;
        }
        catch (Exception e){
            this.b = (Double)((Integer)b*1.0);
        }
        function = s;
    }
    public double FunctionToDouble(Object o){
        double res;
        try {
            res = (Double) o;
        }
        catch (Exception e){
            res = (Double)((Integer)o * 1.0);
        }
            return res;

    }

    @Override
    public double calculate() {
      double res=0;
        try {
            for(double i=0; i<n; i++){
                res+=FunctionToDouble(f.calculate(function,(a+getSegments()*(i+0.5))));
            }
        } catch (ScriptException e) {
            System.out.println("Error");
        }
        return res*getSegments();
    }

    @Override
    public double getRate() {
        double rate = calculate();
        n = 20;
        rate -= calculate();
        n=10;
        return rate;
    }

    @Override
    public double getSegments() {
        return (b-a)/n;
    }
}
