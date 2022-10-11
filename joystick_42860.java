package programmers;

import java.util.Scanner;

public class joystick_42860 {
	
	static int answer = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		solution(name);		
		System.out.print(answer);
	}
	
	public static int solution(String name) {
        
        int move = name.length()-1; //현재 인덱스 위치
        
        for(int i=0; i<name.length(); i++) {
        	// "상"으로 갈지, "하"로 갈지 선택
        	answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
        	
        	// "좌" 선택할지, "우" 선택할지
        	int aIndex = i+1; // 연속되는 A의 마지막 인덱스 파악
        	while(aIndex<name.length() && name.charAt(aIndex)=='A'){
        		aIndex++;
        	}
        	
        	move = Math.min(move, i*2+(name.length()-aIndex));
        	move = Math.min(move, (name.length()-aIndex)*2+i);
        }
        
        answer += move;
        
        return answer;
	}
	

}