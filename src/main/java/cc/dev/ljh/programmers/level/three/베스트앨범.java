package cc.dev.ljh.programmers.level.three;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays){

        // 목표 : 장르별로(1) 가장 많이 재생된(2) 노래를 두 개씩 모아(3) 베스트 앨벌을 출시하려함
        // 조건 1 : 속한 노래가 많이 재생된 장르를 먼저 수록 -> 장르 순서 정하기
        // 조건 2 : 장르 내에서 많이 재생된 노래를 먼저 수록 -> 장르별 순위
        // 조건 3 : 재생 횟수가 같을 경우 고유 번호가 낮은 노래를 먼저 수록
        // 도출해야할 답 : 베스트 앨범의 고유 번호 도출
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            if(music.containsKey(genre)){
                if(!music.get(genre).containsKey(i)){
                    Map<Integer, Integer> index = music.get(genre);
                    if(!index.containsKey(i)){
                        Map<Integer, Integer> newMap = new HashMap<>(index);
                        newMap.put(i, plays[i]);
                        music.replace(genre, newMap);
                    }
                }
            }else {
                music.put(genre, Map.of(i, plays[i]));
            }
        }

        return music.entrySet().stream()
                // 1. 장르별 값 합산 기준으로 정렬
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                // 2. 각 장르의 상위 2개 고유번호 추출
                .flatMap(entry -> entry.getValue().entrySet().stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                        .limit(2)
                        .map(Map.Entry::getKey)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
