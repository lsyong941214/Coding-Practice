import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        StringBuffer result = new StringBuffer();
        int num = 1;
        for(int i=0; i<N; i++){
            if(num <= arr[i]){
                while(num <= arr[i]){
                    stack.push(num++);
                    result.append("+\n");
                }
                stack.pop();
                result.append("-\n");
            }
            else {
                int top = stack.pop();
                if(top > arr[i]){
                    System.out.println("NO");
                    return;
                }
                else {
                    result.append("-\n");
                }
            }
        }
        System.out.println(result.toString());
    }
}