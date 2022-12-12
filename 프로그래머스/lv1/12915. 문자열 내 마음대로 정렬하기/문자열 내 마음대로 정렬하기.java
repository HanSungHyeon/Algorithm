import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        
        for (String string : strings)
            list.add(string.charAt(n) + string);

        //정렬 진행
        Collections.sort(list);

        //앞에 추가된 글자 제거 후 리턴 -> subString
        String[] arr = new String[list.size()];

        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i).substring(1);

        return arr;
    }
}