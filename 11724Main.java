import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] node;
    static int[] visited;
    static int result;
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        visited = new int[N+1];
        
        for(int i=1; i<N+1; i++){
            node[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
            node[v].add(u);
        }

        result = 0;
        for(int i=1; i<N+1; i++){
            if(visited[i] == 0){
                result++;
                dfs(i);
            }
        }

        System.out.println(result);
    }
    public static void dfs(int curr){
        if(visited[curr] == 1){
            return;
        }
        
        visited[curr] = 1;
        for(int f : node[curr]){
            if(visited[f] == 0){
                dfs(f);
            }
        }
    }
} 