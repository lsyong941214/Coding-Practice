import java.util.*;
public class 11720Main {
    public static void main(String args[]){
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        int N = 0;
        N = sc.nextInt();

        String k = sc.next();

        for(int i=0; i<N; i++){
            answer += Integer.parseInt(k.substring(i, i+1));
        }
        System.out.println(answer);
    }
}
