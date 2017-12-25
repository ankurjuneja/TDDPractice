

//import main.Calc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTest{

    private Calc calc;

    @Before
    public void setUp(){
        calc = new Calc();
    }

    @Test
    public void shouldReturnZeroWithEmptyString(){
        Assert.assertEquals(0,calc.add(""));
    }

    @Test
    public void shouldReturnNumberWithNumber(){
        Assert.assertEquals(2,calc.add("2"));
    }

    @Test
    public void shouldReturnSumWithTwoNumbersComma(){
        Assert.assertEquals(4,calc.add("1,3"));
    }

    @Test
    public void shouldReturnSumWithTwoNumbersNewLine(){
        Assert.assertEquals(4,calc.add("1\n3"));
    }

    @Test
    public void shouldReturnSumWithThreeNumber(){
        Assert.assertEquals(6,calc.add("1,2,3"));
        Assert.assertEquals(6,calc.add("1\n2,3"));
        Assert.assertEquals(6,calc.add("1\n2\n3"));
    }

    @Test
    public void shouldReturnSumWithAnyDelimeter(){
        Assert.assertEquals(4,calc.add("//;\n1;3"));
    }

    @Test (expected = RuntimeException.class)
    public void shouldThrowExceptionWithNegativeNumber(){
        calc.add("-1,2,3");
    }

    @Test
    public void shouldIgnoreNumberGreaterThanThousand(){
        Assert.assertEquals(2,calc.add("2,1001"));
    }
}