package cc.dev.ljh.programmers.level.zero.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr){
        ArrayList<Integer> as = new ArrayList<>();
        as.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                as.add(arr[i]);
            }
        }

        return as.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
