import java.io.*;
import java.util.*;

/*
 * 약품 뿌릴거임
 * 약품은 안뿌려도 답이 나올 수 있음
 * 약품을 사용할거라면 최소 2개는 사용을 해야함
 * 약품을 어느 라인에 사용할 지 모름
 * 약품 종류 a,b
 * 약품 최소 사용 갯수를 구해야함
 * 다 뿌려봐야함
 * 백트래킹
 * 약품을 뿌리지 않을 때
 * a약품을 뿌릴 때 -> 0
 * b약품을 뿌릴 때 -> 1
 * 뿌려봤으면 다시 원래대로 돌려야함 -> 임시배열 사용
 */
public class Solution {
	static int d, w, k, ans;
	static int[][] arr, tmp;

	// 필름이 유효한지 확인
	private static boolean isCheck() {
//		int colCount = 0;
		for (int c = 0; c < w; c++) {
			int rowCount = 1;
			for (int r = 1; r < d; r++) {
				if (tmp[r - 1][c] == tmp[r][c])
					rowCount++;
				else
					rowCount = 1;

				if (rowCount == k) 
					break;
			}
			if (rowCount < k)
				return false;
		}
		return true;
	}
	private static void print() {
		for(int i =0 ; i< d; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		System.out.println("------------------");
	}

	private static void back(int row, int count) {
		// 탈출조건
		// 약품을 아에 안뿌렸거나 2개 이상사용했을 때 확인
		if (row == d) {
//			print();
			if (isCheck()) {
//				System.out.println("count : " + count);
				ans = Math.min(ans, count);
			}
			return;
		}

		// 약품 안뿌릴 때
		back(row + 1, count);
		// a약품 뿌릴 때
		for (int i = 0; i < w; i++)
			tmp[row][i] = 0;
		back(row + 1, count + 1);

		// b약품 뿌릴 때
		for (int i = 0; i < w; i++)
			tmp[row][i] = 1;
		back(row + 1, count + 1);

		// 원래대로 돌릴 때
		tmp[row] = arr[row].clone();
	}

	private static void copy() {
		for (int i = 0; i < d; i++)
			tmp[i] = arr[i].clone();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[d][w];
			tmp = new int[d][w];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < d; i++)
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			copy();
			back(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
}