import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers) {
        /*0 ~ 9까지의 합 = 45
        45 - numbers 요소들의 합 = 답*/
        return 45 - Arrays.stream(numbers).sum();
    }
}