import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;

public class A2_Q2 {
    public static int change(int[] denominations) {




        return -1;

    }

    private static int greedy(int[] denominations, int sum) {
        int amount_owed=sum;
        int cur_denomination=denominations.length-1;
        int res=0;
        while(sum > 0) {
            if(sum < denominations[cur_denomination]) {
                cur_denomination--;
                continue;
            }
            sum-=denominations[cur_denomination];
            res++;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr1={1,2,4,8};
        int[] arr2={1,5,8};
        int[] arr3={1,5,10,25,100,200};
        int[] arr4={1, 5, 6, 9};
        System.out.println(greedy(arr4,1100));
        System.out.println(dynamic_programming(arr4,1100));
//        int j=0;
//        for(int i=0 ; i< 1000000; i++) {
//            try{
//                System.out.println(dynamic_programming(arr4,j)+" with j="+j);
//            } catch (Exception e) {
//                System.out.println("Failed at j="+j);
//            }
//            j+=100000;
//        }
    }

    private static int dynamic_programming(int[] denominations, int sum) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return dyn_prog_helper(denominations,0,sum,0,map);
    }

    private static int dyn_prog_helper(int [] denominations, int cur_sum, int sum, int num_of_change, HashMap<Integer,Integer> map) {
        if (sum == cur_sum) return num_of_change;
        if (sum < cur_sum) return Integer.MAX_VALUE-1;
        if(map.containsKey(cur_sum)) return map.get(cur_sum);
        int res=Integer.MAX_VALUE-1;
        for (int i = denominations.length - 1; i >= 0; i--) {
            res=Math.min(res, dyn_prog_helper(denominations,cur_sum+denominations[i], sum, num_of_change+1, map));
        }
        map.put(cur_sum, res);
        return res;
    }
}
