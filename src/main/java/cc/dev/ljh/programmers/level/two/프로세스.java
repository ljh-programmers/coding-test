package cc.dev.ljh.programmers.level.two;

import java.util.*;

public class 프로세스 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println("답 : "+solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            int[] row = {i, priorities[i]};
            queue.offer(row);
        }

        int processedCount = 0;
        while(!queue.isEmpty()){
            int[] row = queue.poll();
            int index = row[0];
            int priority = row[1];

            int maxPriority = queue.stream()
                    .map(p -> p[1])
                    .max(Comparator.comparingInt(o -> o))
                    .orElse(0);

            if(maxPriority <= priority){
                processedCount++;
                if(index == location){
                    answer = processedCount;
                    break;
                }
            }else{
                queue.offer(row);
            }
        }

        return answer;
    }
}
