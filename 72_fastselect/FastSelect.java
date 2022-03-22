// Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
// APCS pd6
// HW 72: So So Fast
// 2022-03-08
// time spent: 1 hr
/*
DISCO:

QCC:
In class, you mentioned that some groups got this to work in logn time.
On @589 on Piazza, you confirmed that you did say logn, and it's up to us to find out if that was a slip.
On one hand, it could be, since using partition would mean that the algorithm would have at least an O(n) classification,
but on the other hand, it is called fastSelect, and there may be a better way to do this.

In the end, we couldn't figure out a way to make this go any faster, so we ended up with an O(n) classification.
This is because partition is a O(n) operation, and the extra for loop in fast select performs only constant time operations n times, another O(n) operation.
In total, we end up with a O(n) operation.

In the for loops, we should see the array printed from least to greatest, but that doesn't seem like the case in the beginning.
Why is that?

*/

public class FastSelect {
  /*
  * Preconds: there are less than or y elements in the array and there are not repeating values
  * Postconds: returns the yth smallest element
  * Algo:
  1) Partition the array at position y+1
  2) Iterate through the array to the left of the pivot index and find the greatest value
  * O(n)
  * Worst Case: You are searching for the greatest value in the array
  * Best Case: You are searching for the smallest value in the array
  */
  public static int fastSelect(int[] arr, int y) {
    Mysterion.partition(arr, 0, arr.length-1, y-1);
    int max = arr[0];
    for (int i = 1; i < y; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr1 = {8,21,17,69,343};
    int[] arr2 = {3,0,16,599,2,234,23,4,231,12,432,24};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};
    int[] arr6 = {9,8,7,6,5,4,3,2,1,0};
    int[] arr7 = {1000,160,619,526,763,123,267,28,10,1};

    System.out.println("Test cases for individual arrays and positions of y");

    //test cases for individual arrays and positions of y
    System.out.println(fastSelect(arr5, 1));
    System.out.println(fastSelect(arr5, 2));
    System.out.println(fastSelect(arr5, 3));
    System.out.println(fastSelect(arr5, 4));
    System.out.println(fastSelect(arr5, 5));

    System.out.println("Test cases array and all positions of y");
    //test cases for an array and all positions
    for (int i = 1; i <= arr2.length; i++) {
      System.out.println(fastSelect(arr2, i));
    }

    for (int i = 1; i <= arr6.length; i++) {
      System.out.println(fastSelect(arr6,i));
    }

    for (int i = 1; i <= arr7.length; i++) {
      System.out.println(fastSelect(arr7,i));
    }
  }
}
