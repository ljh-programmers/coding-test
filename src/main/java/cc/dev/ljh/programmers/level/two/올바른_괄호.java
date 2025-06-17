package cc.dev.ljh.programmers.level.two;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("(())()"));
    }

    public static boolean solution(String s){

        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                count++;
            }else{
                count--;
                if(count < 0){
                    return false;
                }
            }
        }

        return count == 0;
    }
}
