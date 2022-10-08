package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class game_map_short_1844 {
	
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int maps[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M ; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(maps);
	}
	

    public static void solution(int[][] maps) {
        int answer = 0;
        
        bfs(maps,0,0);
        
        if(visited[N-1][M-1]) {
        	answer = maps[N-1][M-1];
        }
        else answer = -1;
        
        System.out.print(answer);
    }
    
    public static void bfs(int maps[][], int x, int y) {
    	visited = new boolean[N][M];
    	
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {x,y});
    	visited[x][y] = true;
    	
    	while(!que.isEmpty()) {
    		int num[] = que.poll();
	    	for(int i=0; i<4; i++) {	    		
	    		int n = num[0] + dx[i];
	    		int m = num[1] + dy[i];
	    		
	    		if(n>=0 && m>=0 && n<N && m<M) {
		    		if(maps[n][m] == 1 && !visited[n][m]) {
		    			visited[n][m] = true;
		    			maps[n][m] = maps[num[0]][num[1]] + 1;
		    			que.add(new int[] {n,m});
		    		}
	    		}
	    	}
        }
    }
	
			
}