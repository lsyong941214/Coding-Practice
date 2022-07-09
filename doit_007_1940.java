package doitCoding_03;

import java.util.Scanner;

public class doit_007_1940 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int start = 0;
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
	
		for(start=0; start<N-1; start++) {
			
			int end = start+1;

			while(end < N){
				if(arr[start] + arr[end] == M) {
					ans++;
					break;
				} else {
					end++;
				}
			}

		}
		
		System.out.println(ans);

	}


}
