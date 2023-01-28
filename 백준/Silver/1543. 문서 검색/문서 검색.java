import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String doc = br.readLine();
		String word = br.readLine();
		int result = 0;
		
		for(int i = 0 ; i <= doc.length() - word.length();) {
			int count = 0;
			for(int j = 0; j < word.length(); j++) {
				if(word.charAt(j) == doc.charAt(i + j)) 
					count++;
			}
			if(count == word.length()) {
				i += word.length();
				result++;
			}else i++;
		}
		System.out.println(result);
	}
}