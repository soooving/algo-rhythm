import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO 백준 11658
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
      
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
      
        for (int k = 1; k <= m; k++) {
            st = new StringTokenizer(br.readLine());
            int tn = Integer.parseInt(st.nextToken());
            
        	if(tn == 0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
        		
                dp[x][y] = c;
        	}
        	else if(tn==1) {
                int sum = 0;
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                for (int i = x1; i <= x2; i++) {
                	for (int j = y1; j <= y2; j++) {
                        sum += dp[i][j];
                    }
                }
                sb.append(sum + "\n");
        	}
        }
      
        System.out.print(sb);
		}
}
