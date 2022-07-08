import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());//문자열의 길이
        int P = Integer.parseInt(st.nextToken());//비밀번호의 길이
        int count = 0;

        String dna = bf.readLine();
        //A, C, G, T
        int[] min_count = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            min_count[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int[] curr_cnt = new int[4];
        while(idx + P <= S){
            String pwd = dna.substring(idx, idx + P);
            for(int i=0; i<P; i++){
                char word = pwd.charAt(i);
                if(word == 'A'){
                    curr_cnt[0]++;
                }
                else if(word == 'C'){
                    curr_cnt[1]++;
                }
                else if(word == 'G'){
                    curr_cnt[2]++;
                }
                else if(word == 'T'){
                    curr_cnt[3]++;
                }
            }
            Boolean flag = false;
            for(int i=0; i<4; i++){
                if(curr_cnt[i] >= min_count[i]){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
               count++; 
            }
            idx++;
        }
        
        System.out.println(count);
        bf.close();
    }
}
