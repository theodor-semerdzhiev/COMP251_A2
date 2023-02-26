import java.util.*;

public class A2_Q4 {

    //First approach ()
    public static double swaps(int[] passengers) {

        double res=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < passengers.length; i++) map.put(i+1,passengers[i]);
        boolean[] visited_arr = new boolean[passengers.length+1];

        for(int i=1 ; i<= map.size(); i++) {
            if(!visited_arr[i]) {
                visited_arr[i]=true;
                if(i == map.get(i)) {
                    continue;
                }
                int num = map.get(i);
                while(!visited_arr[num-1]){
                    visited_arr[num]=true;
                    num=map.get(num);
                    res++;
                }
            }
        }
        return res;
    }
    //second approach
    public static double swaps_v1(int[] passengers) {

        double res=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < passengers.length; i++) map.put(passengers[i],i);
        int[] arr= Arrays.copyOf(passengers,passengers.length);


        for(int i=0; i < passengers.length; i++) {
            if(passengers[i]!=arr[i]) {
                res++;

                int num=passengers[i];
                swap(passengers,i,map.get(arr[i]));
                map.put(num,map.get(arr[i]));
                map.put(arr[i], i);
            }
        }
        return res;
    }
    //helper function
    public static void swap(int[] arr, int i, int j) {
        arr[i]+=arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]-=arr[j];
    }
    //Third Approch (nlog(n)), still not fast enough
    public static double swaps_v2(int[] passengers) {
        LinkedList<Integer> list = new LinkedList<>();
        double res=0;
        for(int i=0; i < passengers.length; i++) {
            list.add(passengers[i]);
        }
        Collections.sort(list);
        for(int i=0; i < passengers.length; i++) {
            int index=Collections.binarySearch(list,passengers[i]);
            res+=index;
            list.remove(index);
        }


        return res;
    }
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
        int аrr[] = new int[right - left + 1];
        while (left_pointer < mid && right_pointer <= right) {
            if (passengers[left_pointer] <= passengers[right_pointer]) {
                аrr[num] = passengers[left_pointer];
                num++;
                left_pointer++;
            }
            else {
                аrr[num] = passengers[right_pointer];
                res += mid - left_pointer;
                num++;
                right_pointer++;
            }
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


    //FOR TESTING PURPOSES
    private static void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
}

