package cc.dev.ljh.programmers.level.zero.normal;

import java.util.Arrays;

public class 정수를_나선형으로_배치하기 {

    public static void main(String[] args) {
        int[][] answer =solution(5);
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num=1;
        int start=0;
        int end=n;

        while(num <= n*n){

            //->
            for(int j=start;j<end;j++)
                answer[start][j]=num++;
            //v
            for(int i=start+1;i<end;i++)
                answer[i][end-1]=num++;
            //<
            for(int j=end-2;j>=start;j--)
                answer[end-1][j]=num++;
            //^
            for(int i=end-2;i>start;i--)
                answer[i][start]=num++;
            start++;
            end--;
        }

        int maxDigits = String.valueOf(n * n).length();

        String format = "%" + (maxDigits + 1) + "d";

        for (int[] row : answer) {
            for (int num2 : row) {
                System.out.printf(format, num2);
            }
            System.out.println();
        }

        return answer;
    }
}
