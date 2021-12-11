// SWAG SWASH
// APCS pd7
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
//time spent: 22 minutes

//DISCO:
//for each loop doesn't work the way Michael thought it did (lol)
//QCC:
//Can we make expand shorter

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = _data.length;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String blah = "[";
    for(int k:_data){
      blah += Integer.toString(k);
      blah += ",";
    }
    blah = blah.substring(0,blah.length()-1);
    blah += "]";
    return blah;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] a = new int[2*_size];
    for(int i=0;i<_data.length;i++){
      a[i]=_data[i];
    }
    _data = a;
    _size = _data.length;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int a = _data[index];
    _data[index] = newVal;
    return a;
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class