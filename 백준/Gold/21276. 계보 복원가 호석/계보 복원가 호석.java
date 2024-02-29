/*

 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static HashMap<String, Integer> nameMap = new HashMap<>();
	static HashMap<String, String> parentMap = new HashMap<>();
	static HashMap<Integer, String> idxMap = new HashMap<>();
	static List<Integer>[] list;
	static int[] degree;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<String> pq = new PriorityQueue<>((o1,o2) -> o1.compareTo(o2));
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		 degree = new int[n];
		 list = new ArrayList[n];
		 for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
		 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 for(int i = 0; i < n; i++) {
			 String name = st.nextToken();
			 nameMap.put(name, i);
			 idxMap.put(i, name);
		 }

		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = nameMap.get(st.nextToken());
			int from = nameMap.get(st.nextToken());

			list[from].add(to);
			degree[to]++;
		}
		qSet();
		topological();

		while (!pq.isEmpty()) {
			String name = pq.poll();
			PriorityQueue<String> tmp = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
			int count = 0;
			for(String key : parentMap.keySet()) {
				String value = parentMap.getOrDefault(key, " ");
				if(value.equals(name)) {
					count++;
					tmp.add(key);
				}
			}
			sb.append(name).append(" ").append(count).append(" ");
			while(!tmp.isEmpty()) {
				sb.append(tmp.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void qSet() {
		for(int i = 0; i < degree.length; i++) {
			if(degree[i] == 0) {
				q.add(i);
				pq.add(idxMap.get(i));
			}
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		sb.append("\n");
	}
	static void topological() {
		while (!q.isEmpty()) {
			int cur = q.poll();
			pq.add(idxMap.get(cur));

			for (int i : list[cur]) {
				parentMap.put(idxMap.get(i),idxMap.get(cur));
				degree[i]--;
				if(degree[i] == 0) q.add(i);
			}
		}
	}
}
