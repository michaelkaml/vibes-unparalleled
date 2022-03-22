//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW77 - Insert|Remove
//2022-03-15t
//time spent: 1.5h
/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

 /*
DISCO:

QCC:
how can we make the algorithm more efficient, especially in terms of temp variables?
we feel that the code looks clunky (even though it works)

ALGO:
algos in block comments above the add at index and remove methods
they are both very similar
 */

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
    LLNode temp = _head;
    _head = new LLNode(newVal,temp);
    _size++;
    return true;
    /*
    //old code, misunderstood what we had to do in add, instead of adding at the end, we add at the front
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

  /*
  algo idea:
  traverse through array once, set temp node to everything after index
  then, do similar thing to what we did in add
  then iterate through the head until index - 1, then set everything after to temp
  then
  */
  public void add(int index, String newVal) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }

    LLNode temp = _head;
    LLNode tempAfter = _head;

    for (int i = 0; i < index; i++) {
      tempAfter = tempAfter.getNext();
    }
    LLNode added = tempAfter;
    tempAfter = new LLNode(newVal, added);

    for (int j = 0; j < index - 1; j++) {
      temp = temp.getNext();
    }
    temp.setNext(tempAfter);
    _size++;
    //for (int j = 0; )
  }

  /*
  algo:
  using similar idea to add at index, we get everything after index we want to remove, save that in temp node
  everything else will be saved in another node, and the last element - 1 will be set to point to after temp node
  node removed will be saved before deletion, and will be returned
  */
  public String remove(int index) {
    if ( index < 0 || index >= size() ) {
      throw new IndexOutOfBoundsException();
    }
    String removed = "";

    LLNode temp = _head;
    LLNode tempAfter = _head;

    for (int i = 0; i < index; i++) {
      tempAfter = tempAfter.getNext();
    }
    removed = tempAfter.getNext().getCargo();
    tempAfter = tempAfter.getNext();

    for (int j = 0; j < index - 1; j++) {
      temp = temp.getNext();
    }
    temp.setNext(tempAfter);
    //LLNode removed =
    _size--;
    return removed;
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

    //this should not appear in the final ll
    james.add(3,"added at index");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.remove(3);
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
