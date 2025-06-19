package cc.dev.ljh.programmers.level.two;

import java.util.ArrayList;
import java.util.Arrays;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) throws InterruptedException {
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weights));
    }

    // 트럭은 1초에 다리 길이 1씩 전진한다.
    // 트럭은 올라갈수 있으면 1초에 한 대씩 다리에 올라갈 수 있다
    public static int solution(int bridge_length, int weight, int[] truck_weights) throws InterruptedException {
        int seconds = 0;
        int truckCount = truck_weights.length;
        ArrayList<Integer> destination = new ArrayList<>();
        int[] bridge = new int[bridge_length];

        int currentBridgeTotalWeight = 0;
        int truckCountInBridge = 0;

        int index = 0;
        while(!(destination.size() == truckCount)){
            // 현재 다리에 있는 트럭부터 처리
            if(truckCountInBridge == 0){
                System.out.println("현재 다리 위에는 트럭이 없습니다. ");
            }else{
                System.out.println("현재 다리 위에 트럭 수 : "+truckCountInBridge);

                for (int i = bridge_length-1; i >= 0; i--) {
                    System.out.println("i : "+(i));
                    int truckInBridge = bridge[i];

                    if(truckInBridge != 0){
                        // 다리의 끝에 있다면
                        if(i == bridge_length-1){
                            bridge[i] = 0;
                            destination.add(truckInBridge);
                            truckCountInBridge--;
                            currentBridgeTotalWeight-= truckInBridge;
                            System.out.println("["+truckInBridge+"]"+"번 트럭 도착");
                            if(destination.size() == truck_weights.length){
                                seconds++;
                                return seconds;
                            }
                        }else{
                            bridge[i+1] = truckInBridge;
                            bridge[i] = 0;
                            System.out.println("["+truckInBridge+"]"+"번 트럭 한 칸 전진");
                        }
                    }else{
                        System.out.println("다리의 ["+i+"]위치에는 트럭이 없습니다.");
                        System.out.println("현재 다리 상태 : "+ Arrays.toString(bridge));
                    }
                }
            }

            // 출발지 트럭 처리
            if(truck_weights.length != index) {
                int currentTruck = truck_weights[index];
                // 다리에 트럭이 갈 자리가 있는지
                if (truckCountInBridge != bridge_length) {
                    // 올라간다면 무게는 괜찮은지
                    if ((currentBridgeTotalWeight + currentTruck) <= weight) {
                        bridge[0] = currentTruck;
                        truckCountInBridge++;
                        index++;
                        currentBridgeTotalWeight+= currentTruck;

                        System.out.println("출발지에 있던 [" + currentTruck + "]번 트럭이 다리위로 올라갑니다.");
                    }
                }
            }else{
                System.out.println("출발지에 아무도 없음");
            }
            seconds++;
            System.out.println("1초 증가 현재 ["+seconds+"]초");
            System.out.println("현재 다리 상태 : "+ Arrays.toString(bridge));
            System.out.println("============종료============ 현재 목적지 트럭수 >> "+destination.size());
        }

        return seconds;
    }
}
