import org.junit.Test;

import static org.junit.Assert.*;

public class RiemannSumTest {
    @Test
    public void Summ(){
        RiemannSum sum = new RiemannSum(1.0,2, "x");
        assertEquals(2.5,sum.calculate(),0.5);
    }

    @Test
    public void Summ2(){
        RiemannSum sum = new RiemannSum(0,2, "x*x*x");
        assertEquals(4,sum.calculate(),0.5);
    }
    @Test
    public void SummSin(){
        RiemannSum sum = new RiemannSum(0,2, "sin(2*(2+x))");
        assertEquals(-0.25,sum.calculate(),0.5);
    }

    @Test
    public void SummCos(){
        RiemannSum sum = new RiemannSum(0,2, "cos(3.14-50)");
        assertEquals(0.87,sum.calculate(),0.5);
    }

}