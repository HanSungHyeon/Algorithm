class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int idx = 0;
        
        for (char c : arr) {
            if(c == ' ') {
                sb.append(c);
                idx = 0;
                continue;
            }
            else if(idx % 2 == 0)
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
            
            idx++;
        }
        return sb.toString();
    }
}