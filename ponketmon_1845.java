package programmers;

import java.util.HashSet;
import java.util.Scanner;

public class ponketmon_1845 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.print(solution(arr));
	}

    public static int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        answer = set.size();
        if(answer > nums.length/2) answer = nums.length/2;
        
        return answer;
    	}
}