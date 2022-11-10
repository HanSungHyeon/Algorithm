import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else if(!stack.peek().equals(i)){
                stack.push(i);
            }
        }
        
        int[] result = stack.stream().mapToInt(Integer::intValue).toArray();

        
        return result;
    }
}