
/*
Swag Trio - Max Schneider, Jason Yang, Michael Kamela
APCS
HW21 - STAtisTically Speaking
2021-10-20
DISCO:
You can use the already existing Math class to do mathematic functions such as square rooting and cube rooting.
Math.max() can only accept two arguments.
You can Math.round a double value twice in order to convert it to an int.
QCC:
Why do the Math.sqrt and Math.cbrt return a double? Is there a way to preset them to return an int?
If we did not know how many arguments were provided in each of the methods, would there still be a way to get the max, mean, and geometricmean?
 */

public class Stats {

    public static int mean(int a, int b) {
      return ((a + b) / 2);

  }

    public static double mean(double a, double b) {
        return ((a + b) / 2.0);
  }

    public static int max(int a, int b) {
        if (a == b) {
            return a;
        }   else if (a > b) {
            return a;
        }   else{
            return b;
        }
  }

    public static double max(double a, double b) {
          if (a == b) {
            return a;
        }   else if (a > b) {
            return a;
        }   else{
            return b;
        }
  }

    public static int geoMean(int a, int b){
        return Math.round(Math.round(Math.sqrt(a * b)));
    }

    public static double geoMean(double a, double b) {
        return Math.sqrt(a * b);
  }

    public static int max(int a, int b, int c) {
        return (Math.max(a, Math.max(b, c)));
  }

    public static double max(double a, double b, double c) {
        return (Math.max(a, Math.max(b, c)));
  }

    public static int geoMean(int a, int b, int c) {
      return Math.round(Math.round(Math.cbrt(a * b * c)));
    }

    public static double geoMean(double a, double b, double c) {
        return Math.cbrt(a * b *c);
  }
    public static void main(String args[]){
        System.out.println(mean(10, 20));
        System.out.println(mean(10.0, 20.0));
        System.out.println(max(5, 10));
        System.out.println(max(5.0, 10.0));
        System.out.println(geoMean(10, 40));
        System.out.println(max(5, 10, 15));
        System.out.println(max(5.0, 10.0, 15.0));
        System.out.println(geoMean(10.0, 40.0, 4.0));
}
}
}
