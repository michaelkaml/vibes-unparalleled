/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 countCode
Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
*/

public int countCode(String str) {
  int n = 0;
  int codeCtr = 0;
  while (n < (str.length()-3)) {
    String h = "";
    h = str.substring(n,n+2) + str.substring(n+3,n+4);
    if (h.equals("coe")) {
      codeCtr += 1;
      n += 1;
    } else {
      n += 1;
    }
  }
  return codeCtr;
}
