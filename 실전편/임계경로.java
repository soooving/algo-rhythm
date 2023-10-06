package 실전편;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 임계경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] size = new int[n + 1];
		int[] visit = new int[m + 1];
		Queue<Data> q = new LinkedList<>();
		Queue<Integer> bq = new LinkedList<>();
		ArrayList<ArrayList<Data>> al = new ArrayList<>();
		ArrayList<LocInfo> loc = new ArrayList<>();

		for (int i = 0; i <= n; ++i) {
			ArrayList<Data> temp1 = new ArrayList<>();
			LocInfo temp2 = new LocInfo(0);
			al.add(temp1);
			loc.add(temp2);
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			al.get(a).add(new Data(a, b, c, i));
			++size[b];
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		Data d;
		q.add(new Data(s, s, 0, 0));
		while (!q.isEmpty()) {
			d = q.poll();
			if (loc.get(d.cur).time < d.value + loc.get(d.prev).time) { // 현재 위치의 저장된 시간 < 비용 + 이전위치 저장된 시간
				loc.get(d.cur).time = d.value + loc.get(d.prev).time; // 시간 변경
				loc.get(d.cur).visit.index = d.prev + " ";
				loc.get(d.cur).visit.load = d.load + " ";
			} else if (loc.get(d.cur).time == d.value + loc.get(d.prev).time) { // 시간이 같을 경우
				if (d.prev != d.cur) {
					loc.get(d.cur).visit.index += d.prev + " ";
					loc.get(d.cur).visit.load += d.load + " ";
				}
			}
			if (size[d.cur] > 1) {
				--size[d.cur];
				continue;
			}

			for (int i = 0; i < al.get(d.cur).size(); ++i) {
				q.add(al.get(d.cur).get(i));
			}
		}

		int ansSize = 0;
		bq.add(e);
		while (!bq.isEmpty()) {
			int num = bq.poll();
			String[] arrIndex = loc.get(num).visit.index.split(" ");
			String[] arrLoad = loc.get(num).visit.load.split(" ");
			for (int i = 0; i < arrIndex.length; ++i) {
				if (arrLoad[i] == "" || visit[Integer.parseInt(arrLoad[i])] == 1) {
					continue;
				}
				visit[Integer.parseInt(arrLoad[i])] = 1;
				++ansSize;
				bq.add(Integer.parseInt(arrIndex[i]));
			}
		}

		bw.write(loc.get(e).time + "\n");
		bw.write(ansSize + "\n");
		bw.close();
	}

	public static class LocInfo {
		public Pair visit = new Pair();
		public int time;

		public LocInfo(int time) {
			this.time = time;
		}
	}

	public static class Data {
		public int prev;
		public int cur;
		public int value;
		public int load;

		public Data(int prev, int cur, int value, int load) {
			this.prev = prev;
			this.cur = cur;
			this.value = value;
			this.load = load;
		}
	}

	public static class Pair {
		public String index = "";
		public String load = "";
	}
}