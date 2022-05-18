// Big Bird :: Raven (Ruiwen) Tang, Jun Hong Wang, Michael Kamela
// APCS pd6
// HW99 -- Some Are More Equal Than Others, Codified
// 2022-05-15m
// time spent: 0.8 hrs

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
  ArrayList<Integer> pq;

  public ArrayPriorityQueue() {
    pq = new ArrayList();
  }

  //O(1) runtime because it just adds to the arraylist
  //could also be O(n) if arraylist is full
  public void add(int x) {
    pq.add((Integer)x);
  }

  //O(1), because it just checks the size of the arraylist
  public boolean isEmpty() {
    if (pq.size() != 0) {
      return false;
    }
    return true;
  }

  //O(1) if the size of the AL is 0 or 1
  //O(n) if the al does not contain 0 or 1 element
  public int peekMin() {
    if (pq.size() == 0) {
      throw new RuntimeException();
    }
    //initializes int for return
    int min = pq.get(0);
    if (pq.size() == 1) {
      return min;
    }
    for (int i = 1; i < pq.size(); i++) {
      if (min > pq.get(i)) {
        min = pq.get(i);
      }
    }
    return min;
  }

  public int removeMin() {
    if (pq.size() == 0) {
      throw new RuntimeException();
    }
    int min = pq.get(0);
    int minInd = 0;
    if (pq.size() == 1) {
      pq.remove(0);
      return min;
    }
    for (int i = 1; i < pq.size(); i++) {
      if (min > pq.get(i)) {
        min = pq.get(i);
        minInd = i;
      }
    }
    pq.remove(minInd);
    return min;
  }

  //for easier viewing, not sure if this is the best toString
  public String toString() {
    String output = "";
    for (int i = 0; i < pq.size() - 1; i++) {
      output += pq.get(i) + ", ";
    }
    if (pq.size() > 0) {
      output += pq.get(pq.size() - 1);
    }
    return output;
  }

  public static void main(String[] args) {
    ArrayPriorityQueue apq = new ArrayPriorityQueue();
    System.out.println(apq.isEmpty()); //true
    apq.add(-50);
    for (int i = 0; i < 10; i++) {
      apq.add(i);
    }
    apq.add(-100);
    System.out.println(apq.isEmpty()); //false
    System.out.println(apq);
    System.out.println(apq.peekMin());
    System.out.println(apq.removeMin());
    System.out.println(apq + "\n");

    while (apq.isEmpty() == false) {
      System.out.println(apq.removeMin());
      System.out.println(apq);
    }
  }
}
