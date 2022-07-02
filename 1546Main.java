import java.util.*;
public class 1546Main {
    public static void main(String args[]){
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = 0;
        N = sc.nextInt();
        long max = 0;
        long arr[] = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = 0;
            arr[i] = sc.nextLong();
            if(max < arr[i]){
                max = arr[i];
            }
        }
        for(int i=0; i<N; i++){
            answer += arr[i];
        }
        System.out.println((answer*100.0/max)/N);
    }
}
