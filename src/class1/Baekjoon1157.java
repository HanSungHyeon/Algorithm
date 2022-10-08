package class1;
//1157 단어 공부
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] countArr = new int[26];
        int count = 0;
        char result = '/';

        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i) - 'A']++;   //알파벳 몇 갠지 다 더해서 각 배열에 처 박음
        }

        for(int i = 0; i < countArr.length; i++){
            if(count < countArr[i]) {//3 1 0 0 0 0
                count = countArr[i];
                result = (char)(i + 'A');
            }
            else if ( count == countArr[i])
                result = '?';
        }
        System.out.println(result);
    }
}
   /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap<>();

    String[] str = br.readLine().toUpperCase().split("");

        for(String key : str)
                map.put(key,map.getOrDefault(key,0)+1); //찾는 키가 존재한다면 키의 value를 반환 없다면 0

                Integer max = Collections.max(map.values());

                int count = 0;
                String result = "";
                for(String key : map.keySet()){
                if(map.get(key).equals(max)){ //value가 max와 일치한 key값이 있다면?
                count++;
                result = key;
                }
                }

                if(count == 1)
                System.out.println(result);
                else
                System.out.println("?");*/