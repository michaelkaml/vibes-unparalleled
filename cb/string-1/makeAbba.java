/*
Michael Kamela
APCS
HW28 -- PPMP
codingbat.com string exercises
2021-10-30
time spent: an excessive amount

String-1 makeAbba
Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
*/

public String makeAbba(String a, String b) {
  return a + b + b + a;
}
