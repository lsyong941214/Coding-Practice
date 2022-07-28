package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class doit_019_11004 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr, 0, N-1, K-1);
		System.out.println(arr[K-1]);
	
	}
	
	public static void quickSort(int[] arr, int start, int end, int K) {
		
		if(start < end) {
		
			int pivot = arraySort(arr, start, end);
			
			if(pivot < K) {
				quickSort(arr,start,pivot-1,K);
			} 
			else if (pivot > K) {
				quickSort(arr,pivot+1,end,K);
			}
			else return;
		}
	}
	 
	public static int arraySort(int[] arr, int start, int end) {
		
		int middle = (start+end)/2;
		
		swap(arr, start, middle);
		
		int pivot = arr[start];
		
		int i = start, j = end;
		
		while(i < j) {
			while(pivot > arr[i]) {
				i++;
			}
			while(pivot < arr[j]) {
				j--;
			}
			swap(arr, i, j);
		}
		
		arr[start] = arr[i];
		arr[i] = pivot;
		
		return i;
	}
	
	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}



