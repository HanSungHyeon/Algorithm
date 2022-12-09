import java.io.*;
import java.util.*;
import java.io.IOException;

//1966 프린터 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            int pages = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()); //중요도 입력

            Queue<int[]> queue = new LinkedList<>();

            for (int j = 0; j < pages; j++) {
                queue.add(new int[] {j,Integer.parseInt(st.nextToken())}); //큐에 {문서 초기위치, 중요도} 추가
            }

            while (!queue.isEmpty()){
                int[] temp = queue.poll();
                boolean flag = true; //본인이 가장 큰지 판단하기 위함

                for (int[] ints : queue) {
                    if(temp[1] < ints[1]){ //큐를 순회하면서 temp보다 큰 요소가 있다면 맨 뒤로 다시 삽입 후 순회 종료
                        queue.add(temp);
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;

                count++;

                if(temp[0] == idx) break;
            }
            System.out.println(count);
        }
    }
}