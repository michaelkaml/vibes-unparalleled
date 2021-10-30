/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 xyzThere
Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
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
