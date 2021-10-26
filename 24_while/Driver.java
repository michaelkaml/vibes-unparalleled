/***
Team Name (Orion Roven, Michael Kamela)
APCS
HW24_while - Get It While You Can
10/25/21
Time Elapsed - 1.0 hr
DISCO:
The very long while loop statement thing seems confusing and impractical, have yet to find a better solution tho.
CS is fun when you get stuff right
Had to separate the reset for each object (me.reset() and you.reset()).
QCC:
How can we make the while loop less confusing?
And why doesn't it work as is?
POST-V0 MODS:
Created method multiFlip


    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {
  public static void multiFlip(int x, int y, int birthYear, Coin me, Coin you) {
    me.reset("heads",0.5);
    you.reset("heads",0.5);
    int matchCtr = 0;
    while (me.headsCtr+you.headsCtr<x&&matchCtr<y&&(matchCtr<65536&&matchCtr%birthYear!=0)) {
      me.flip();
      you.flip();
      if (me.equals(you)){
        matchCtr += 1;
      } else {
        matchCtr = matchCtr;
      }
    }
    System.out.println(me.getFlipCtr());
    System.out.println(me.getHeadsCtr());
    System.out.println(me.getTailsCtr());
  }
  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin


    //test default constructor
      Coin mine = new Coin();

      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );

      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      multiFlip(200, 600, 2004, mine, yours);
      //test toString() methods of each Coin
      /*System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test flip() method
      System.out.println("\nAfter flipping...");
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "\nMatchee matchee!" );
        yours.matchCtr+=1;
      }
      else {
        System.out.println( "\nNo match. Firestarter you can not be." );
      }
*/
  }//end main()

}//end class
