import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int i : numbers) list.add(String.valueOf(i));
        
        StringBuilder sb = new StringBuilder();
        list.stream()
            .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
            .forEach(sb::append);
        
        long count = list.stream()
            .filter(s -> s.equals("0"))
            .count();
        if(count == list.size()) return "0";
        
        return sb.toString();
    }
}