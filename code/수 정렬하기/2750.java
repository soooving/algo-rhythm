import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
	  	int inNum = sc.nextInt();
		
		  int inArr[] = new int[inNum];
      for(int i=0; i<inNum; i++) {
        inArr[i] = sc.nextInt();
      }

      Arrays.sort(inArr);
      for (int i : inArr) {
          System.out.println(i);
      }		

	}
}
