package doitCoding_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class doit_027_2178 {
	
	static int[] bx = {0,0,-1,1}; // 상하좌우
	static int[] by = {-1,1,0,0};
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;
	static int count;
		
 	public static void main(String[] args) throws IOException {
 		
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		N = Integer.parseInt(st.nextToken());
 		M = Integer.parseInt(st.nextToken());
 		
 		arr = new int[N+1][M+1];
 		visited = new boolean[N+1][M+1];
 		
 		for(int i=1; i<N+1; i++) {
 			st = new StringTokenizer(br.readLine());
 			String line = st.nextToken();
 			for(int j=1; j<M+1; j++) {
 				arr[i][j] = Integer.parseInt(line.substring(j-1, j));
 			}
 		}
 		
 		count=1;
 		
 		BFS(1,1);
 		System.out.println(arr[N][M]);

	}
 	
 	public static void BFS(int n, int m) {
 		
 		visited[n][m] = true;
 		
 		Queue<int[]> que = new LinkedList<>();
 		que.add(new int[]{n,m});
 		 	
 		while(!que.isEmpty()) {
 			int now[] = que.poll();
	 		for(int i=0; i<4; i++) {

	 			int x = now[0] + bx[i];
	 			int y = now[1] + by[i];
	 			
	 			if(x>0 && y>0 && x<=N && y<=M) {
	 				if(!visited[x][y] && arr[x][y] == 1) {
	 					visited[x][y] = true;
	 					arr[x][y] = arr[now[0]][now[1]]+1;
	 					que.add(new int[] {x,y});
	 				}
	 			}
	 			
	 		}
 		}
 	}

}
