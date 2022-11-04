package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2108 통계학
public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countMax = 0;
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //산술평균 = n개의 수의 합을 n으로 나눈 값
        double avg = Arrays.stream(arr).average().getAsDouble();
        System.out.println(String.format("%d", Math.round(avg)));

        //중앙값 = n개의 수들을 증가하는 순으로 나열했을 경우 중앙에 위치하는 값
        int mid = arr.length / 2;
        System.out.println(arr[mid]);

        //최빈값 = n개의 수들 중 가장 많이 나타나는 값
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tc; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1); //중복된 값이 있을 경우 value값 증가
        }
        //제일 높은 value를 가진 key 출력
        for (Integer key : map.keySet()) {
            if (map.get(key) > countMax) {
                countMax = map.get(key);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == countMax) {
                list.add(key);
            }
        }
        Collections.sort(list);

        if (list.size() > 0) System.out.println(list.get(1));
        else System.out.println(list.get(0));

        //범위 = n개의 수들 중 최댓값과 최솟값의 차이
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}
