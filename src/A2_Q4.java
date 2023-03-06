import java.util.*;

public class A2_Q4 {

    //for testing
    public static void main (String args[]) {
//        int [] arr = new int[1000000];
//        int index=1;
//        for(int i=1; i< arr.length; i++) {
//            arr[i]=index;
//            index+=2;
//        }
//        shuffleArray(arr);
        int[] arr = {1,3,2,4,6,5};

        System.out.println(mergeSort(arr,0,arr.length-1));

    }
    //Fourth Approach (mergesort)
    private static double merge_lists(int[] passengers, int left, int mid, int right) {
        int left_pointer = left;
        int right_pointer = mid;
        int num = 0;
        double res = 0;
        int[] аrr = new int[right - left + 1];
        while (left_pointer < mid && right_pointer < right+1) {
            if (passengers[left_pointer] <= passengers[right_pointer]) {
                аrr[num] = passengers[left_pointer];
                num++;
                left_pointer++;
                continue;
            }
            аrr[num] = passengers[right_pointer];
            res += mid - left_pointer;
            num++;
            right_pointer++;
        }
        while (left_pointer < mid) {
            аrr[num] = passengers[left_pointer];
            num++;
            left_pointer++;
        }
        while (right_pointer < right+1) {
            аrr[num] = passengers[right_pointer];
            num++;
            right_pointer++;
        }
        for (int i = left, j = 0; i < right+1; j++, i++) {
            passengers[i] = аrr[j];
        }
        return res;
    }
    private static double mergeSort(int[] passengers, int left, int right) {
        double res = 0;

        if (right > left) {
            int mid = (right + left) / 2;

            res = mergeSort(passengers, left, mid);
            res += mergeSort(passengers, mid + 1, right);
            res += merge_lists(passengers, left, mid + 1, right);
        }
        return res;
    }
}

