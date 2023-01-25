import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int cnt = 1, sNum = 1, eNum = 1, sum = 1;
        while(eNum != num){
            if(sum == num){
                cnt++;
                eNum++;
                sum = sum+eNum;
            }
            else if(sum > num){
                sum = sum-sNum;
                sNum++;
            }
            else {
                eNum++;
                sum = sum+eNum;
            }
        }
        System.out.println(cnt);
	}
}
