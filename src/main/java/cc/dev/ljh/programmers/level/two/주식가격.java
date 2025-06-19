package cc.dev.ljh.programmers.level.two;

import java.util.ArrayList;
import java.util.Arrays;

public class 주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices){
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            if(prices.length == i+1) {
                answer.add(0);
                break;
            }
            int seconds = 0;
            int index = prices[i];
            System.out.println("target : " + index);
            for (int j = i+1; j < prices.length; j++) {
                System.out.println("비교대상 : "+prices[j]);
                if(index > prices[j]) {
                    seconds++;
                    answer.add(seconds);
                    System.out.println("줄었네 : "+seconds+"초");
                    break;
                }else{
                    seconds++;
                    if(j == prices.length-1) {
                        System.out.println("줄은적 없음 : "+seconds+"초");
                        answer.add(seconds);
                    }
                }
            }
            System.out.println("------------");
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
