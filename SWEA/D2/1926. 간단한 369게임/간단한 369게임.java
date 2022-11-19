import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr;
		
		int num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {
			arr = new String[4];
			arr = String.valueOf(i).split("");
			int count = 0;
			
			for (String s : arr) {
				if(s.equals("3") || s.equals("6") || s.equals("9"))
					count++;
			}
			
			if(count > 0) {
				for (int j = 0; j < count; j++)
					sb.append("-");
            }
			else 
				sb.append(i);
            
            sb.append(" ");
		}
		System.out.println(sb);
	}
}