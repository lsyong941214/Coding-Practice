import java.io.*;
import java.util.*;

public class Main {
    static int[] min_cnt;
    static int[] curr_cnt;
    static int check_cnt;

    public static void main(String args[]) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());//문자열의 길이
        int P = Integer.parseInt(st.nextToken());//비밀번호의 길이
        int answer = 0;

        String dna = bf.readLine();
        check_cnt = 0;
        //A, C, G, T
        min_cnt = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            min_cnt[i] = Integer.parseInt(st.nextToken());
            if(min_cnt[i] == 0){
                check_cnt++;
            }
        }
        curr_cnt = new int[4];
        //initialize string
        for(int i=0; i<P; i++){
            add(dna.charAt(i));
        }
        if(check_cnt == 4){
            answer++;
        }
        
        for(int i=P; i<S; i++){
            add(dna.charAt(i));
            remove(dna.charAt(i-P));

            if(check_cnt == 4){
                answer++;
            }
        }
        System.out.println(answer);
        bf.close();
    }

    public static void add(char k){
        switch(k){
            case 'A':
                curr_cnt[0]++;
                if(curr_cnt[0] == min_cnt[0]){
                    check_cnt++;
                }
                break;
            case 'C':
                curr_cnt[1]++;
                if(curr_cnt[1] == min_cnt[1]){
                    check_cnt++;
                }
                break;
            case 'G':
                curr_cnt[2]++;
                if(curr_cnt[2] == min_cnt[2]){
                    check_cnt++;
                }
                break;
            case 'T':
                curr_cnt[3]++;
                if(curr_cnt[3] == min_cnt[3]){
                    check_cnt++;
                }
                break;
        }
    }

    public static void remove(char k){
        switch(k){
            case 'A':
                if(curr_cnt[0] == min_cnt[0]){
                    check_cnt--;
                }
                curr_cnt[0]--;
                break;
            case 'C':
                if(curr_cnt[1] == min_cnt[1]){
                    check_cnt--;
                }
                curr_cnt[1]--;
                break;
            case 'G':
                if(curr_cnt[2] == min_cnt[2]){
                    check_cnt--;
                }
                curr_cnt[2]--;
                break;
            case 'T':
                if(curr_cnt[3] == min_cnt[3]){
                    check_cnt--;
                }
                curr_cnt[3]--;
                break;
        }
    }
}
