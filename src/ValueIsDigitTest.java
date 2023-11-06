import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValueIsDigitTest {
  @Test
  public void testDigits() {
    ValueIsDigitAction valueIsDigitAction = new ValueIsDigitAction();
    InterimResult result = new InterimResult(0, 1, 0);
    
    char[] testDigits = "0123456789".toCharArray();
    
    for (int i = 0; i < testDigits.length; i++) {
      double answerResult = valueIsDigitAction.execute(result, testDigits[i]).getV();
      
      assertEquals(i, answerResult, 0.01);
    }
  }
}