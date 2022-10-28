package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    push(list,Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop(list)).append('\n');
                    break;
                case "size":
                    sb.append(size(list)).append('\n');
                    break;
                case "empty":
                    sb.append(empty(list)).append('\n');
                    break;
                case "front":
                    sb.append(front(list)).append('\n');
                    break;
                case "back":
                    sb.append(back(list)).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
    //push
    public static void push(LinkedList<Integer> list, int num) {
        list.offerLast(num);
    }
    //pop
    public static int pop(LinkedList<Integer> list){
        return list.isEmpty() ? -1 : list.pop();
    }

    //size
    public static int size(LinkedList<Integer> list) {
        return list.size();
    }

    //empty
    public static int empty(LinkedList<Integer> list) {
        return list.isEmpty() ?  1 : 0;
    }

    //front
    public static int front(LinkedList<Integer> list) {
        return list.isEmpty()? -1 : list.peek();
    }

    //back
    public static int back(LinkedList<Integer> list) {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }
}
