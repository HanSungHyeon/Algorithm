import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("");
		int[] count = new int[2];

		if (arr[0].equals("0"))
			count[0]++;
		else
			count[1]++;

		for (int i = 1; i < arr.length; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				count[Integer.parseInt(arr[i])]++;
			}
		}
		System.out.println(Math.min(count[0], count[1]));
	}
}