//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW81 - Thank You, Next
//2022-03-23
//time spent: 0.7h

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for (Integer i: L) {
      if (i == key) {
        return true;
      }
    }
    return false;
    /*** YOUR IMPLEMENTATION HERE ***/
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator<Integer> it = L.iterator();
    while (it.hasNext()) {
      if (it.next() == key) {
        return true;
      }
    }
    return false;
    /*** YOUR IMPLEMENTATION HERE ***/
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    ArrayList<Integer> odd = new ArrayList<>();
    for (Integer i: L) {
      if (i % 2 == 1) {
        odd.add(i);
      }
    }
    return odd;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    ArrayList<Integer> odd = new ArrayList<>();
    Iterator it = L.iterator();
    while(it.hasNext()) {
      Integer i = (Integer)it.next();
      if (i % 2 == 1) {
        odd.add(i);
      }
    }
    return odd;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while (it.hasNext()) {
      Integer i = (Integer)it.next();
      if (i % 2 == 0) {
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList<>();

    for ( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for (Integer i : L) {
      System.out.println(i);
    }

    // b) explicitly using an iterator
    System.out.println("");
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for ( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for ( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
