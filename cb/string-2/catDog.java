/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 catDog
Return true if the string "cat" and "dog" appear the same number of times in the given string.

DISCO:
str.substring(a,b) takes the subset of a string starting at position a (inclusive) and ending at position b (exclusive)
previously I used str.substring(a) to try and take the value at just one position, but now I actually know how to use it
*/

public boolean catDog(String str) {
  int n = 0;
  int catCounter = 0;
  int dogCounter = 0;
  while (n < str.length()-2) {
    String a = "";
    a = str.substring(n, n+3);
    if (a.equals("cat")) {
      n+=1;
      catCounter+=1;
    }
    else if (a.equals("dog")) {
      n+=1;
      dogCounter+=1;
    }
    else {
      n+=1;
    }
  }
  return (dogCounter==catCounter);
}
