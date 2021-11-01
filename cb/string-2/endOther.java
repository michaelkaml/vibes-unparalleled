/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 endOther
Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.

DISCO:
By setting the strings to their lowercase versions of themselves, I make the whole process easier by ignoring cases. 
However, if I had to return one of the string values rather than the boolean, this would present issues.
I started off by checking if the strings were the same, and then checking which string is longer, and then cutting the two strings down to the same length by removing the beginning of the longer string. 
Then I check to see if the severed string is the same as the shorter string.
QCC:
If I had to return string values, would I just create a second set of strings without the .toLowerCase()?
*/

public boolean endOther(String a, String b) {
  a = a.toLowerCase();
  b = b.toLowerCase();
  String str = "";
  if (a.equals(b)) {
    return true;
  } else if (a.length()>b.length()) {
    str = a.substring(a.length()-b.length());
    return (str.equals(b));
  } else {
    str = b.substring(b.length()-a.length());
    return (str.equals(a));
  }

}
