/*
 * 출입 = 1
 * 퇴장 = -1
 * 침입한 모기 갯수 배열 생성 배열 Idx = 시간
 * 입력 받고 해당 위치에 출, 퇴 표시
 * 이전 값이랑 더하기
 * Max 값 찾기
 * Max가 시작되는 지점 -> Max가 끝나는 지점 찾기
 * 만약 Max가 여러 개라면? -> 가장 빠른 구간 출력
 *
 * 변수
 * 2 5
 * 5 8
 * */

import java.io.*;
import java.util.*;

public class Main {
	static class Mosquito {
		int key, value;

		public Mosquito(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map.put(s, map.getOrDefault(s, 0) + 1);
			map.put(e, map.getOrDefault(e, 0) - 1);
		}

		//모기 시간순 정렬
		List<Mosquito> list = new ArrayList<>();
		map.forEach((key, value) -> {
			list.add(new Mosquito(key, value));
		});

		list.sort((o1, o2) -> o1.key - o2.key);
		
		int max = list.get(0).value, idx = 0, s = list.get(0).key, e = 0;
		for(int i = 1; i < list.size(); i++) {
			int k = list.get(i).key;
			int v = list.get(i).value + list.get(i - 1).value;
			if(max < v) {
				idx = i;
				max = v;
				s = k;
			}
			list.set(i, new Mosquito(k, v));
		}

		for(int i = idx; i < list.size(); i++) {
			if(list.get(i).value < max) {
				e = list.get(i).key;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(s + " " + e);
		System.out.println(sb);
	}

}