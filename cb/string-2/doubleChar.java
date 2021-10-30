/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 doubleChar
Given a string, return a string where for every char in the original, there are two chars.
*/

public String doubleChar(String str) {
  int i = 0;
  String s = "";
  while (i < str.length()) {
    String w = "";
    w = str.substring(i, i+1) + str.substring(i, i+1);
    s = s+w;
    i ++;
  }
  return s;
}
