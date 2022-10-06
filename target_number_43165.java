package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class target_number_43165 {
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int numbers[] = new int[N];
		int target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(numbers, target);
		System.out.println(answer);
	}
	
	public static int solution(int[] numbers, int target) {
        
        
        dfs(numbers,0,0,target);
        
        return answer;
    }
	
	public static void dfs(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {
        	if(sum == target) answer++;        	
        	return;
        }
        
        sum += numbers[index];
        dfs(numbers,index+1,sum,target);
        
        sum -= numbers[index]*2;
        dfs(numbers,index+1,sum,target);
    }

}