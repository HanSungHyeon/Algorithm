package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    push(list, Integer.parseInt(st.nextToken()));
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
                case "top":
                    sb.append(top(list)).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    //push
    public static void push(ArrayList<Integer> list, int num) {
        list.add(num);
    }

    //pop
    public static int pop(ArrayList<Integer> list) {
        if (list.isEmpty())
            return -1;
        int pop = list.remove(list.size() - 1);
        return pop;
    }

    //size
    public static int size(ArrayList<Integer> list) {
        int size = list.size();
        return size;
    }

    //empty
    public static int empty(ArrayList<Integer> list) {
        int empty = 0;
        if (list.isEmpty())
            empty = 1;
        return empty;
    }

    //top
    public static int top(ArrayList<Integer> list) {
        if (list.isEmpty())
            return -1;
        int top = list.get(list.size() - 1);
        return top;
    }
}
