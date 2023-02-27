import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;

public class A2_Q2 {
    static HashMap<Integer,Integer> map;
    public static int change(int[] denominations) {
        map = new HashMap<Integer,Integer>();
        int res=Integer.MAX_VALUE;
        dynamic_programming(denominations,denominations[denominations.length-1]+denominations[denominations.length-2]);
        for(int i=1; i <= denominations[denominations.length-1]+denominations[denominations.length-2]; i++) {
            int greedy_result=greedy(denominations,i);
            //System.out.println("Greedy i= "+i+" greedy_result = "+greedy_result);
            if(greedy_result != map.get(i)) {
                res = Math.min(res,i);
            }
        }
        if(res== Integer.MAX_VALUE) return -1;
        return res;
    }

    private static int greedy(int[] denominations, int sum) {
        int amount_owed=sum;
        int cur_denomination=denominations.length-1;
        int res=0;
        while(sum > 0) {
            if(cur_denomination == -1) return -1;
            if(sum < denominations[cur_denomination]) {
                cur_denomination--;
                continue;
            }
            sum-=denominations[cur_denomination];
            res++;
        }
        return res;
    }
    private static int dynamic_programming(int[] denominations, int sum) {
        int res = dyn_prog_helper_1(denominations,sum);
        return res;
    }

    //FINAL SOLUTION THAT WORKS
    private static int dyn_prog_helper_1(int [] denominations, int sum) {
        int [] arr = new int[sum+1];
        for(int i=0; i < arr.length; i++) arr[i]=sum+1;
        arr[0]=0;
        for(int i=1; i <= sum;i++) {
            for(Integer denomination: denominations) {
                if(i-denomination >= 0) {
                    arr[i] = Math.min(arr[i], 1+arr[i-denomination]);
                    map.put(i,Math.min(arr[i], 1+arr[i-denomination]));
                }
            }
        }
        if(arr[sum] != sum+1) return arr[sum];
        return -1;
    }
    ///for testing
    public static void main(String args[]) {
        int[][] arr={{1,2,4,5},
                {1,2,4,5,8},
                {1,13},
                {1, 9999},
                {1,10,13},
                {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441},
                {1, 7, 13, 19, 37}};
        for(int i=0 ; i < arr.length; i++) System.out.println(change(arr[i]));


        //System.out.println(dynamic_programming(arr[0],9));

    }
}
