package dotiCoding04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class doit_021_1517 { 	
	
	public static int arr[];
	public static int temp[];
	public static long result = 0;
	
		public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		temp = new int[N+1];
		
        st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(1, N);
	  	
		System.out.print(result);
	
	}	

	public static void merge_sort(int start, int end) {
		
		if((end - start) < 1) return;
		
		int middle = start + (end-start)/2;
		
		merge_sort(start, middle);
		merge_sort(middle+1, end);
		
		for(int i=start;i<=end; i++) {
			temp[i] = arr[i];
		}
		
		int k = start;
		int index1 = start;
		int index2 = middle+1;
		
		while(index1 <= middle && index2 <= end) {
			
			if(temp[index1] < temp[index2]) {
				arr[k] = temp[index1];
				k++;
				index1++;
			} else { 
				arr[k] = temp[index2];
				result = result + (index2-k);				
				k++;
				index2++;
			}
			
		}
		
		while(index1 <= middle) {
			arr[k] = temp[index1];
			k++;
			index1++;
		}
		
		while(index2 <= end) {
			arr[k] = temp[index2];
			k++;
			index2++;
		}
		
	}
	

}



