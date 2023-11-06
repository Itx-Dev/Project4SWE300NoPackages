import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ContinuingFactionTest {
  @Test
  public void testContinuingFaction() {
    ContinuingFactionAction continuingFactionAction = new ContinuingFactionAction();
    InterimResult result = new InterimResult(0.1, 1, 0);
    
    double resultOfV = continuingFactionAction.execute(result, '9').getV();
    
    assertEquals(0.9, resultOfV, 0.01);
  }
  

}