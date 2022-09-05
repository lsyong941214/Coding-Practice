package doitCoding_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class doit_029_1920 {
			
 	public static void main(String[] args) throws IOException {
 		
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		int N = Integer.parseInt(st.nextToken());
 		
 		int arr[] = new int[N];
 		
 		st = new StringTokenizer(br.readLine());
 		for(int i=0; i<N; i++) {
 			arr[i] = Integer.parseInt(st.nextToken());
 		}
 		
 		Arrays.sort(arr);
 		
 		st = new StringTokenizer(br.readLine());
 		int M = Integer.parseInt(st.nextToken());
 		 		
 		int arrFind[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
		   arrFind[i] = Integer.parseInt(st.nextToken());
		}
 		
 		for(int i=0; i<M; i++) {
 			int start = 0;
 	 		int end = N-1;
 			int find = arrFind[i];
 			boolean bl = false;
 			while((end-start) >= 0) {			
 				int middle = (start + end)/2;
 				
 				if(find == arr[middle]) {
 					System.out.println(1);
 					bl = true;
 					break;
 				}
 				else if(find < arr[middle]) {
 					end = middle-1;
 				}
 				else {
 					start = middle+1;
 				}
 			}
 			
 			if(bl == true) continue;
 			else System.out.println(0);
 		}
 		
	}
 	
}