import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 이동하려는 칸이
 * 흰색
 * 이동 -> 말이 있는 경우 말들 맨 위로 올라감
 * 		   말이 없는 경우 안착
 * 빨강
 * 이동 -> 말들 순서 반대로 (이동한 애들만 뒤집고 기존에 있던 애들은 그대로 둠)
 *
 * 파랑, 체스판 벗어나는 경우
 * 방향 바꿈 -> 이동
 * 		 -> 이동하려는 칸이 파랑 또는 배열 벗어나는 경우면 그냥 멈춤
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 체스 이동 현황 List[][] 사용
 * 체스판 int[][] 사용
 * 나머지 시키는 대로
 */
public class Main {
    static class Node {
        int x, y, d, num;

        public Node(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", d=" + d + ", num=" + num + "]";
        }

    }

    // 파랑이거나 범위를 벗어나는 경우
    private static void blueAndOut(Node node) {
        if (node.d == 1)
            node.d = 2;
        else if (node.d == 2)
            node.d = 1;
        else if (node.d == 3)
            node.d = 4;
        else if (node.d == 4)
            node.d = 3;

        list.set(node.num - 1, node);
        l[node.x][node.y].set(0, node);
        int dx = node.x + delta[node.d][0];
        int dy = node.y + delta[node.d][1];

        if(dx < 0 || dy < 0 || dx >= n || dy >= n || arr[dx][dy] == 2 ) return;

        moveCheck(node);
    }

    // 빨강인 경우
    private static void red(Node node, int dx, int dy) {
        // 역전하고 이동
        Collections.reverse(l[node.x][node.y]);
        move(node, dx, dy);
    }

    // 흰색인 경우
    private static void white(Node node, int dx, int dy) {
        move(node, dx, dy);
    }

    // 말 움직이는 곳 확인
    private static void moveCheck(Node node) {
        int dx = node.x + delta[node.d][0];
        int dy = node.y + delta[node.d][1];

        // 이동하려는 칸이 파랑이거나 범위를 벗어나는 경우
        if (dx < 0 || dy < 0 || dx >= n || dy >= n || arr[dx][dy] == 2)
            blueAndOut(node);

            // 이동하려는 칸이 흰색일 경우
        else if (arr[dx][dy] == 0) {
            white(node, dx, dy);
        }

        // 이동하려는 칸이 빨강인 경우
        else if (arr[dx][dy] == 1) {
            red(node, dx, dy);
        }
    }

    // 말 이동
    private static void move(Node node, int dx, int dy) {
        // 현재 칸에 있는 모든 말을 이동할 곳으로 옮김
        while (!l[node.x][node.y].isEmpty()) {
            Node tmp = l[node.x][node.y].remove(0);
            list.set(tmp.num - 1, new Node(dx, dy, tmp.d, tmp.num));

            l[dx][dy].add(new Node(dx, dy, tmp.d, tmp.num));
        }
    }

    // 이동할 말 선택
    private static void select() {
        for (int i = 0; i < k; i++) {
            Node node = list.get(i);
            // 선택한 말이 가장 밑에 있으면?
            if (l[node.x][node.y].get(0).num == node.num)
                moveCheck(node);
        }
    }

    // 종료 조건 체크
    private static boolean isCheck() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (l[i][j].size() >= 4)
                    return true;
            }
        }
        return false;
    }

    static int[][] arr;
    static int[][] delta = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    static List<Node> list = new ArrayList<>();
    static List<Node>[][] l;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        l = new LinkedList[n][n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                l[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < n; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y, d, i));
            l[x][y].add(new Node(x, y, d, i));
        }

        int ans = -1;
        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
            select();
//            print();
            if (isCheck()) {
                ans = i;
                break;
            }

        }
        System.out.println(ans);
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(l[i]));
        }
        System.out.println("----------------s");
    }
}
