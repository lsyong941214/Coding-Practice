import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        //A[i-L] ~ A[i-1] 중 최소값
        Deque<Node> que = new LinkedList<>();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!que.isEmpty() && que.getLast().value > now){
                que.removeLast();
            }
            que.addLast(new Node(now,i));

            if(que.getFirst().index <= i-L){
                que.removeFirst();
            }
            bw.write(que.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node {
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}