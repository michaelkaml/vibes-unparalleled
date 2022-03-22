public class QuickSelect {
  //instead of 1st smallest element as the smallest element, this method considers the 0th smallest element
  //for example, to find the 3rd smallest element, y would have to be 4, since the position of that element is indexed like an array
  public static int quickSelect(int[] arr, int left, int right, int y) {
    if (left == right) {
      return arr[left];
    }
    int pvt = (int)(Math.random() * (right - left + 1) ) + left;
    //System.out.println(pvt);
    pvt = Partition.partition(arr, left, right, pvt);

    if (y == pvt) {
      return arr[y];
    } else if (y < pvt) {
      return quickSelect(arr, left, pvt - 1, y);
    } else {
      return quickSelect(arr, pvt + 1, right, y);
    }
  }

  public static void toString(int[] arr) {
    String output = "";
    for (int i = 0; i < arr.length; i++) {
      output += arr[i] + ", ";
    }
    System.out.println(output);
  }

  public static void main(String[] args) {
    int[] arr1 = {9,8,7,6,5,4,3,2,1,0};
    System.out.println(quickSelect(arr1, 0, arr1.length - 1, 0));
    //Partition.partition(arr1, 0, arr1.length - 1, 2);
    //toString(arr1);
  }
}
