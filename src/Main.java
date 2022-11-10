import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {10};
        solution(100, 100, arr);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int count = 0, idx = 0 ;

        while (!queue.isEmpty()) {
            queue.poll();
            count++;


            if (idx < bridge_length &&queue.size() + 1 <= bridge_length && queue.stream().mapToInt(Integer::intValue).sum() + truck_weights[idx] <= weight) {
                if(idx < bridge_length){
                    queue.add(truck_weights[idx]);
                    idx++;
                    count++;
                }
                else {
                    break;
                }

            }
        }
        return count;
    }
}