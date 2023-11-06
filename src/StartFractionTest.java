import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StartFractionTest {
  @Test
  public void testStartFraction() {
    StartFraction startFraction = new StartFraction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    double resultOfP = startFraction.execute(result, '9').getP();
    
    
    assertEquals(0.1, resultOfP, 0.01);
    
    
  }

}