import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        int N = sc.nextInt();
        //initialize
        for(int i=1; i<=N; i++){
            que.add(i);
        }
        while(que.size() > 1){
            //가장 위 카드 버리기
            que.poll();
            //그 다음 카드 아래에 추가하기
            int top = que.poll();
            que.add(top);
        }
        System.out.println(que.poll());
    }
}