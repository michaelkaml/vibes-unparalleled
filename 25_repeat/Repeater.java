/*
Swag Trio -- Max Schneider, Michael Kamela, Jason Yang
APCS
HW25- Do I repeat myself? - Using while loop and recursion to print certain number of "fences".
2021-10-26
time spent: 0.8 hours
DISCO: Using -- after a an int variable decreases that value by 1
QCC: N/a
*/

public class Repeater {
    public static String fenceW(int numPosts){
        String firstFence = "|";
        if (numPosts < 0) {
            return "Enter a positive number.";
        }
        if (numPosts == 0){
            return " ";
        }
        while (numPosts > 1){
            firstFence += "--|";
            numPosts--;
        }
        return firstFence;
    }

    public static String fenceR(int numPosts){
        String firstFence = "|";
        if (numPosts < 0) {
            return "Enter a positive number.";
        }
        if (numPosts == 0) {
            return " ";
        }
        if (numPosts == 1){
            return firstFence;
        }
            return "|--" + fenceR(numPosts - 1);
        }



    public static void main(String args []){
        System.out.println("---------------------" + "\nWhile Tester");
        System.out.println(fenceW(-1));
        System.out.println(fenceW(0));
        System.out.println(fenceW(1));
        System.out.println(fenceW(2));
        System.out.println(fenceW(3));
        System.out.println("---------------------" + "\nRecursion Tester");
        System.out.println(fenceW(-1));
        System.out.println(fenceR(0));
        System.out.println(fenceR(1));
        System.out.println(fenceR(2));
        System.out.println(fenceR(3));
    }
