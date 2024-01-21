import java.io.*;
import java.util.*;

//배열을 사용한 구현
public class Main {
    static int size = 0; //초기 배열에 아무 것도 없음
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        //배열의 크기를 n으로 둔 이유
        //push만 n번 들어왔을 때 -> 최대 사이즈 : n
        //ex) 14번의 push -> 배열의 요소는 총 14개
        arr = new int[n];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            switch (cmd) {
                case "push": {
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                }
                break;

                case "pop": sb.append(pop()).append("\n");
                    break;

                case "size": sb.append(size()).append("\n");
                    break;

                case "empty": sb.append(empty()).append("\n");
                    break;

                case "top": sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push(int num) {
        arr[size] = num; //초기 size : 0 -> 0번 인덱스에 num 삽입
        size++; //배열에 요소 하나 추가 되었으니 size + 1
    }

    static int pop() {
        if (size == 0)
            return -1;

        //배열의 인덱스는 0부터 시작하며 size 변수는 요소의 갯수보다 항상 1 큼
        //ex) {1,2,3} -> size = 4로 세팅이 됨
        //즉 가장 최근에 push된 요소의 인덱스는 size - 1;
        //전위연산자 사용하여 size - 1을 진행하고 요소 추출
        return arr[--size];
    }

    static int size() {
        return size;
    }

    static int empty() {
        if (size == 0)
            return 1;
        return 0;
    }

    static int top() {
        if(empty() == 1) return -1;
        //가장 마지막에 들어온 요소의 값을 '보여주기만' 함
        //pop처럼 추출하고 size의 변경이 있는 것이 아님
        return arr[size - 1];
    }
}