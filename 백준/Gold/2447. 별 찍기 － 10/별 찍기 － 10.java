import java.util.*;
import java.io.*;

public class Main{
	public static List<String> boxAdder(List<String> box){
		List<String> nextBox = new ArrayList<>();
		for(int row=0;row<box.size();row++) {
			String line = box.get(row);
			nextBox.add(line+line+line);
		} // 1번째
		for(int row=0;row<box.size();row++) {
			String line = box.get(row);
			for(int i=0;i<box.get(row).length();i++) line += " ";
			nextBox.add(line+box.get(row));
		} // 2번째 + 빈공간
		for(int row=0;row<box.size();row++) {
			String line = box.get(row);
			nextBox.add(line+line+line);
		} // 3번째
		
		return nextBox;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double k = Double.parseDouble(st.nextToken());
		List<String> box = new ArrayList<>();
		box.add("***");
		box.add("* *");
		box.add("***"); // k == 1
		while(k > 3) {
			box = boxAdder(box);
			k /= 3;
		}
		for(int i=0;i<box.size();i++) {
			System.out.println(box.get(i));
		}
	}
}