import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0]; //2
            int b = commands[i][1]; //5
            int c = commands[i][2]; //3
            
            int[] temp = Arrays.copyOfRange(array,a-1,b);
            Arrays.sort(temp);
            result[i] = temp[c - 1];
        }
        return result;
    }
}