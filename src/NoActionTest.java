import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NoActionTest {
  @Test
  public void testNoAction() {
    NoAction noAction = new NoAction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    InterimResult answerResult = noAction.execute(result, '+');
    
    assertEquals(result, answerResult);
  }


 
  

}