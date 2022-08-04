import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] node;
    static Boolean[] visited;
    static Boolean flag;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        node = new ArrayList[N];
        visited = new Boolean[N];
        for(int i=0; i<N; i++){
            node[i] = new ArrayList<Integer>();
            visited[i] = false;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            node[u].add(v);
            node[v].add(u);
        }
        flag = false;
        for(int i=0; i<N; i++){
            DFS(i, 1);
            if(flag){
                break;
            }
        }
        if(flag){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
        
    }
    public static void DFS(int n, int depth){
        if(depth == 5 || flag){
            flag = true;
            return;
        }
        visited[n] = true;
        for(int i : node[n]){
            if(!visited[i]){
                DFS(i, depth+1);
            }
        }
        visited[n] = false;
    }
} 