import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;

public class A2_Q2 {

    static int [] arr;

    public static int change(int[] denominations) {
        arr = new int[denominations[denominations.length-1]+denominations[denominations.length-2]+1];
        dynamic_programming(denominations,denominations[denominations.length-1]+denominations[denominations.length-2]);
        for(int i=1; i <= denominations[denominations.length-1]+denominations[denominations.length-2]; i++) {
            //System.out.println("Greedy i= "+i+" greedy_result = "+greedy_result);
            if(greedy(denominations,i) != arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int greedy(int[] denominations, int sum) {
        int cur_denomination=denominations.length-1;
        int res=0;
        while(sum > 0) {
            if(cur_denomination == -1) return -1;
            if(sum < denominations[cur_denomination]) {
                cur_denomination--;
                continue;
            }
            res+= sum / denominations[cur_denomination];
            sum %= denominations[cur_denomination];
        }
        return res;
    }
    private static int dynamic_programming(int[] denominations, int sum) {
        int res = dyn_prog_helper_1(denominations,sum);
        return res;
    }

    //FINAL SOLUTION THAT WORKS
    private static int dyn_prog_helper_1(int [] denominations, int sum) {
        for(int i=1; i <= sum;i++) {
            for(int j=0; j < denominations.length; j++) {
                if(i-denominations[j] >= 0) {
                    if(arr[i] != 0) arr[i] = Math.min(arr[i], 1+arr[i-denominations[j]]);
                    else arr[i]=1+arr[i-denominations[j]];
                }
            }
        }
        if(arr[sum] != 0) return arr[sum];
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
        for(int i=0 ; i < arr.length; i++)
           System.out.println(change(arr[i]));

        System.out.println(greedy(arr[0],100));
        //System.out.println(dynamic_programming(arr[0],9));

    }
}
