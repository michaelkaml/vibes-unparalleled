/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 xyzThere
Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

DISCO:
This one took me an especially long time. The issue was that the final n+=1 was not in an else statement, so under some circumstances it would increment n by 2 instead of 1 like I wanted.
Only in one of the test cases did this issue manifest, and it took me a while to realize what was wrong.
QCC:
I wonder if I could put n+=1 outside all the if and else statements, as every one of them contains n+=1. I believe it might, as I want it to increment n by 1 no matter what, and placing it within the while loop but outside the if and else statments would achieve this.
*/

public boolean xyzThere(String str) {
  int n = 0;
  int xyzCtr = 0;
  String lol = "a" + str;
  while (n < (lol.length()-3)) {
    String h = "";
    String dotCheck = "";
    h = lol.substring(n+1,n+4);
    dotCheck = lol.substring(n,n+1);
    if (dotCheck.equals(".")) {
      n+=1;
    } else if (h.equals("xyz")) {
      xyzCtr += 1;
      n += 1;
    } else {
      n += 1;
    }
  }
  return xyzCtr > 0;
}
