/*
Swashbucklers: Salaj Rijal, Ariel Fuchs, Micheal Kamela
APCS
HW 35 -- null -- Complete "ShortTask" from class on Monday (half-day)
2021-11-15
time spent: .4 hours

DISCO:
-For iteration, it is best to create a flowchart, but for recursion creating a
recipe is better
-While creating your own implementation is good practice, java.util.Arrays is 
very useful for methods surronding arrays


QCC:
-What other helper methods can we implement?
-After this HW, can we start using java.util.Arrays to help us

*/
public class Loopier{

  public static String arrayToString( int[] array){
    /**
     * converts an int array to a string
     */
    String result = "[";
    for(int number: array){
      result += Integer.toString(number) + ", ";
    }
    result = result.substring(0, result.length()-2) + "]";
    return result;
  }

  public static void populate( int[] array ){
    /**
     * populates an int array with random integers
     */
    for(int i=0; i < array.length; i = i + 1){
        array[i] = (int) ( Math.random() * Math.pow(2, 32) );
    }
  }

  //To help for recursion
  public static int[] subArray( int[] array, int beg){
    int[] result = new int[array.length - beg];
    for( int i = beg; i < array.length; i++){
      result[i-1] = array[i];
    }
    return result;
  }

  public static int linSearch( int[] array, int target){
    for(int i = 0; i < array.length; i++){
      if(array[i] == target) return i;
    }
    return -1;
  }

  public static int linSearchR( int[] array, int target){
    if( array[0] == target){
      return 0;
    }
    if( array.length == 1){
      return -1;
    }
    int resultBefore = linSearchR( subArray(array, 1), target );
    if( resultBefore == -1) return -1;
    else return resultBefore + 1;
  } 

  public static int freq( int[] array, int target){
    int count = 0;
    for( int number: array){
      if(number == target) count++;
    }
    return count;
  }

  public static int freqRec( int[] array, int target){
    if(array.length == 1){
      if(array[0] == target) return 1;
      return 0;
    }
    if( array[0] == target) return freqRec( subArray(array, 1), target) + 1;
    return freqRec( subArray(array, 1), target);
  }



  public static void main(String[] args) {
    //test of arrayToString
    int[] michael = {1, 2, 3, 4, 5, 6, 7, 8, 69};
    System.out.println( arrayToString(michael) );

    //test of populate
    int[] salaj = new int[10];
    populate(salaj);
    System.out.println( arrayToString(salaj) );

    //helpful arrays
    int[] ariel = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1};    
    int[] george = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    
    //test of linSearch
    System.out.println( linSearch(ariel, 0) + "...expecting 9");
    System.out.println( linSearch(george, 0) + "...expecting -1" );

    //test of linSearchR
    System.out.println( linSearchR(ariel, 0) + "...expecting 9");
    System.out.println( linSearchR(george, 0) + "...expecting -1");

    //test of freq
    System.out.println( freq(ariel, 1)  + "...expecting 15");
    System.out.println( freq(george, 0) + "...expecting 0");
    System.out.println( freq(ariel, 0)  + "...expecting 1");
    System.out.println( freq(george, 1) + "...expecting 14" );

    //test of freqRec
    System.out.println( freqRec(ariel, 1)  + "...expecting 15");
    System.out.println( freqRec(george, 0) + "...expecting 0");
    System.out.println( freqRec(ariel, 0)  + "...expecting 1");
    System.out.println( freqRec(george, 1) + "...expecting 14" );
  }
}
