import java.util.*;

public class junk {

    private static int dyn_prog_helper(int [] denominations, int cur_sum, int sum, int num_of_change, HashMap<Integer,Integer> map) {
        if (sum == cur_sum) return num_of_change;
        if (sum < cur_sum) return Integer.MAX_VALUE;
        if(map.containsKey(cur_sum)) return map.get(cur_sum)+num_of_change;
        int res=Integer.MAX_VALUE;
        for (Integer denomination: denominations) {
            if(denomination == Integer.MAX_VALUE) continue;
            if(cur_sum+denomination > sum) continue;
            res=Math.min(res, dyn_prog_helper(denominations,cur_sum+denomination, sum, num_of_change+1, map));
        }
        map.put(cur_sum, res-num_of_change);
        return res;
    }

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
    //this function is badly written refer to solution_2()
    public static int solution_1(int[][] board,int turn, int score_p1, int score_p2) {
        boolean isGameEnded=false;
        int res=Integer.MIN_VALUE;
        if(turn % 2 == 0) {
            for(int i=0; i< board.length; i++) {
                for(int j=0; j <= i; j++) {
                    if(board[i][j] == 0) {
                        //TODO
                        int val1=0;
                        int val2=0;
                        int val3=0;
                        if(i-2 >=0 && board[i-2][j] != 0 && board[i-2][j] != -1 && board[i-1][j] != 0) {

                            val1=board[i-2][j];
                            val2=board[i-1][j];
                            val3=board[i][j];

                            board[i-2][j]=0;
                            board[i-1][j]=0;
                            board[i][j]=val1;

                            res=Math.max(res,solution_1(board,turn+1, score_p1+(val1*val2), score_p2));

                            board[i-2][j]=val1;
                            board[i-1][j]=val2;
                            board[i][j]=val3;
                            isGameEnded=true;
                        }
                        if(i+2 < board.length && board[i+2][j] != 0 && board[i+2][j] != -1 && board[i+1][j] != 0) {
                            val1=board[i][j];
                            val2=board[i+1][j];
                            val3=board[i+2][j];

                            board[i+2][j]=0;
                            board[i+1][j]=0;
                            board[i][j]=val3;

                            res=Math.max(res,solution_1(board,turn+1, score_p1+(val3*val2), score_p2));

                            board[i][j]=val1;
                            board[i+1][j]=val2;
                            board[i+2][j]=val3;
                            isGameEnded=true;
                        }
                        if(j-2 >= 0 && board[i][j-2] != 0 && board[i][j-2] != -1 && board[i][j-1] != 0) {
                            val1=board[i][j];
                            val2=board[i][j-1];
                            val3=board[i][j-2];

                            board[i][j-2]=0;
                            board[i][j-1]=0;
                            board[i][j]=val3;

                            res=Math.max(res,solution_1(board,turn+1, score_p1+(val3*val2), score_p2));

                            board[i][j]=val1;
                            board[i][j-1]=val2;
                            board[i][j-2]=val3;
                            isGameEnded=true;
                        }
                        if(j+2 < board[i].length && board[i][j+2] != 0 && board[i][j+2] != -1 && board[i][j+1] != 0) {
                            val1=board[i][j];
                            val2=board[i][j+1];
                            val3=board[i][j+2];

                            board[i][j+2]=0;
                            board[i][j+1]=0;
                            board[i][j]=val3;

                            res=Math.max(res,solution_1(board,turn+1, score_p1+(val3*val2), score_p2));

                            board[i][j]=val1;
                            board[i][j+1]=val2;
                            board[i][j+2]=val3;
                            isGameEnded=true;
                        }
                    }
                }
            }

        } else {
            for(int i=0; i <board.length; i++) {
                for(int j=0; j < i; j++) {
                    if(board[i][j] == 0) {
                        //TODO
                        int val1 = 0;
                        int val2 = 0;
                        int val3 = 0;
                        if (i - 2 >= 0 && board[i - 2][j] != 0 && board[i - 2][j] != -1 && board[i-1][j] != 0) {

                            val1 = board[i - 2][j];
                            val2 = board[i - 1][j];
                            val3 = board[i][j];

                            board[i - 2][j] = 0;
                            board[i - 1][j] = 0;
                            board[i][j] = val1;

                            res=Math.max(res,solution_1(board, turn + 1, score_p1, score_p2 + (val1 * val2)));

                            board[i - 2][j] = val1;
                            board[i - 1][j] = val2;
                            board[i][j] = val3;
                            isGameEnded = true;
                        }
                        if (i + 2 < board.length && board[i + 2][j] != 0 && board[i + 2][j] != -1 && board[i+1][j] != 0) {
                            val1 = board[i][j];
                            val2 = board[i + 1][j];
                            val3 = board[i + 2][j];

                            board[i + 2][j] = 0;
                            board[i + 1][j] = 0;
                            board[i][j] = val3;

                            res=Math.max(res,solution_1(board, turn + 1, score_p1, score_p2 + (val3 * val2)));

                            board[i][j] = val1;
                            board[i + 1][j] = val2;
                            board[i + 2][j] = val3;
                            isGameEnded = true;
                        }
                        if (j - 2 >= 0 && board[i][j - 2] != 0 && board[i][j - 2] != -1 && board[i][j-1] != 0) {
                            val1 = board[i][j];
                            val2 = board[i][j - 1];
                            val3 = board[i][j - 2];

                            board[i][j - 2] = 0;
                            board[i][j - 1] = 0;
                            board[i][j] = val3;

                            res=Math.max(res,solution_1(board, turn + 1, score_p1, score_p2 + (val3 * val2)));

                            board[i][j] = val1;
                            board[i][j - 1] = val2;
                            board[i][j - 2] = val3;
                            isGameEnded = true;
                        }
                        if (j + 2 < board[i].length && board[i][j + 2] != 0 && board[i][j + 2] != -1 && board[i][j+1] != 0) {
                            val1 = board[i][j];
                            val2 = board[i][j + 1];
                            val3 = board[i][j + 2];

                            board[i][j + 2] = 0;
                            board[i][j + 1] = 0;
                            board[i][j] = val3;

                            res=Math.max(res,solution_1(board, turn + 1, score_p1, score_p2 + (val3 * val2)));

                            board[i][j] = val1;
                            board[i][j + 1] = val2;
                            board[i][j + 2] = val3;
                            isGameEnded = true;
                        }
                    }
                }
            }
        }
        if(!isGameEnded){
            return score_p1-score_p2;
        }
        return res;
    }

}
