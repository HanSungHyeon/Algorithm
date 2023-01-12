import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] user = new int[5][5];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 0;
		
		for (int i = 0; i < user.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < user.length; j++) {
				user[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		A : for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				count++;
				if(remove(num) > 2) {
					System.out.println(count);
					break A;
				}
			}
		}
	}

	public static int remove(int num) {
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (user[i][j] == num)
					user[i][j] = -1;
			}
		}

		// 가로
		for (int i = 0; i < 5; i++) {
			int row = 0;
			for (int j = 0; j < 5; j++) {
				if (user[i][j] == -1)
					row++;
			}
			if (row == 5)
				bingo++;
		}
		// 세로
		for (int i = 0; i < 5; i++) {
			int column = 0;
			for (int j = 0; j < 5; j++) {
				if (user[j][i] == -1)
					column++;
			}
			if (column == 5)
				bingo++;
		}
		//대각 -> \ -> 위에서 아래로
		int leftDiagonal = 0;
		for (int i = 0; i < 5; i++) if(user[i][i] == -1) leftDiagonal++;
		if(leftDiagonal == 5) bingo++;
		
		//대각 -> / -> 아래에서 위로
		int rightDiagonal = 0;
		for (int i = 4; i >= 0; i--) if(user[i][4-i] == -1) rightDiagonal++;
		if(rightDiagonal == 5) bingo++;
		
		return bingo;
	}
}