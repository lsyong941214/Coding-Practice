package doitCoding_03;

import java.util.Scanner;

public class doit_003_11659 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int arr[] = new int[N+1];
		int sum[] = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] = sc.nextInt();
			
			sum[i] = arr[i] + sum[i-1];
		}
		
		for(int i=0; i<M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			System.out.println(sum[num2]-sum[num1-1]);
		}
		
		
	}

}
