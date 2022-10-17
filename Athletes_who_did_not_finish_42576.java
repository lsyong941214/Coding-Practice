package programmers;

import java.util.*;

public class Athletes_who_did_not_finish_42576 {
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String player : participant) 
            map.put(player, map.getOrDefault(player,0)+1);
        
        for(String player : completion)
            map.put(player, map.get(player)-1);
        
        for(String player : map.keySet())
            if(map.get(player) != 0) answer = player;
        return answer;
    }

}