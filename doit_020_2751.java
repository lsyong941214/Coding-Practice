package dotiCoding04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class doit_020_2751 { 
	
	public static int arr[];
	public static int temp[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1]; 
		temp = new int[N+1]; 
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		merge_sort(1, N);
		
		for(int i=1; i<=N; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
			  		
	}	
	
	public static void merge_sort(int start, int end) {
		
		if((end-start)<1) return;
		
		int middle = start + (end-start)/2;
		
		merge_sort(start, middle);
		merge_sort(middle+1, end);

		for(int i=start; i<=end; i++) {
			temp[i] = arr[i];		
		}
		
		int index1 = start;
		int index2 = middle+1;
		int k = start;
		
		while(index1 <= middle && index2 <= end) {
			if(temp[index1] > temp[index2]) {
				arr[k] = temp[index2];
				k++;
				index2++;
			}		
			else{
				arr[k] = temp[index1];
				k++;
				index1++;
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



