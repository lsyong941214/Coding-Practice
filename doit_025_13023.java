package doitCoding_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class doit_025_13023 {
	
	static int N;
	static int M;
	static ArrayList<Integer>[] arrayList;
	static boolean visited[];
	static boolean result;
	
 	public static void main(String[] args) throws IOException {
 		
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		N = Integer.parseInt(st.nextToken());
 		M = Integer.parseInt(st.nextToken());
 		
 		arrayList = new ArrayList[N];
 		visited = new boolean[N];
 		
 		for(int i=0; i<N;i++) {
 			arrayList[i] = new ArrayList<Integer>();
 		}
 		
 		for(int i=0; i<M; i++) {
 			st = new StringTokenizer(br.readLine());
 			int n = Integer.parseInt(st.nextToken());
 			int m = Integer.parseInt(st.nextToken());
 			
 			arrayList[n].add(m);
 			arrayList[m].add(n);
 		}
 		
 		for(int i=0;i<N; i++) {
 			DFS(i,1);
 			
 			if(result) break;
 		}
 		
 		if(!result) System.out.println(0);
 		
 		if(result) System.out.println(1);

	}
 	
 	public static void DFS(int people, int count) {
 		
 		if(count == 5 || visited[people]) {
 			result = true;
 			return;
 		}
 		
 		visited[people] = true;
 		
 		for(int i: arrayList[people]) {
 			if(!visited[i]) {
 //				count++;
 //				DFS(i, count);
 				DFS(i, count+1);
 			}
 		}
 			
 		visited[people] = false;
 //		count--;
 	}
 		
}
