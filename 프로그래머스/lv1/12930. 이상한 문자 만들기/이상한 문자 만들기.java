class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        int idx = 0;

        for (String str : arr) {
            if(str.contains(" ")){
                sb.append(str);
                idx = 0;
                continue;
            }
            else if(idx % 2 == 0) sb.append(str.toUpperCase());
            else sb.append(str.toLowerCase());
            idx++;
        }
        return sb.toString();
    }
}