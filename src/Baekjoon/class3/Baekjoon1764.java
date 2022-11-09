package Baekjoon.class3;

import java.io.*;
import java.util.*;
public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            String input = br.readLine();
            if(map.containsKey(input)){
                map.put(input,map.get(input) + 1);
            }
            else
                map.put(input,1);
        }

        for (String key : map.keySet()) {
            if(map.get(key) == 2){
                list.add(key);
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
}
