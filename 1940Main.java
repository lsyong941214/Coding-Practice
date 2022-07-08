import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int str_idx = 0;
        int end_idx = N-1;
        while(str_idx < end_idx){
            if(arr[str_idx] + arr[end_idx] == M){
                count++;
                str_idx++;
                end_idx--;
            }
            else if(arr[str_idx] + arr[end_idx] < M){
                str_idx++;
            }
            else if(arr[str_idx] + arr[end_idx] > M){
                end_idx--;
            }
        }
        
        System.out.println(count);
        br.close();
    }
}
