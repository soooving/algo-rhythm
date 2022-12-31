import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inNum = sc.nextInt();    // 숫자의 개수
        String inRow = sc.next();    // 공백없이 주어진 N개의 개수
        
        int cvtArr[] = Stream.of(inRow.split("")).mapToInt(Integer::parseInt).toArray(); 

        int sum = 0;
        for(int row : cvtArr){
            sum += row;
        }
        
        System.out.println(sum);
    }
}
