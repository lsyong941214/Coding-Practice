import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        //9
        int idx = 0;
        for(int i=0; i<N; i++){
            idx = i;
            while(idx < N){
                if(!que.isEmpty()){
                    int comp = que.peek();
                    //현재 que에 있는 데이터와 수열을 비교
                    if(comp <= arr[i]){
                        que.poll();
                        idx++;
                        if(idx >= N){
                            //result[i] = -1;
                            bw.append(-1 + " ");
                        }else{
                            que.add(arr[idx]);
                        }
                    }
                    else{
                        bw.append(comp + " ");
                        break;
                    }
                }
                else{
                    que.add(arr[i]);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}