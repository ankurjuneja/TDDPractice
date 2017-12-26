import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactorTest {

    PrimeFactor primeFactor;
    List<Integer> primeFactors;

    @Before
    public void setUp(){
        primeFactor = new PrimeFactor();
        primeFactors = new LinkedList<>();

    }

    @Test
    public void shouldRetunListOfInt(){
        Assert.assertEquals(primeFactors,primeFactor.generate());
    }

}
