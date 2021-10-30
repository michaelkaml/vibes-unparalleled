/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 endOther
Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
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
