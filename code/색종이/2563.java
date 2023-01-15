import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		boolean[][] arr = new boolean[101][101];
    Scanner sc = new Scanner(System.in);
        
    int tot = 0;
		int inNum = sc.nextInt();
		for(int i=0; i<inNum; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x; j<x+10; j++){
				for (int k = y; k < y+10; k++) {
					if (!arr[j][k]) {
            arr[j][k] = true;
            tot++;
          }
        }
      }
    }
		System.out.println(tot);
  }
}
