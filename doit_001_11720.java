package doitCoding_03;

import java.util.Scanner;

public class doit_001_11720 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 숫자의 개수 받기
		int num = scanner.nextInt();
		
		// 공백 없이 주어진 N개의 숫자
		String str = scanner.next();
		
		int sum = 0; 
		
		for(int i=0; i<str.length(); i++) {
			
			char ch= str.charAt(i);
			sum += ch-'0';
		}
		
		System.out.println(sum);
	}

}
