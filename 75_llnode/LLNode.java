//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW75 -- Nodal Recall
//2022-03-13m
//time spent: 0.75h
/*
QCC:
* Using this, could we refactor LLNode to make it possible to have a linked list of multiple data types. Maybe by making subclasses of LLNode?
DISCO:
* LLNode is a list but does not implement the List interface
*/

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  String value;
  LLNode next;
  // constructor
  public LLNode( String value, LLNode next )
  {
    this.value = value;
    this.next = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return value;
  }

  public LLNode getNext()
  {
    return next;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    this.value = newCargo;
    return this.value;
  }

  public LLNode setNext( LLNode newNext )
  {
    this.next = newNext;
    return this.next;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    String s = "";
    s += "["+value+", ";
    if (next != null) s += next.toString();
    s += "]";
    return s;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first.toString());
    /* A naive list traversal, has side effects.... ??
    */
       LLNode temp = first;
       while( temp != null ) {
       System.out.println( temp );
       temp = temp.getNext();
       }

    //System.out.println(first.toString());


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A:

    //...so better: ?
    //
    //
    //

  }//end main

}//end class LLNode
