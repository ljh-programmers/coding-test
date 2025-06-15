package cc.dev.ljh.programmers.level.two;

import java.util.*;

public class 전화번호_목록 {

    public static void main(String[] args) {
        String[] phoneBooks = {"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBooks));
    }

    public static boolean solution(String[] phoneBooks) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBooks.length; i++) {
            map.put(phoneBooks[i], i);
        }

        for (String phoneBook : phoneBooks) {
            for (int j = 1; j < phoneBook.length(); j++) {
                if (map.containsKey(phoneBook.substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
