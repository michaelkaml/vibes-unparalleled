/***
  Swag Trio- Max Schneider, Jason Yang, Michael Kamela
  APCS
  HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay; Finding number of vowels, printing the vowels, etc.
  2021-11-03
  time spent: 0.5 hr
  
  
  DISCO
  You can reduce the length of code significantly by declaring a variable (VOWELS in this case)
  
  
  QCC: n/a
 
  class Pig
  a Pig Latin translator
  ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
            9
      ,--.-'-,--.
      \  /-~-\  /
     / )' a a `( \
   ( (  ,---.  ) )
     \ `(_o_o_)' /
      \   `-'   /
       | |---| |
       [_]   [_]
       PROTIP: Make this class compilable first,
       then develop and test one method at a time.
       NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/


public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: The string gives us a list of the vowels that we can use in the methods. This makes things simplier instead of listing out the vowels each time 
  
  private static final String VOWELS = "aeiouAEIOU";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
      for (int i = 0; i < w.length(); i++) {
      if (w.substring(i, i + 1).equals(letter)) {
        return true;
      }
    }
    return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
      if (hasA(VOWELS, letter)){
          return true;
      } else {
      return false;
  }
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
      int answer = 0;
      for (int i = 0; i < w.length(); i ++){
          if (isAVowel(w.substring(i, i + 1))){
              answer = answer + 1;
          }
      }
      return answer;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
      for (int i = 0; i < w.length(); i ++){
          if (isAVowel(w.substring(i, i + 1))){
              return true;
          } 
      }
      return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
      String answer = "";
      for (int i = 0; i < w.length(); i ++){
          if (isAVowel(w.substring(i, i + 1))){
              answer = answer + w.substring(i, i + 1);
          }
      }
      return answer;
  }


  public static void main( String[] args ) 
  {
      System.out.println(hasA("joe", "j")); //should print true
      System.out.println(hasA("joe", "h")); //should print false
      System.out.println(isAVowel("a")); //should print true
      System.out.println(isAVowel("b")); //should print false
      System.out.println(countVowels("depression")); //should print 4
      System.out.println(countVowels("meatball")); //should print 3
      System.out.println(hasAVowel("cat")); //should print true
      System.out.println(hasAVowel("zzz")); //should print false
      System.out.println(allVowels("meatball")); //should print "eaa"
      System.out.println(allVowels("sadlife")); //should print "aie"
  }//end main()

}//end class Pig
