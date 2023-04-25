import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr,delta = {{-1,0},{0,1},{1,0},{0,-1}};
    //카메라 정보
    //인덱스 맞추기 위해 0추가
    static int[][][] camera = {
            {{0}},
            {{0},{1},{2},{3}},
            {{0,2},{1,3}},
            {{0,1},{1,2},{2,3},{3,0}},
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
            {{0,1,2,3}}
    };

    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        //배열 및 카메라 리스트에 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0 && arr[i][j] != 6) list.add(new Node(i,j,arr[i][j]));
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int idx) {
        if(idx == list.size()) {
            int count = count();
            ans = Math.min(ans,count);

            return;
        }
        //리스트에서 카메라 하나 꺼내기
        Node cam = list.get(idx);

        //카메라가 볼 수 있는 경우만큼 반복
        for(int i =0 ; i < camera[cam.num].length; i++) {

            //카메라가 감시 영역
            area(cam, i,1);

            //영역 표시 다 했으면 다음 카메라 고르러
            dfs(idx + 1);

            //영역 지우기
            area(cam, i,0);
        }
    }

    private static void area(Node cam, int i,int num) {
        for(int j = 0; j < camera[cam.num][i].length; j++) {
            int d = camera[cam.num][i][j];

            int dx = cam.x + delta[d][0];
            int dy = cam.y + delta[d][1];
            if(num == 1) watch(dx, dy, d,num);
            else watch(dx, dy, d,num);
        }
    }

    //감시 영역 표시
    private static void watch(int dx, int dy, int d,int num) {
        while(true) {
            if(dx < 0 || dy < 0 || dx >= n || dy >= m || arr[dx][dy] == 6) break;

            //감시 영역 표시
            if(arr[dx][dy] <= 0) {
                //감시 영역 표시
                if(num == 1) arr[dx][dy]--;
                
                //감시 영역 제거
                else arr[dx][dy]++;
            }

            dx += delta[d][0];
            dy += delta[d][1];
        }
    }

    //안전영역 계산
    private static int count() {
    	int count = 0;
    	for(int i = 0 ;i < n; i++) {
    		for(int j =0; j < m; j++) {
    			if(arr[i][j] == 0) count++;
    		}
    	}
    	return count;
    }
}