public class ConvertingMachine
{

  private final Edge[] machine =
  {
      new Edge(State.START, new DigitInputVerifier(),
          new ValueIsDigitAction(), State.INTEGER),
      new Edge(State.START, new MinusInputVerifier(), new NegateAction(),
          State.INTEGER),
      new Edge(State.START, new PlusInputVerifier(), new NoAction(),
          State.INTEGER),
      new Edge(State.START, new PeriodInputVerifier(),
          new StartFraction(), State.DECIMAL),
      new Edge(State.INTEGER, new DigitInputVerifier(),
          new ContinuingIntegerAction(), State.INTEGER),
      new Edge(State.INTEGER, new PeriodInputVerifier(),
          new StartFraction(), State.DECIMAL),
      new Edge(State.DECIMAL, new DigitInputVerifier(),
          new ContinuingFactionAction(), State.DECIMAL)

  };

  /**
   * @param text
   * @return value of v
   */
  public double parse(String text)
  {
    // Set initial state to START
    State currentState = State.START;
    // Create InterimResult variable with initial p = 0, s = 1, v = 0
    InterimResult result = new InterimResult(0, 1, 0);
    // Change given string to a char array to parse.
    char[] textCharArray = text.toCharArray();
    
    // Find matching edges that correspond with char at index i of char array.
    for (int i = 0; i < textCharArray.length; i++) {
      // Find Edge at current state with character of char array at index i.
      Edge currentEdge = searchForEdge(currentState, textCharArray[i]);
      // Store results of v, p, and s into result
      result = currentEdge.action.execute(result, textCharArray[i]);
      // Change the current state to the next state given by Edge.
      currentState = currentEdge.nextState;
    }
    
    // Get the sign and value stored in InterimResult.
    int s = result.getS();
    double v = result.getV();
    
    // Return sign times value.
    return (s * v);
  }

  private Edge searchForEdge(State currentState, char ch)
  {
    // Loop over each edge in table.
    for (int i = 0; i < machine.length; i++) {
      // Check that the current state matches the current edge's state
      // and the current character is succesfully verified for that current edge's state. 
      if (currentState == machine[i].currentState && 
          machine[i].inputVerifier.meetsCriteria(ch) == true) {
            return machine[i];
      }
    }
    // If no edges match throw number format exception.
    throw new NumberFormatException();
  }

  private class Edge
  {
    State currentState;
    InputVerifier inputVerifier;
    Action action;
    State nextState;

    public Edge(State currentState, InputVerifier inputVerifier,
        Action action, State nextState)
    {
      this.currentState = currentState;
      this.inputVerifier = inputVerifier;
      this.action = action;
      this.nextState = nextState;
    }
  }

  private enum State
  {
    START, INTEGER, DECIMAL, END
  }
}