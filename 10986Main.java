import java.util.*;
public class Main {
    public static void main(String args[]){
        long answer = 0;

        Scanner sc = new Scanner(System.in);
        int N = 0;
        N = sc.nextInt();
        int M = 0;
        M = sc.nextInt();
        
        /*
        sum[0]          = arr[0]
        sum[1]          = arr[0] + arr[1]
        sum[2]          = arr[0] + arr[1] + arr[2]
        
        sum[0]%M == sum[2]%M
        => (sum[2]-sum[0])%M == 0 -> 구간합 배열
        
        sum[2] - sum[0]   =        arr[1] + arr[2]
        */
        long sum[] = new long[N];
        long idx[] = new long[M];
        for(int i=0; i<N; i++){
            int value = sc.nextInt();
            if(i > 0){
                sum[i] = sum[i-1] + value;
            }
            else {
                sum[i] = value;
            }
            sum[i] = sum[i] % M;
            if(sum[i] == 0){
                answer++;
            }
            idx[(int)sum[i]]++;
        }

        for(int i=0; i<M; i++){
            //동일한 나머지 값을 갖는 부부합의 개수
            //nC2 => n * (n-1) / 2
            if(idx[i] > 1){
                answer += (idx[i] * (idx[i] - 1) / 2); 
            }
        }
        System.out.println(answer);
    }
}
