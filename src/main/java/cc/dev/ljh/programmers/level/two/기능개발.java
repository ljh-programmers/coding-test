package cc.dev.ljh.programmers.level.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> completeProgress = new LinkedList<>();
        int dayOfCompleteCount = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            int speed = speeds[i];
            int progress = progresses[i]+(speed * day);

            if(progress >= 100){
                dayOfCompleteCount++;
            }else {
                if (dayOfCompleteCount != 0) {
                    answer.add(dayOfCompleteCount);
                    dayOfCompleteCount = 0;
                }
                // 작업이 끝날 때 까지
                while (!(progress >= 100)) {
                    progress += speed;
                    day++;
                }
                dayOfCompleteCount++;
            }

            if(i == progresses.length - 1){
                answer.add(dayOfCompleteCount);
                dayOfCompleteCount = 0;
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
