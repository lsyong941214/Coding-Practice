package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class doit_014_11286 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> {
			int first = Math.abs(a);
			int second = Math.abs(b);
			
			if(first == second) {
				return a > b ? 1 :-1;
			}
			else {
				return first-second;
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			
			if(x !=0) {
				que.add(x);
			} else {
				if(que.isEmpty()) System.out.println(0);
				else {
					 System.out.println(que.remove());				
				}
			}
		}
		
		
		
		

	}	

}

