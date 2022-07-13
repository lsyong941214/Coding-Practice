package doitCoding_03;

import java.util.Scanner;
import java.util.Stack;

public class doit_011_1874 { 

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
 		}
		
		int num= 1;
		int su = 0;
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		Boolean result = true; 
		
		for(int i=0; i<N; i++) {
			su = arr[i];
			if(su >= num) {
				while(su >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} 
			else {
				int n = stack.pop();
				
				if(su < n) {
					result= false;
					System.out.println("NO");
					
					break;
				}
				sb.append("-\n");
				
			}
		}
		if(result == true) System.out.println(sb.toString());
	}
}
