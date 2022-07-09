import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int[] result = new int[N];

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for(int key:result){
            bw.append(key + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}