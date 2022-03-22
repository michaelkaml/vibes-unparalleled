// Clyde Sinclair
// APCS pd0
// HW71 -- Reading for intent, tracing for VICTORY
// 2022-03-07m
// time spent:  hrs

/***
 * SKEELTON for
 * class partition
 * tests preliminary hypotheses re: utility of mystery algo
 *
 * <h1>It's a Bird, It's a Plane! It's.... partition</h1>
 * The partition method ... <YOUR TRIO'S DESCRIPTION HERE>
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 *
 * DISCO
 *
 * QCC
 *
 * q0: What does it do?
 * a0:
 *
 * q1: O(?)
 * a1:
 *
 ***/


public class Mysterion
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
   * int partition(int[],int,int,int)
   * DESCRIP
   *
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int
   *
   */
  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end partition

}//end class partition
