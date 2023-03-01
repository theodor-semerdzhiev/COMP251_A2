import java.util.*;
public class A2_Q1 {
    //simply prints the board to the screen
    public static void printBoard(int[][] board) {
        for(int i=0; i <board.length; i++) {
            System.out.print("[");
            for(int j=0; j < board[i].length;j++) {
                if(j == board[i].length-1){
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print(board[i][j]+",");
            }
            System.out.print("]");
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int[][] arr_test0 =     {{0,-1,-1,-1,-1},
                                {1,1-1,-1,-1},
                                {1,1,1,-1,-1},
                                {1,1,1,1,-1},
                                {1,1,1,1,1}};

        int[][] arr_test2 =     {{1,-1,-1,-1,-1},
                                {1,1-1,-1,-1},
                                {1,1,1,-1,-1},
                                {1,1,1,1,-1},
                                {1,1,0,100,1}};

        int [][] arr_test13 =   {{55,-1,-1,-1,-1},
                                {99,24,-1,-1,-1},
                                {77,93,19,-1,-1},
                                {27,26,5,53,-1},
                                {9,90,48,44,0}};

        int [][] arr4 =     {{55,-1,-1,-1,-1},
                            {99,24,-1,-1,-1},
                            {77,93,19,-1,-1},
                            {27,26,5,53,-1},
                            {9,90,48,44,0}};

        int [][] arr_test18 =   {{56,-1,-1,-1,-1},
                                {12,56,-1,-1,-1},
                                {56,16,51,-1,-1},
                                {34,56,56,0,-1},
                                {56,22,56,43,56}};

        int [][] test_arr = {{23,-1,-1,-1},
                            {12, 0,-1,-1},
                            {3,1,1,-1},
                            {2,1,1,1}};


//        while(true) {
//            System.out.println(find_largest_score(arr3));
//            System.out.println(find_largest_score(arr3));
//        }
        //printBoard(arr4);
        printBoard(arr_test13);
        System.out.println(game_recursion(arr_test13));
        printBoard(arr_test13);
        System.out.println(arr.toString());
        System.out.println(arr.size());

    }
    static ArrayList<Integer> arr;
    public static int game_recursion(int[][] board) {
        arr=new ArrayList<>();
        return solution_1(board,0,0,0);
    }
    //DOES NOT WORK (maybe it does)
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
            arr.add(Math.abs(score_p1-score_p2));
            return Math.abs(score_p1-score_p2);
        }
        return res;
    }

    public static int solution_2(int [][] board) {
        int score_p1=0;
        int score_p2=0;
        int turn=0;
        while(true){
            if(turn % 2 == 0) {
                int tmp=find_largest_score(board);
                if(tmp == -1) break;
                score_p1+=tmp;
            } else {
                int tmp=find_largest_score(board);
                if(tmp == -1) break;
                score_p2+=tmp;
            }
            turn++;
            System.out.println("------------------------");
            printBoard(board);
            System.out.println("p1 : "+score_p1);
            System.out.println("p2 : "+score_p2);
            System.out.println("------------------------");
        }
        System.out.println(score_p1);
        System.out.println(score_p2);
        return score_p1-score_p2;
    }




    public static int find_largest_score(int[][] board) {
        int score=0;

        int row1=0;
        int column1=0;

        int row2=0;
        int column2=0;

        int row3=0;
        int column3=0;

        boolean Move_is_made=false;
        for(int i=0;i< board.length; i++) {
            for(int j=0; j <=i; j++) {
                if(board[i][j]==0) {
                    if(i-2 >=0 && board[i-2][j] != 0 && board[i-2][j] != -1) {
                        if(board[i-2][j]*board[i-1][j] > score) {
                            score=board[i-2][j]*board[i-1][j];

                            row1=i-2;
                            column1=j;

                            row2=i-1;
                            column2=j;

                            row3=i;
                            column3=j;
                        }
                        Move_is_made=true;
                    }
                    if(i+2 < board.length && board[i+2][j] != 0 && board[i+2][j] != -1) {
                        if(board[i+2][j]*board[i+1][j] > score) {
                            score=board[i+2][j]*board[i+1][j];

                            row1=i+2;
                            column1=j;

                            row2=i+1;
                            column2=j;

                            row3=i;
                            column3=j;
                        }
                        Move_is_made=true;
                    }
                    if(j-2 >= 0 && board[i][j-2] != 0 && board[i][j-2] != -1) {
                        if(board[i][j-2]*board[i][j-1] > score) {
                            score=board[i][j-2]*board[i][j-1];

                            row1=i;
                            column1=j-2;

                            row2=i;
                            column2=j-1;

                            row3=i;
                            column3=j;
                        }
                        Move_is_made=true;
                    }
                    if(j+2 < board[i].length && board[i][j+2] != 0 && board[i][j+2] != -1) {
                        if(board[i][j+2]*board[i][j+1] > score) {
                            score=board[i][j+2]*board[i][j+1];

                            row1=i;
                            column1=j+2;

                            row2=i;
                            column2=j+1;

                            row3=i;
                            column3=j;
                        }
                        Move_is_made=true;
                    }
                }
            }
        }
        if(!Move_is_made || score==0) return -1;

        board[row3][column3]=board[row1][column1];
        board[row1][column1]=0;
        board[row2][column2]=0;

        return score;
    }


}
