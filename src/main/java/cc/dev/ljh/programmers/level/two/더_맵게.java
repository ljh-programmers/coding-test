package cc.dev.ljh.programmers.level.two;

import java.util.*;

public class 더_맵게 {
    public static void main(String[] args) {
        int K = 7;
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Long> scovilles = new PriorityQueue<>(scoville.length);
//        LinkedList<Long> scovilles = new LinkedList<>();
        int targetCount = 0;

        for (int j : scoville) {
//            if(j < K) {
            scovilles.offer((long) j);
//            }
        }


        while(true){
            System.out.println("-------시작-------[대상 : "+targetCount+"]");

            for (int i = 0; i < scovilles.size(); i++) {
                long sc = scovilles.peek();

                if(sc < K){
                    scovilles.remove();
                    long sc2;
                    try{
                        sc2 = scovilles.remove();
                    }catch (Exception exception){
                        return -1;
                    }
                    long newFood;
                    if(sc < sc2){
                        newFood = sc + (sc2 * 2);
                        System.out.println("식 ["+sc+"+"+"("+sc2+" * "+2+") = "+newFood+"]");
                    }else{
                        newFood = sc2 + (sc * 2);
                        System.out.println("식 ["+sc2+"+"+"("+sc+" * "+2+") = "+newFood+"]");
                    }
                    scovilles.add(newFood);
                    answer++;
                }else{
                    return answer;
                }
                System.out.println(">> "+ scovilles);
            }
        }
    }
}
