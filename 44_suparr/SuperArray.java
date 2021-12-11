/*
SWAG SWASH = Salaj Rijal, Ariel Fuchs, Michael Kamela
APCS
HW 44 - Array of Grade 316 -- SuperArray.add("more methods");
2021-12-07
time spent: .7 hours

DISCO:
-SuperArray.set() should not increase size thus for the first test case it makes sense that nothing is printed when you print
SuperArray Curtis
-for add-at-index you start at the last item in a list and move that first.
-you can use overloaded methods to help you create 2 essentially different methods with the same name
to help avoid complication

QCC:
-Shouldnt we add functionality to check wheter there is enough space for an addition? and if not to expand the array?
-How can we improve our code
*/


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
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String result = "[";
      for( int i = 0; i < _size; i++ ){
          if( i == _size-1 ){
              result+= Integer.toString( _data[i] );
          }
          else{
               result += Integer.toString(_data[i]) + ",";
          }
      }
      result += "]";
      return result;
  }



  //double capacity of SuperArray
  private void expand()
  {
      int[] _metaData = new int[ _data.length * 2];
      for( int i = 0; i < _size; i++){
          _metaData[i] = _data[i];
      }
      _data = _metaData; //QCC
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    //do we need to add functionality to check if index is within range _size?
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    //do we need to add functionality to check if index is within range _size?
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }

  public void add( int newVal ){
      _data[_size] = newVal;
      _size++;
  }

  public void add( int index, int newVal ){
    //do we need to add functionality to check if index is within range _size?
      for( int i = _size; i > index ; i--){
          _data[i] = _data[i-1];
      }
      _data[index] = newVal;
      _size++;
  }

  public void remove( int index ){
      for( int i = index; i < _size; i++){
          _data[index] = _data[index+1]; //this will not work if array is full
      }
      _size--;
  }

  public int size(){
      return _size;
  }


  //main method for testing
  public static void main( String[] args )
  {
      //Tests are copies from closet file
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
          System.out.println("new length of underlying array: "
          + curtis._data.length );
      }
      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
      System.out.println(Arrays.toString( mayfield._data));
      System.out.println(mayfield.size());
      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/

  }//end main()


}//end class
