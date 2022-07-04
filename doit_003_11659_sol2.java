package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class doit_003_11659_sol2 {

	public static void main(String[] args) throws IOException{
		
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        
	        int sum[] = new int[N+1];
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i=1; i<N+1; i++){
	            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
	        }
	        
	        for(int i=0; i<M ; i++){
		        st = new StringTokenizer(br.readLine());
		        int num1 = Integer.parseInt(st.nextToken());
		        int num2 = Integer.parseInt(st.nextToken());
		        
		        System.out.println(sum[num2]-sum[num1-1]);	
	        }		
	}
}
