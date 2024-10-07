/*
head = 1 tail = 2 apple = 1
head <= apple >= tail

head = 1 tail = 2 apple = 5
head <= apple >= tail -> false

head = 4 tail = 5 apple = 5
3
head = 3 tail = 4

head > apple 왼쪽 이동
tail < apple 오른쪽 이동

 */

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int head = 1;
		int tail = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());

		int sum = 0;
		for(int i = 0; i < j; i++) {
			int apple = Integer.parseInt(br.readLine());
			int move = 0;

			if(head > apple) move = apple - head;
			else if (tail < apple) move = apple - tail;

			head += move;
			tail += move;
			sum += Math.abs(move);
		}
		System.out.println(sum);
	}
}
