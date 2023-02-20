import java.io.*;
import java.util.*;

class Solution {
    static int[] one = {1,2,3,4,5};
    static int[] two = {2,1,2,3,2,4,2,5};
    static int[] three = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int num1 = 0, num2 = 0, num3 = 0;
        int[] result = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[num1++])
                result[0]++;
            if(answers[i] == two[num2++])
                result[1]++;
            if(answers[i] == three[num3++])
                result[2]++;
            
            if(num1 == one.length)
                num1 = 0;
            if(num2 == two.length)
                num2 = 0;
            if(num3 == three.length)
                num3 = 0;
        }
        int max = Arrays.stream(result).max().getAsInt();
        int count = 0;
        
        for(int i : result)
            if(i == max) count++;
        
        int[] answer = new int[count];
        int idx = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i] == max)
                answer[idx++] = i + 1;
        }
        return answer;
        
    }
}