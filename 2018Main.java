import java.util.*;

public class Main {
    public static void main(String args[]){
        //BufferReader br = new BufferReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;
        
        int count = 1;
        int str_idx = 1;
        int end_idx = 1;
        while(end_idx < N){
            sum += end_idx;

            if(sum == N){
                count++;
                str_idx++;
                end_idx = str_idx;
                sum = 0;
            }
            else if(sum < N){
                end_idx++;
            }
            else if(sum > N){
                sum = 0;
                str_idx++;
                end_idx = str_idx;
            }
        }

        System.out.println(count);
    }
}
