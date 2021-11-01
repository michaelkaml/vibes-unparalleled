/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-2 countCode
Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

DISCO:
By removing the third letter from each time I check for "code", I effectively just check for "co_e", where the "_" represents any character. 
I also have to do str.length-3 in my while loop to prevent an error, because eventually it would try to check a position on the string that didn't exist. 
QCC:
Does n+=1 have to appear in the if statement? Since its present both under if and else, can I just remove the else and have n+=1 within the while loop but outide the if/else?
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
