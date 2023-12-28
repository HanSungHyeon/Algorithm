import java.io.*;
import java.util.*;

//반복은 moves 길이 만큼만
//반복하면서 나온 num - 1 = idx
//해당 배열 파고 들면서 0 아닌 거 있으면 가꼬옴
//stack 최상단에 있는 거랑 비교해서 같은거다? 그럼 인형 터뜨리고 ans + 2
//아니다? 그럼 스택에 넣기
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        
        for(int m : moves) {
            
            for(int i = 0; i < board.length; i++) {
                if(board[i][m - 1] != 0) {
                    int pick = board[i][m -1];
                    board[i][m - 1] = 0;
                    
                    if(stack.size() == 0) stack.push(pick);
            
                    else if(stack.peek() == pick) {
                        stack.pop();
                        ans += 2;
                    }
                    else stack.push(pick);
                    break;
                }
            }
            
        }
        return ans;
    }
}