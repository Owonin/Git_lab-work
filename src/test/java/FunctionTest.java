
import org.junit.Test;

import javax.script.ScriptException;

import static org.junit.Assert.*;

public class FunctionTest {

    Function f = new Function();

    @Test
    public void TestSimpleMath() {
        try {
            assertEquals(2, f.calculate("1+x", 1));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSimpleMath2() {
        try {
            assertEquals(34, f.calculate("1*x", 34));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSimpleMath3() {
        try {
            assertEquals(17, f.calculate("(34*x)/2", 1));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void TestSimpleMath4() {
        try {
            assertEquals(18.1, (Double) f.calculate("(34*x)/2", 1), 0.1);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSimpleMathWithDoubleParameter() {
        try {
            assertEquals(0.5, (Double) f.calculate("x/2", 1.0), 0.3);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSimpleMathWithDoubleParameterWithArithmeticEx() {
        try {
            assertEquals(1.0, (Double) f.calculate("(3.5+x)/0", 0.5), 0.3);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        catch (ArithmeticException e){
            System.out.println("Division by 0");
        }
    }

    @Test
    public void TestSimpleMathWithParameterWithScriptEx() {
        try {
            f.calculate("a+x", 1);
        } catch (ScriptException e) {
            System.out.println("Error");
        }
        catch (ArithmeticException e){
            System.out.println("Division by 0");
        }
    }

    @Test
    public void TestMath() {
        try {
            assertEquals(6, f.calculate("2*(2+1)", 1));
        } catch (ScriptException e) {
            System.out.println("Error");
        }
        catch (ArithmeticException e){
            System.out.println("Division by 0");
        }


    }
}