import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            if(sum == 100) break;

            for (int j = i + 1; j < list.size(); j++) {
                if(sum - list.get(i) - list.get(j) == 100){
                    list.remove(j);
                    list.remove(i);
                    sum = 100;
                    break;
                }
            }
        }
        list.forEach(System.out::println);
    }
}