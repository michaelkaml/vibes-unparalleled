// Big Bird :: Raven (Ruiwen) Tang, Jun Hong Wang, Michael Kamela
// APCS pd6
// HW102 -- Heap On Heapin' On
// 2022-05-17t
// time spent: 1.0 hrs

/*
DISCO:
Parent node: (n - 1) / 2
LC: 2n + 1
RC: 2n + 2
The heap is always complete, no matter what we do to it.
The children and parent of any node can be found in constant time using the formulas.

QCC:
Is there a use for the minOf() method?
Does using it make the code simpler?

It's nice that insertion is logn, while maintaining order at the same time.
Linear collections do insertion (add-at-index, not add) in O(n), which takes a lot more time.

Having an AL-based implementation of a heap is nice, since we don't need to check the nodes, the size tells us how many significant values there.
This makes comparisons a lot easier, since we know exactly where a child is using 2n + 1 and 2n + 2.

The parentheses got really confusing, so we organized the code a little differently to maintain readability.

We decided to throw a runtime exception, since that's what we did in a priority queue.
Is there another exception that would better describe what goes wrong when we try to remove from an empty heap?
*/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String output = "";
    for (int i = 0; i < _heap.size() - 1; i++) {
      output += _heap.get(i) + ", ";
    }
    if (_heap.size() >= 1) {
      output += _heap.get(_heap.size() - 1);
    }
    return output;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    if (_heap.size() == 0) {
      return true;
    }
    return false;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   check if size is 0, if so, throw exception
   */
  public Integer peekMin()
  {
    if (_heap.size() == 0) {
      throw new RuntimeException();
    }
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * <your clear && concise procedure here>
   place new element at end of AL (then taking size, noting that)
   compare that element to the parent (using n-1/2), swap if parent is greater
   repeat until parent is less than node or hit root node
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal);
    int ind = _heap.size() - 1;
    while ((ind - 1) / 2  >= 0 && _heap.get((ind - 1) / 2) > addVal) {
      swap(ind, (ind - 1) / 2);
      ind = (ind - 1) / 2;
    }
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * <your clear && concise procedure here>
   check if size is 0, if so, throw exception
   if only root, then call AL remove method
   find last element, put value in root, compare to children
   swap with lesser of the children
   repeat until node is in right place, or until less than 2 children
   return removed val
   */
  public Integer removeMin()
  {
    if (_heap.size() == 0) {
      throw new RuntimeException();
    }
    Integer retVal = _heap.get(0);
    int ind = 0;
    if (_heap.size() == 1) {
      return _heap.remove(0);
    }
    _heap.set(0, (_heap.remove(_heap.size() - 1)));
    while ((2 * ind) + 1 < _heap.size() &&
    (2 * ind) + 2 < _heap.size() &&
    (_heap.get((2 * ind) + 1) < _heap.get(ind) ||
    _heap.get((2 * ind) + 2) < _heap.get(ind))) {
      int temp = minChildPos(ind);
      swap(ind, minChildPos(ind));
      ind = temp;
    }
    return retVal;
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   2n+1 is LC
   2n+2 is RC
   */
  private int minChildPos( int pos )
  {
    if (pos > _heap.size() || ((2 * pos) + 2) > _heap.size() || ((2 * pos) + 1) > _heap.size()) {
      return -1;
    }
    if (_heap.get((2 * pos) + 1) > _heap.get((2 * pos) + 2)) {
      return (2 * pos) + 2;
    }
    return (2 * pos) + 1;
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
