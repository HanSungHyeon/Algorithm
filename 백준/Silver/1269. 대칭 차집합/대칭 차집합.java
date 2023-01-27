import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arrA = br.readLine().split(" ");
		String[] arrB = br.readLine().split(" ");
		
		Map<String,Integer> mapA = new HashMap<>();
		Map<String,Integer> mapB = new HashMap<>();
		
		for(String s : arrA) 
			mapA.put(s,1);
		
		for(String s : arrB) 
			mapB.put(s,1);
		
		for(String s : arrB) 
			mapA.remove(s);
		
		for(String s : arrA) 
			mapB.remove(s);
		
		System.out.println(mapA.size() + mapB.size());
	}
}