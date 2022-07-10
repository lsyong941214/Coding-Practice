package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class doit_009_12891 { 

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		int engNum[] = new int[4];
		for(int i=0; i<4; i++) { // a,c,g,t 개수
			engNum[i] = Integer.parseInt(st.nextToken());
		}
		
		char charArr[] = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		int start = 0;
		int end = P-1;
		int chk[] = new int[4];

		while(end != S) {
			if(start == 0) {
				for(int i=0; i<P; i++) {		
					if(charArr[i] == 'A') chk[0]++; 
					else if(charArr[i] == 'C') chk[1]++; 
					else if(charArr[i] == 'G') chk[2]++; 
					else if(charArr[i] == 'T') chk[3]++;
				}
			}
			else {
				if(charArr[start-1] == 'A') chk[0]--; 
				else if(charArr[start-1]== 'C') chk[1]--; 
				else if(charArr[start-1] == 'G') chk[2]--; 
				else if(charArr[start-1] == 'T') chk[3]--;
				
				if(charArr[end] == 'A') chk[0]++; 
				else if(charArr[end] == 'C') chk[1]++; 
				else if(charArr[end] == 'G') chk[2]++; 
				else if(charArr[end] == 'T') chk[3]++;

			}
			if(engNum[0] <= chk[0] && engNum[1] <= chk[1] && engNum[2] <= chk[2] && engNum[3] <= chk[3]) ans++;
			start++;
			end++;
		}
		
		System.out.println(ans);
		
	}
}
