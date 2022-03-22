//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW76 - We Got a Little Ol' Convoy
//2022-03-14m
//time spent: 1.5h
/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = new LLNode(null,null);
    _size = 0;
    // YOUR CODE HERE
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    //_head.setNext(new LLNode(newVal, null));
    LLNode temp = _head;
    _head = new LLNode(newVal,temp);
    _size++;
    return true;
    /*
    if (_head.getCargo() == null) {
      temp.setCargo(newVal);
      _size += 1;
      return true;
    } else {
      while (temp.getNext() != null) {
        temp = _head.getNext();
      }
      temp.setNext(new LLNode(newVal, null));
      _size += 1;
      return true;
    }
    */

    // YOUR CODE HERE
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    LLNode temp = _head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getCargo();
    // YOUR CODE HERE
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }
    LLNode temp = _head;
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
    String s = "[";
    try {
      for (int i = 0; i < _size; i++) {
        s += this.get(i) + ", ";
      }
    } catch (Exception e) {
      s += "null";
    }
    return s + "]";
    // YOUR CODE HERE
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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
