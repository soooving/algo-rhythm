import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO 백준 11659
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		long[] sums = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int index1 = Integer.parseInt(st.nextToken());
			int index2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sums[index2] - sums[index1-1]);
		}
}
