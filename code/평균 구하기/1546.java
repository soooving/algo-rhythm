import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		
		int inArr[] = new int[inNum];
		for(int i=0; i<inNum; i++) {
			inArr[i] = sc.nextInt();
		}
        
        double tot = 0, max = 0;
        for (int row : inArr) {
            if(row > max) max = row;
            tot += row;
        }		

        System.out.println(tot*100.0 / max / inNum);
	}
}
