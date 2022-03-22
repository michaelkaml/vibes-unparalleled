//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW76 - We Got a Little Ol' Convoy
//2022-03-14m
//time spent: 1.5h

/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a Object

  extra:
  previous node dllnode
 **/

public class DLLNode
{
  //instance vars
  private Object _cargo;
  private DLLNode _nextNode;
  private DLLNode _prevNode;

  // constructor
  public DLLNode( Object value, DLLNode prev , DLLNode next)
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public Object getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }

  public DLLNode getPrev() {
    return _prevNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public Object setCargo( Object newCargo )
  {
    Object foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev(DLLNode newPrev) {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toObject
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null , null);

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null , null) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null , null) );

    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
         System.out.println( first );
         first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: garbage collector reclaims that memory

    //  so, better: (w/o moving first)
    /*
      DLLNode temp = first;
      while( temp != null ) {
        System.out.println( temp );
        temp = temp.getNext();
      }
    */

  }//end main

}//end class DLLNode
