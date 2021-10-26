/*Team Name (Orion Roven, Michael Kamela)
APCS
HW23_Coin - What Does Equality Look Like
10/23/21
Time Overlapsed - 1hr 25 minutes

DISCO:
Math.random() return value from 0.0 to 1.0
If we set bias in flip(), and not the default constructor, it works!
methods can take object parameters
public <ReturnType> <MethodName> (<ClassName> <ObjectName>){
  //can now use System.out.println(<ObjectName>.upFace);
}


QCC:
Even when the Math.random() is less than bias, it still return tails.
Not really sure why tho.
Why do we need assignValue if we aren't calculating the value of the coins?

*/

public class Coin {

  //attributes aka instance vars
  public double value;
  public String upFace;
  public String name;
  public int flipCtr;
  public int headsCtr;
  public int tailsCtr;
  public double bias;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    upFace = "heads";
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    name=s;
    upFace="heads";
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    name=s;
    upFace=nowFace;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (s == "penny") {
      value = 0.01;
    } else if (s == "nickel") {
      value = 0.05;
    } else if (s == "dime") {
      value = 0.10;
    } else if (s == "quarter") {
      value = 0.25;
    } else if (s == "dollar") {
      value = 1.00;
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    upFace=s;
    bias=d;
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    bias=.5;
    double result = Math.random();
    if (result>=bias) {
      upFace="tails";
      tailsCtr+=1;
    } else {
      upFace="heads";
      headsCtr+=1;
    }
    flipCtr+=1;
    return upFace;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    if (upFace==other.upFace){
      return true;
    } else {
      return false;
    }
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    return name+" -- "+upFace;
  }

}//end class
