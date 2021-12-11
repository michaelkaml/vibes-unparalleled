
/*
SWAG SWASH = Salaj Rijal, Ariel Fuchs, Michael Kamela
APCS
HW 45 -- Array of Titanium -- Implement a Interface for SuperArray
2021-12-08
time spent: .5 hours

DISCO:
-Unlike SuperClasses, Interfaces do not provide you with premade functionality, rather
they are just guidelines on what a certain class must contain.

-


QCC:
-What is the advanctage of Interface rather than listener

-How exactly do you test ListInt?

-Should there be a if statement to check if index>=size for every method that takes in index
(not just add-at-index)

*/

public class SuperArray implements ListInt {
    ///INSTANCCE VARS
    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray

    ///CONSTRUCTORS
    //default constructor – initializes 10-item array
    public SuperArray()
    {
    _data = new int[10];
    _size = 0;
    }

    //METHODS
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
        if( index >= _size ){
            System.out.println("Sorry Index out of Range!");
            return -1;
        }
        return _data[index];
    }

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
        if( index >= _size ){
            System.out.println("Sorry Index out of Range!");
            return -1;
        }
        int temp = _data[index];
        _data[index] = newVal;
        return temp;
    }

    public void add( int newVal ){
        _data[_size] = newVal;
        _size++;
    }

    public void add( int index, int newVal ){
        if( index >= _size ){
            System.out.println("Sorry Index out of Range!");
            return;
        }
        for( int i = _size; i > index ; i--){
            _data[i] = _data[i-1];
        }
        _data[index] = newVal;
        _size++;
    }

    public void remove( int index ){
        if( index >= _size ){
            System.out.println("Sorry Index out of Range!");
            return;
        }

        for( int i = index ; i <= _size; i++){
            _data[i] = _data[i+1];
        }
        _size--;
    }

    public int size(){
        return _size;
    }

    public static void main(String[] args) {
        
        SuperArray tester = new SuperArray();

        System.out.println( "Values: " + tester + "\nSize: " + tester.size() );

        for( int i = 0; i < 10; i++){
            tester.add(i);
        }

        System.out.println( "Values: " + tester + "\nSize: " + tester.size() );

        tester.expand();

        tester.add(5, 100);
        tester.add(6, 101);

        System.out.println( "Values: " + tester + "\nSize: " + tester.size() );

        tester.remove(0);
        tester.remove(tester.size()-1);
        
        System.out.println( "Values: " + tester + "\nSize: " + tester.size() );
    }

}
