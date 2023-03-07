import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	static int n, k;
	static List<String> list, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			result = new ArrayList<>();
			//list로 입력 받음
			list = Arrays.stream(br.readLine().split("")).map(x -> x).collect(Collectors.toList());

			String str = "";
			str = makeString(str);

			//잘라서 result list에 넣음
			for (int i = 0; i < n / 4 - 1; i++) {
				rotate();
				str = makeString(str);
			}
			//중복제거
			result = result.stream().distinct().collect(Collectors.toList());
			
			//정답 담을 list생성
			List<Integer> ans = new ArrayList<>();
			
			//16진수 -> 10진수
			for(int i =0 ; i < result.size(); i++)
				ans.add(Integer.parseInt(result.get(i),16));
			
			//내림차순 정렬
			ans.sort(Collections.reverseOrder());
			
			System.out.println("#" + t + " " + ans.get(k - 1));
		}
	}
	//16진수 값 만들기
	private static String makeString(String str) {
		for (int j = 0; j < list.size(); j++) {
			str += list.get(j);
			if (str.length() == n / 4) {
				result.add(str);
				str = "";
			}
		}
		return str;
	}

	// 보물상자 회전
	private static void rotate() {
		list.add(0, list.remove(list.size() - 1));
	}

}