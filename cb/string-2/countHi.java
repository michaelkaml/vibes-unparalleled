/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 countHi
Return the number of times that the string "hi" appears anywhere in the given string.
*/

public int countHi(String str) {
  int n = 0;
  int hiCounter = 0;
  while (n < (str.length()-1)) {
    String h = "";
    h = str.substring(n, n+2);
    if (h.equals("hi")) {
      hiCounter += 1;
      n += 1;
    } else {
      n += 1;
    }
  }
  return hiCounter;
}
