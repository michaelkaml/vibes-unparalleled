/*
SWAG SWASH: Ariel Fuchs, Micheal Kamela, Salaj Rijal
APCS
HW 42 -- Be More Rational -- Adding on to Rational.java
2021-12-05
time spent: 2:33

DISCO:
-we can use the gcd from our old hw


QCC:
-is there a better way to do this
-why do we need 2 gcd methods


*/

public class Rational{

    ///Instance Variables
    private int numerator;
    private int denominator;

    ///Constructors
    //Default
    public Rational(){
      numerator = 0;
      denominator = 1;
    }

    //Overloaded
    public Rational(int num, int denom){
      //if 0 is inputted as denom
      if(denom == 0){
        System.out.println("ERROR: INVALID INPUT FOR DENOMINATOR");
        numerator = 0;
        denominator = 1;
      }
      //if not proceed as normal
      else{
          numerator = num;
          denominator = denom;
      }
    }

    ///Methods

    //Previous HW (WOrking Code)
    public int getDenominator(){
        /* return denominator */
      return denominator;
    }

    public int getNumerator(){
        /* return numerator */
        return numerator;
    }
    
    public String toString(){
      /* returns string representation */
      String result = "";
      result += "Numerator: " + Integer.toString(numerator);
      result += "\nDenominator: " + Integer.toString(denominator);
      result += "\n";
      return result;
    }
        
    public double floatValue(){
        /* return floating point approx. using double */
        return numerator/(double)denominator; //will this do integer division?
    }
    
    public void multiply(Rational multiple){
        /* multiplies object by the inputted object */
        numerator *= multiple.getNumerator();
        denominator *= multiple.getDenominator();
    }
    
    public void divide(Rational divisor){
        /* divides this object by the other object */
        //KEEP CHANGE FLIP
        numerator *= divisor.getDenominator();
        denominator *= divisor.getNumerator();
    }

    public int compareTo(Rational comparant){
        if (comparant.floatValue() == this.floatValue()){
            return 0;
        }
        else if( comparant.floatValue() > this.floatValue()){
            return -1;
        }
        return 1;
    }

    public void add(Rational addend){
        this.numerator = (this.numerator * addend.denominator) + (addend.numerator * this.denominator);
        this.denominator *= addend.denominator; 
    }
    
    public void subtract(Rational subtractant){
        this.numerator = (this.numerator * subtractant.denominator) - (subtractant.numerator * this.denominator);
        this.denominator *= subtractant.denominator; 
    }
    
    //Static
    public static int gcd(int a, int b){
        int counter;
        if(a>=b){
            counter = b;
        }
        else{
            counter = a;
        }
        while(counter>0){
            if(a%counter==0 && b%counter==0){
                return counter;
            }
            counter--;
        }
        return 0;
    }

    //Instance
    public int gcd(){
        return gcd(numerator, denominator);
    }

    public void reduce(){

        int gcd = this.gcd();
        numerator /= gcd;
        denominator /= gcd;

    }
    public static void main(String[] args){
		//TESTS TAKEN FROM PIAZZA (WITH MODIFICATOINS)
		//CREDIT TO TGT, TRL, TLL
		//Test1
        //Rational r0 = new Rational(10, 0);
		//System.out.println("\n" + r0);
		//Rational r1 = new Rational(10, 5);
		//Rational r2 = new Rational(3, 6);
		////Test2
        //System.out.println("\nR1:");
        //System.out.println(r1);
		//System.out.println("\nR2:");
        //System.out.println(r2);
		//System.out.println("\nMultiplying r1 by r2 gets you...");
		//r1.multiply(r2);
		//System.out.println(r1);
		//System.out.println("\nDividing that product with r2 gets you...");
		//r1.divide(r2);
		//System.out.println(r1);
		////Test3
		//Rational r3 = new Rational(2, 3);
		//Rational r4 = new Rational();
		//System.out.println("\nR3:");
		//System.out.println(r3);
		//System.out.println("\nR4:");
		//System.out.println(r4);
		//System.out.println("\nMultiplying r3 by r4 gets you...");
		//r3.multiply(r4);
		//System.out.println(r3);
		//System.out.println("\nDividing that product with r4 gets you...");
		//r3.divide(r4);
		//System.out.println(r3);

        //Test 4
        Rational r5 = new Rational(1, 2);
        Rational r6 = new Rational(1, 2);
        System.out.println("R5:\n" + r5);
        System.out.println("R6:\n" + r6);
        r5.add(r6);
        System.out.println(r5);
        r5.subtract(r6);
        System.out.println(r5);

        //Test 5
        Rational r7 = new Rational(3, 6);
        Rational r8 = new Rational(6, 3);
        System.out.println(r7 + "\n"+ r8);
        r7.reduce();
        r8.reduce();
        System.out.println(r7 + "\n"+ r8);

        //Test 6
        System.out.println( r5.compareTo(r6) );
        System.out.println( r7.compareTo(r8) );
        System.out.println( r8.compareTo(r7) );

      } //end of main
  } //end of class

      