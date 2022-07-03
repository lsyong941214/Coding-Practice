package doitCoding_03;

import java.util.Scanner;

public class doit_002_1546 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        // 시험을 본 과목의 개수
        int n = sc.nextInt();
        
        // 각 과목의 시험 성적 배열에 넣기
        int subject[] = new int[n];
        long max = 0; // 최댓값
        long sum = 0; // 합
        for(int i=0; i<n; i++){
            subject[i] = sc.nextInt();
            if(max < subject[i]) max = subject[i];
            sum += subject[i];
        }
        
        System.out.println(sum*100.0/max/n);
	}

}
