class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;  // 일반적으로 4입니다.
        int[][] dp = new int[n][m];

        // 첫 번째 행을 초기화합니다.
        for (int i = 0; i < m; i++) {
            dp[0][i] = land[0][i];
        }

        // 나머지 행을 계산합니다.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j != k) {  // 이전 행에서 같은 열은 선택할 수 없습니다.
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }

        // 최대 값을 찾습니다.
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}
