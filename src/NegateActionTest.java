import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NegateActionTest {
  @Test
  public void testNegateAction() {
    NegateAction negateAction = new NegateAction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    InterimResult answerResult = negateAction.execute(result, '9');
    
    int actualS = answerResult.getS();
    
    assertEquals(-1, actualS);
  }
}