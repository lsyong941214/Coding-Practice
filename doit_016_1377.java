package doitCoding_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class doit_016_1377 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		mData[] A = new mData[n];
		
		for(int i=0; i< n; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(A);
		int Max = 0;
		for(int i=0; i<n; i++) {
			if(Max < A[i].index - i) {
				Max = A[i].index - i;
			}
		}
		System.out.println(Max+1);
	}
}

class mData implements Comparable<mData>{
	int value;
	int index;
	
	public mData (int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(mData o) {
		return this.value - o.value;
	}
}



