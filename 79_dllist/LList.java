//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW79 - A YouTube Host Are You
//2022-03-17th
//time spent: 1.0h
/***
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 **/

 /*
DISCO:

QCC:
added helper methods from library, refactored some code to comply more with library code

we assume that we're setting up (eventually) for a circular linked list?
 */

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = _tail = null;

    _size = 0;
    // YOUR CODE HERE
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
    {
      addLast(newVal);
      return true;
    }

  /*
  algo:
  set a temp variable to _head
  special case if index == 0, we just do default add with string

  traverse through list, setting the temp to the node after it until index - 1
  then we set the next of the temp to a new DLLNode with newVal, the next value of temp, and temp itself
  then increment _size
  */
  public void add(int index, String newVal) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      addFirst(newVal);
    } else if (index == size() - 1) {
      addLast(newVal);
    } else {

      DLLNode temp = _head;

      if (index == 0) {
        this.add(newVal);
        return;
      }

      for (int i = 0; i < index - 1; i++) {
        temp = temp.getNext();
      }

      temp.setNext(new DLLNode(newVal, temp, temp.getNext()));
      _size++;
    }
  }

  public void addFirst( String newFirstVal )
  {
    //insert new node before first node (prev=null, next=_head)
    _head = new DLLNode( newFirstVal, null, _head );

    if ( _size == 0 )
      _tail = _head;
    else
      _head.getNext().setPrev( _head );
    _size++;
  }


  public void addLast( String newLastVal )
  {
    //insert new node after last node (prev=_last, next=null)
    _tail = new DLLNode( newLastVal, _tail, null );

    if ( _size == 0 )
      _head = _tail;
    else
      _tail.getPrev().setNext( _tail );
    _size++;
  }

  /*
  algo:
  using similar idea to add at index, we get everything after index we want to remove, save that in temp node
  everything else will be saved in another node, and the last element - 1 will be set to point to after temp node
  node removed will be saved before deletion, and will be returned

  at the end, get the next node of temp, then set the prev of that to temp

  optimised/refactored, fewer variables
  */
  public String remove(int index) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {return removeFirst();}
    else if (index == size()- 1) {return removeLast();}
    else {

      DLLNode temp = _head;

      for (int i = 0; i < index - 1; i++) {
        temp = temp.getNext();
      }

      String removed = temp.getNext().getCargo();

      temp.setNext(temp.getNext().getNext());
      temp.getNext().setPrev(temp);
      _size--;
      return removed;
    }
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    DLLNode temp = _head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getCargo();
    // YOUR CODE HERE
  }

  public String getFirst() {return _head.getCargo();}

  public String getLast() {return _tail.getCargo();}

  public String removeFirst()
    {
      String retVal = getFirst();
      if ( size() == 1 ) {
        _head = _tail = null;
      }
      else {
        _head = _head.getNext();
        _head.setPrev( null );
      }
      _size--;
      return retVal;
    }

    public String removeLast()
    {
      String retVal = getLast();
      if ( size() == 1 ) {
        _head = _tail = null;
      }
      else {
        _tail = _tail.getPrev();
        _tail.setNext( null );
      }
      _size--;
      return retVal;
    }

  public String set( int index, String newVal )
  {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }
    DLLNode temp = _head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    String old = temp.getCargo();
    temp.setCargo(newVal);
    return old;
    // YOUR CODE HERE
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
    // YOUR CODE HERE
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    james.add("test");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    //this should not appear in the final ll
    james.add(3,"added at index");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.remove(3);
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    //default string list
    System.out.println("New item, default LL");
    LList magic = new LList();

    magic.add("prongs");
    magic.add("padfoot");
    magic.add("wormtail");
    magic.add("moony");
    System.out.println( magic );
    System.out.println( "size: " + magic.size() );

    magic.add(3, "thluffy");
    System.out.println( magic );
    System.out.println( "size: " + magic.size() );

    magic.add(2, "imposr");
    System.out.println( magic );
    System.out.println( "size: " + magic.size() );

    magic.remove(2);
    System.out.println( magic );
    System.out.println( "size: " + magic.size() );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
