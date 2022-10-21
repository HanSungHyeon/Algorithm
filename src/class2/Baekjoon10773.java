package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i =0 ; i < tc; i++){
            int input = Integer.parseInt(br.readLine());
            if (input == 0 )
                stack.pop();
            else
                stack.push(input);
        }

        if(stack.isEmpty())
            result = 0 ;
        else{
            for (int i : stack) {
                result += i;
            }
        }
        System.out.println(result);
    }
}
