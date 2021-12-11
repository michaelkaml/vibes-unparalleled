/*
SWAG SWASH : Ariel Fuchs, Salaj Rijal, Micheal Kamela
APCS
HW 40 -- 2D Array Work: using loops to help write methods for 2D arrays
2021-11-30
time spent: .33 hrs

DISCO:
-You can access the length for an array in a array but doing a[i].length;
i being the index of the array in question.

-For each is really helpful when creating these methods as we dont really need indexes.

-When nesting for loops, make sure that the variables in the 2 for loop statements are 
different. (With for-each you avoid this problem)

QCC:
-Is there another way to do this without nesting for loops?

-Is there a built in method that can help us?

-What limit is there on the dimensions of an array?... is there a  (2^32)D?

*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    //for loop for columns
    for(int i = 0; i < a.length; i++){
      //for loop for rows
      for(int x = 0; x < a[i].length; x++){
        System.out.print( a[i][x] + " " );
      }
      System.out.println();
    }
	
    System.out.println();
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    
    //Loop through outer array
  	for( int[] smallerArray: a ){
      
      //Loop through inner array
      for( int number: smallerArray){
        System.out.print( number + " ");
      }
      
      System.out.println();
	}
    
    System.out.println();
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    //for loop for columns
    int counter = 0;
    for(int i = 0; i < a.length; i++){
 	  
      //for loop for rows
      for(int x = 0; x < a[i].length; x++){
        counter = counter + a[i][x];
      }
      
    }
    
    return counter;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int[][] m )
  {
    int count = 0;
    
    for(int i = 0; i < m.length; i++){
      count = count + sumRow(i, m);
  	}

    return count;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int counter = 0;
    for(int i = 0; i < a[r].length; i++){
      counter = counter + a[r][i];
    }
    
    return counter;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int summer = 0;
	
    for( int number: m[r]){
      summer += number;
    }
    
    return summer;
  }


  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
    
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);
    
      System.out.print("\ntesting sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
    
      System.out.print("\ntesting sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
      
      System.out.println("\ntesting for sumRow2....\n");
      System.out.println("sum row : " + sumRow2( 0, new int[][] { {1, 1, 1}, {2, 2, 2}, {3, 3, 3} })  );  
      System.out.println("sum row : " + sumRow2( 1, new int[][] { {1, 1, 1}, {2, 2, 2}, {3, 3, 3} })  );
      System.out.println("sum row : " + sumRow2( 2, new int[][] { {1, 1, 1}, {2, 2, 2}, {3, 3, 3} })  );
    
    
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray
