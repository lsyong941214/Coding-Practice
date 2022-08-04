import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int jari;
    public static void main(String args[]) throws IOException {
        
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
        
    }
    public static Boolean isPrime(int num){
        for(int i=2; i<=num/2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void DFS(int num, int len){
        if(len == N){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }
        len++;
        for(int i=1; i<10; i++){
            if(isPrime(num * 10 + i)){
                DFS(num * 10 + i, len);
            }
        }
    }
} 