package cc.dev.ljh.programmers.level.one;

import java.util.HashMap;
import java.util.HashSet;

public class 포켓몬 {

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int answer = 0;
        int pickupCount = nums.length/2;

        HashMap<Integer, Integer> pocketmons = new HashMap<>();

        for (int num : nums) {
            pocketmons.put(num, pocketmons.getOrDefault(num, 1));
        }

        answer = Math.min(pocketmons.size(), pickupCount);

        return answer;
    }
}
