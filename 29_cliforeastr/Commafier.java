/*
Swag Trio- Max Schneider. Jason Yang. Michael Kamela
APCS
HW29 -- Which Way Do You Roll?/Recursion vs Iteration/Turned integers into strings with appropriae commas
2021-11-01
.9
Disco:
How to use char Arrays to turn a String into a list of its characters
How to turn a String into an integer and vice versa
How to use recursion on only part of an output
QCCS:
Alternative to char Arrays?
Ways to make CommafyR cleaner
*/


public class Commafier {
  public static String commafyF(int a) {
    String answer="";
    String simple = Integer.toString(a);
    char[] newStuff = simple.toCharArray();
    int n = 0;
    int factor = simple.length() % 3;
    for (char s : newStuff) {
      n+=1;
      if (n % 3 == factor  && n != simple.length()) {
        answer = answer + s + ",";
      } else {
        answer += s;
      }
   }
   return answer;
  }
  public static String commafyR (int a) {
    String b= Integer.toString(a);
    if (b.length() < 4) {
      return b;
    }
    int r = b.length()-3;
    String remnants = b.substring(0,r);
    String extract = b.substring(r,b.length());
    int remnantsI = Integer.parseInt(remnants);
    return (commafyR(remnantsI) + "," + extract);
  }
  public static void main(String[] args) {
    System.out.println(commafyF(0));
    System.out.println(commafyR(0));
    
    System.out.println(commafyF(1));
    System.out.println(commafyR(1));
    
    System.out.println(commafyF(12));
    System.out.println(commafyR(12));
    
    System.out.println(commafyF(123));
    System.out.println(commafyR(123));
    
    System.out.println(commafyF(1234));
    System.out.println(commafyR(1234));
    
    System.out.println(commafyF(12345));
    System.out.println(commafyR(12345));
    
    System.out.println(commafyF(123456));
    System.out.println(commafyR(123456));
    
    System.out.println(commafyF(1234567));
    System.out.println(commafyR(1234567));
  }
}
