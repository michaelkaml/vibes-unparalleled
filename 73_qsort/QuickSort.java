//Blonde Himbos: Hugo Jenkins + Boary, Micheal Kamela, Jun Hong Wang
//APCS pd6
//HW72 -- QuickSort
//2022-03-09w
//time spent: 1.7h

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * We check if the array is in any of these three conditions:
     If the array's length is less than 2 (so length = 0 or 1), then the array is sorted, and we return.
     If the left bound is greater than the right bound, then we also return, because this shouldn't happen.
     If the left bound is less than 0, it is out of the array, so we also return.
   For the first pivot position chosen, it's the middle element (median), and we use that to partition the array.
   The new pivot position is set to what the partition method returns.

   We then recursively call the helper method, with left and right bounds.
   In the helper method, the pivot position is randomly chosen by using Math.random.
 * 2a. Worst pivot choice and associated run time:
 * We think that the last index will be the worst, since using that for partitioning won't give us much.
   If we keep doing the last index, then we pretty much end up with a selection sort?
   with O(n^2) runtime.

 * 2b. Best pivot choice and associated run time:
 * We think it should be the middle, because it divides the array up perfectly, resulting in logn for the division part.
   In total, it will run in nlogn time, since the number of "divison levels" depends on the size of the array.

 * 3. Approach to handling duplicate values in array:
 * We went with the one given to us in the partition skeleton: if arr[i] <= v, we swap.
   This means all dupes will be sent to the left, however, our partition method does not seem to do that at the moment,
   because we run out of space in the left.
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    if (d.length < 2) {
      return;
    }

    int pvt = d.length / 2;
    //System.out.println(d[pvt]);

    //chooses a new partition based on what partition returns
    pvt = Partition.partition(d, 0, d.length - 1, pvt);

    qsortHelper(d, 0, pvt - 1);
    qsortHelper(d, pvt + 1, d.length - 1);
  }

  //you may need a helper method...
  /*
  used for extra given information, such as the left and right, since this is an in-place sort
  we cannot allocate any extra memory for a copy of the array, so we have ot know where the boudns are for sorting
  this method is very similar to the other one, except the partition choice, which we settled on a random one.
  */
  public static void qsortHelper(int[] d, int left, int right) {
    if (left > right ||
    left < 0 ||
    d.length < 2) {
      return;
    }

    int pvt = (right + left)/2;
    //System.out.println(d[pvt]);
    pvt = Partition.partition(d, left, right, pvt);


    qsortHelper(d, left, pvt - 1);
    qsortHelper(d, pvt + 1, right);
  }




  //main method for testing
  public static void main( String[] args )
  {
    int [] best = {1,3,5,7,7,12};
    System.out.println("Best case before sort: ");
    printArr(best);
    System.out.println("Best case after sort: ");
    qsort(best);
    printArr(best);

    int [] worst = {3,7,7,12,1,5};
    System.out.println("Worst case before sort: ");
    printArr(worst);
    System.out.println("Worst case after sort: ");
    qsort(worst);
    printArr(worst);

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
