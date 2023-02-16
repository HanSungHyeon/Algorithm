import java.io.*;
import java.util.*;

public class Solution {
	static int[] man, girl,result;
	static boolean[] card,flag;
	static int wCount,lCount;
	public static void main(String[] args) throws IOException {
		//이긴 사람이 점수 다 가져감
		//진 사람 암것도 없음
		//총 9라운드 -> 점수 더 높은 사람 승, 같으면 무승부
		//라운드마다 결과가 다를 수 있음 -> 순서 의미 있음 -> 순열
		//규영이가 내는 거 고정 -> 인영 카드 내는 순서 구해야댐?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc= Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			man = new int[9];
			girl = new int[9];
			result = new int[9]; //인영 카드 내는 순서
			card = new boolean[19];
			flag = new boolean[10];
			wCount = 0; lCount = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < man.length; i++) {
				man[i] = Integer.parseInt(st.nextToken());
				card[man[i]] = true;
			}
			
			for(int i = 1,num = 0; i < card.length; i++) {
				if(!card[i]) girl[num++] = i;
			}
			p(0);
			System.out.println("#" + t + " " + wCount + " " + lCount);
		}
	}
	public static void p(int num) {
		if(num == 9) {
			int manScore = 0;
			int girlScore = 0;
			
			for(int i = 0; i < 9; i++) {
				if(man[i] > result[i])
					manScore += man[i] + result[i];
				else if(man[i] < result[i])
					girlScore += man[i] + result[i];
			}
			if(manScore > girlScore) {
				wCount++;
				return;
			}
			else if(girlScore > manScore) {
				lCount++;
				return;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(!flag[i]) {
				flag[i] = true;
				result[num] = girl[i];
				p(num + 1);
				flag[i] = false;
			}
		}
	}
}