/*
Swag Trio: Max Schneider, Jason Yang, Michael Kamela
APCS
HW26 -- GCD Three Ways/Stats.java/Created 3 methods for determining GCD
2021-10-27
.4
Disco:
There are many ways to achieve one thing. Returning something ends the method. Can use this to my advantage to make code cleaner
QCCs:
Are ther certain times when one of these is better than the others?
ALGO
gcd: Starting with one, check every number below or equal to the first integer in ascending order. If the 2 intergers can be divided by the number, it is the new answer. When you get to the end the most recent answer is returned


*/

public class Stats {
  public static int gcd( int a , int b) {
      int c = 1;
      int answer = 0;
      while (c <= a) {
        if (a%c==0 && b%c==0) {
          answer=c;
          }
        c++;
        }
      return answer;
  }
  public static int gcdER (int a , int b) {
      if (a==b) {
        return a;
      }
      else if (a>b) {
        return gcdER(a-b,b);
      } else {
        return gcdER(a,b-a);
        }
  }
  public static int gcdEW (int a, int b) {
      while (a!=b) {
        if (a > b) {
          a-=b;
        } else {
          b-=a;
        }
      }
    return a;
  }
    
  public static void main(String[] args) {
    
      System.out.println("gcd method: Should print 1, 3, 1, 112");
      Stats Stat1 = new Stats();
      System.out.println(Stat1.gcd(1,3));
      System.out.println(Stat1.gcd(3,9));
      System.out.println(Stat1.gcd(213,214));
      System.out.println(Stat1.gcd(112,224));
                       
      System.out.println("gcdER method: Should print 1, 3, 1, 112");
      Stats Stat2 = new Stats();
      System.out.println(Stat2.gcdER(1,3));
      System.out.println(Stat2.gcdER(3,9));
      System.out.println(Stat2.gcdER(213,214));
      System.out.println(Stat2.gcdER(112,224));
                         
      System.out.println("gcdEW method: Should print 1, 3, 1, 112");
      Stats Stat3 = new Stats();
      System.out.println(Stat3.gcdEW(1,3));
      System.out.println(Stat3.gcdEW(3,9));
      System.out.println(Stat3.gcdEW(213,214));
      System.out.println(Stat3.gcdEW(112,224));
    
  }
}
    
      
