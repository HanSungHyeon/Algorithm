/*
자신보다 큰 수 중 가장 가까이 있는 수를 찾아야 함
스택에 인덱스를 넣어야함
*/

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) answer[i] = -1;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}