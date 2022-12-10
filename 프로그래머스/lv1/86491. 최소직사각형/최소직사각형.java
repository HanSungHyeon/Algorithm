class Solution {
    public int solution(int[][] sizes) {
        int h = 0, w = 0;

        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0],sizes[i][1]); //w랑 비교
            int min = Math.min(sizes[i][0],sizes[i][1]); //h랑 비교

            w = Math.max(w,max);
            h = Math.max(h, min);
        }
        return h * w;
    }
}