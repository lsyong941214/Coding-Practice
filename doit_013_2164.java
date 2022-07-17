package doitCoding_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class doit_013_2164 { 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			que.add(i+1);
		}
		
		int count = N;
		Boolean bl = true;
		while(count != 1 && true == bl) {
			que.remove();
			count--;
			
			que.add(que.remove());
			
			if(count == 1) bl = false;
		}
		
		System.out.println(que.remove());	

	}	

}

