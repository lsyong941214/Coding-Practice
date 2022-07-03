import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = 0;
        int M = 0;
        N = sc.nextInt();
        M = sc.nextInt();

        int answer[] = new int[M];

        int arr[] = new int[N];
        int sum[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if(i == 0){
                sum[i] = arr[i];
            }else if(i > 0){
                sum[i] = sum[i-1] + arr[i];
            }
        }
        /*
        s[0] = a[0]
        s[1] = a[0] + a[1]
        s[2] = a[0] + a[1] + a[2]
        s[3] = a[0] + a[1] + a[2] + a[3]
        s[4] = a[0] + a[1] + a[2] + a[3] + a[4]
        s[5] = a[0] + a[1] + a[2] + a[3] + a[4] + a[5]
        */
        for(int i=0; i<M; i++){
            int str = 0;
            str = sc.nextInt() - 1;
            int end = 0;
            end = sc.nextInt() - 1;
            
            if(str == 0){
                answer[i] = sum[end];
            }
            else if(str > 0){
                answer[i] = sum[end] - sum[str-1];
            }
        }

        for(int k : answer){
            System.out.println(k);
        }
    }
}
