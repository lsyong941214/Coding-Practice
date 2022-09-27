package doitCoding_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class doit_030_2343 {
			
 	public static void main(String[] args) throws IOException {
 		
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		int lesson = Integer.parseInt(st.nextToken());
 		int bluelay = Integer.parseInt(st.nextToken());
 		
 		int start = 0;
 		int end = 0;
 		
 		int arr[] = new int[lesson];
 		int sumarr = 0 ;
 		st = new StringTokenizer(br.readLine());
 		for(int i=0; i<lesson; i++) {
 			arr[i] = Integer.parseInt(st.nextToken());
 			sumarr += arr[i];
 			if (start < arr[i]) {
 		      start = arr[i]; // 레슨 최대값을 시작인덱스로 저장
 			}
 		}
 		
 		//start = arr[lesson-1];
 		end = sumarr;
 		int middle = 0;
 		int sum = 0;
 		int count = 0;
 		
 		while(start <= end) {
 			middle = (start+end)/2;
 					
 			for(int i=0; i<lesson; i++) {
 				
 				// 블루레이 안에 다 담기는지 확인
 				if(sum + arr[i] > middle) { // 블루레이 안에 다 담기지 않으면, count 올리고 새롭게 블루레이에 담는다.
 					count++;
 					sum = 0;
 				}
 				sum += arr[i];
 				
 			}
 			
 			if(sum != 0) count++; // sum이 0이 아니면 블루레이가 하나 더 필요
 			
 			if(count > bluelay) start = middle+1;
 			else end = middle-1;
 			
 			count = 0;
 			sum = 0;
 		}
 		
 		System.out.println(start);
 		
 		

	}

}