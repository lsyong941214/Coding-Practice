package doitCoding_03;

import java.util.Scanner;

public class doit_005_10986 {

	public static void main(String[] args){
		
Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long sum[] = new long[N+1];
		long arr[] = new long[M];
		long answer = 0;
		int num = 0;
        
        for(int i=1; i<N+1; i++) {
			sum[i] = sum[i-1]+ sc.nextInt();
		}
		
		for(int i=1; i<N+1; i++) {
			num =(int)(sum[i] % M);
			if(num == 0) answer++;
			arr[num]++ ;
		}
		
		for(int i=0; i<M; i++) {
            if(arr[i]>1){
			    answer += (arr[i]*(arr[i]-1))/2;
               }
            }
		
		System.out.println(answer);

	}	
}
