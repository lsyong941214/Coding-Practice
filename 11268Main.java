import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            int o1_abs = Math.abs(o1);
            int o2_abs = Math.abs(o2);

            if(o1_abs == o2_abs){
                return o1 > o2 ? 1 : -1;
            }
            else {
                return o1_abs - o2_abs;
            }
        });
        String result = "";
        int N = Integer.parseInt(bf.readLine());
        //initialize
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(bf.readLine());

            if(x != 0){
                que.add(x);
            }else {
                if(que.isEmpty()){
                    result += "0\n";
                }
                else{
                    result += que.poll().toString() + "\n";
                }
            }
        }
        System.out.print(result);
        bf.close();
    }
}