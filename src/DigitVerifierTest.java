import static org.junit.Assert.*;

import org.junit.Test;

public class DigitVerifierTest {
  
  /**
   * Test that digit input verifier works with digits.
   */
  @Test
  public void testDigits() {
    DigitInputVerifier digitInputVerifier = new DigitInputVerifier();
    
    char[] digitCharArray = "1234567890".toCharArray();
    
    // Check every digit 0-9
    for (int i = 0; i < digitCharArray.length; i++) {
      char testCharDigit = digitCharArray[i];
      
      boolean isDigit = digitInputVerifier.meetsCriteria(testCharDigit);
      
      assertTrue(isDigit);
    }
  }
  
  /**
   * Test all alphabet characters return false with digit input verifier
   */
  @Test
  public void testAlphabet() {
    DigitInputVerifier digitInputVerifier = new DigitInputVerifier();
    
    char[] alphabetCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    // Check each lower and uppercase letter
    for (int i = 0; i < 52; i++) {
      char testCharNonDigit = alphabetCharArray[i];
      
      boolean isDigit = digitInputVerifier.meetsCriteria(testCharNonDigit);
      
      assertFalse(isDigit);
    }
    
    
  }
}
  
