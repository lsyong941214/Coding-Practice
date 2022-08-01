import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        
        PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
        while(N > 0){
            long key = N%10;
            que.add(key);
            N = N/10;
        }

        while(!que.isEmpty()){
            System.out.print(que.poll());
        }
        
    }
}