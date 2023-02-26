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

        System.out.println(greedy(arr3,123232423));
    }

    private static int dynamic_programming(int[] denominations, int sum) {

        return -1;
    }
}
