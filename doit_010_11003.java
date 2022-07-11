package doitCoding_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class doit_010_11003 { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
		
			int now = Integer.parseInt(st.nextToken());
				
			if(!mydeque.isEmpty() && mydeque.getLast().value > now ) {
				mydeque.removeLast();
			}
			
			mydeque.addLast(new Node(now, i));
			
			if(mydeque.getFirst().index <= i-L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");		
		}
		
		bw.flush();
		bw.close();	
		
	}
	
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
