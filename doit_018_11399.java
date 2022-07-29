package doitCoding_03;

import java.util.Scanner;

public class doit_018_11399 { 

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		int sum[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] =  sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			int insert_point = i;
			int insert_value = arr[i];
			
			for(int j=i-1; j>=0; j--) {
				if(arr[j] <arr[i]) {
					insert_point = j+1;
					break;
				}
				if(j==0) insert_point=0;
			}
			
			for(int j=i; j>insert_point; j--) {
				arr[j]= arr[j-1];
			}
			arr[insert_point] = insert_value;
		}
		

		for(int i=0; i<N; i++) {
			if(i==0) {
				sum[i] = arr[i];
			}else {
				sum[i] = sum[i-1]+arr[i];
			}
		}
		
		int ans=0;
		for(int i=0; i<N; i++) {
			ans += sum[i];
		}
		
		System.out.println(ans);
	}

}



