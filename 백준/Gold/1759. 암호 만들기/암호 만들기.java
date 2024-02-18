/*
암호는 오름차순 정렬되어 있을 것
처음부터 오름차순 정렬을 해버리면 됨 그럼 내림차순이 될 염려가 없음
최소 한개의 모음 (a,e,i,o,u) + 두 개의 자음 -> 최소 3자리
가능성 있는 암호를 모두 출력해야함
2.가능성 있는 지 체크 후 넣음
조합
 */
import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static char[] arr, pick;
	static HashMap<Character, Boolean> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[c];
		pick = new char[l];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < c; i++) arr[i] = st.nextToken().charAt(0);

		Arrays.sort(arr);
		init();
		combination(0,0);
		System.out.println(sb);
	}
	static void combination(int start, int count) {
		if(count == l) {
			//모음 1개이상 자음 2개 이상인지 확인
			if(isCheck()) {
				for(char c : pick) sb.append(c);
				sb.append("\n");
			}
			return;
		}

		for(int i = start; i < c; i++) {
			pick[count] = arr[i];
            combination(i + 1, count + 1);
		}
	}
	static boolean isCheck() {
		int mo = 0;
		int ja = 0;
		for(char c : pick) {
			boolean flag = map.getOrDefault(c, false);
			if(flag) mo++;
			else ja++;
		}
		if(mo >= 1 && ja >= 2) return true;
		return false;
	}
	static void init() {
		map.put('a',true);
		map.put('e',true);
		map.put('i',true);
		map.put('o',true);
		map.put('u',true);
	}
}
