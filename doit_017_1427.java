package doitCoding_03;

import java.util.Scanner;

public class doit_017_1427 { 

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 String N = sc.next();
		 int arr[] = new int[N.length()];
		 
		 for(int i=0; i< N.length(); i++) {
			 arr[i] = N.charAt(i)-'0'; 
		 } 
		 
		 int index = 0;
		 
		 for(int i=0; i<N.length(); i++) {
			 index = i+1;
			 
			 while(index != N.length()) {
				 if(arr[i] < arr[index]) {
					 int temp = arr[index];
					 arr[index] = arr[i];
					 arr[i] = temp;
					 index++;
				 } else index++;
			 }			 
		 }
		 
		 for(int i=0; i<N.length(); i++) {
			 System.out.print(arr[i]);
		 }
	 

	}

}



