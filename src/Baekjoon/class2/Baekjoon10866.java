package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//덱
public class Baekjoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    push_front(list,Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(list,Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front(list)).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back(list)).append('\n');
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

    //push_front
    public static void push_front(LinkedList<Integer> list, int num) {
        list.offerFirst(num);
    }
    //push_back
    public static void push_back(LinkedList<Integer> list, int num) {
        list.offerLast(num);
    }
    //pop_front
    public static int pop_front(LinkedList<Integer> list){
        return list.isEmpty() ? -1 : list.removeFirst();
    }

    //pop_back
    public static int pop_back(LinkedList<Integer> list) {
        return list.isEmpty()? -1 : list.removeLast();
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
