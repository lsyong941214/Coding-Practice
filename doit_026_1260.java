package doitCoding_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class doit_026_1260 {

	static ArrayList<Integer>[] arr;
	static boolean visited[];
	
 	public static void main(String[] args) throws IOException {
 		
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		int N = Integer.parseInt(st.nextToken());
 		int M = Integer.parseInt(st.nextToken());
 		int V = Integer.parseInt(st.nextToken());
 		
 		arr = new ArrayList[N+1];
 		
 		for(int i=1; i<N+1; i++) {
 			arr[i] = new ArrayList<Integer>();
 		}
 		
 		for(int i=0; i<M; i++) {
 			st = new StringTokenizer(br.readLine());
 			int s = Integer.parseInt(st.nextToken());
 			int e = Integer.parseInt(st.nextToken());
 			
 			arr[s].add(e);
 			arr[e].add(s);
 		}
 		
 		for(int i=1; i<N+1; i++) {
 			Collections.sort(arr[i]);
 		} 		
 		
 		visited = new boolean[N+1];
 		DFS(V);
 		System.out.println();
 		
 		visited = new boolean[N+1];
 		BFS(V);
	}
 	
 	public static void DFS(int v) {
 		
 		System.out.print(v+" ");
 		
 		visited[v] = true;
 		
 		for(int i : arr[v]) {
 			if(!visited[i]) {
 				DFS(i);
 			}
 		}
 	}
 	
 	public static void BFS(int v) {
 		
 		visited[v] = true;
 		
 		Queue<Integer> que = new LinkedList<>();
 		que.add(v);
 		
 		while(!que.isEmpty()) {
 			
 			int new_node = que.poll();
 			System.out.print(new_node+" ");
 			
 			for(int i : arr[new_node]) {
 				if(!visited[i]) {
 					visited[i] = true;
 					que.add(i);
 				}
 			}
 		}
 	}

}
