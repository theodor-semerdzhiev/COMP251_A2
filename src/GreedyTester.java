import java.util.Arrays;

public class GreedyTester {
    public static void main(String[] args) {

        //This is the typical kind of input you will be tested with. The format will always be the same
        //Each index represents a single homework. For example, homework zero has weight 23 and deadline t=3.
        int[] weights1 = new int[] {23, 60, 14, 25, 7};
        int[] deadlines1 = new int[] {3, 1, 2, 1, 3};
        int m1 = weights1.length;

        int[] weights2 = new int[] {3,2,1};
        int[] deadlines2 = new int[] {3,2,1};
        int m2 = weights2.length;

        int[] weights3 = new int[] {120,123,80,23,10,34,23,231,342,1231,2131};
        int[] deadlines3 = new int[] {4,4,3,5,10,7,8,9,1,2,8};
        int m3 = weights3.length;
        //This is the declaration of a schedule of the appropriate size
        HW_Sched schedule1 =  new HW_Sched(weights1, deadlines1, m1);
        HW_Sched schedule2 =  new HW_Sched(weights2, deadlines2, m2);
        HW_Sched schedule3 =  new HW_Sched(weights3, deadlines3, m3);

        //This call organizes the assignments and outputs homeworkPlan
        int[] res1 = schedule1.SelectAssignments();
        int[] res2 = schedule2.SelectAssignments();
        int[] res3 = schedule3.SelectAssignments();
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }

}

