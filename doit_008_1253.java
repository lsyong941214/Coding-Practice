package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class doit_008_1253 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N  = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);


		int ans = 0;
		int find = 0;
		
		
		for(find=0; find<N; find++) {
			int start = 0;
			int end = N-1;
			
			while(start<end) {
				if(arr[start] + arr[end] == arr[find]) {
					if(start != find && end != find) {
						ans++;
						break;
					}
					else if(start == find){
						start++;
					}
					else if(end == find) {
						end--;
					}
				} 
				else if(arr[start] + arr[end] < arr[find]) {
					start++;
				}
				else {
					end--;
				}
			}
		}
		
		System.out.println(ans);		
	}
}
