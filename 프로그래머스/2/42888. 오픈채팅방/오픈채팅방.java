/*
로그 남기고
닉네임 변경 -> 해당 로그 닉네임 싹 변경
*/

import java.io.*;
import java.util.*;

class Solution {
    static String leave = "님이 나갔습니다.";
    static String enter = "님이 들어왔습니다.";
    //id, nick
    static HashMap<String, String> map = new HashMap<>();
    public String[] solution(String[] record) {
        String[] answer = {};
        
        for(String id : record) {
            String[] arr = id.split(" ");
            if(arr[0].equals("Enter") || arr[0].equals("Change")) {
                map.put(arr[1], arr[2]);    
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String id : record) {
            String[] arr = id.split(" ");
            String nick = map.get(arr[1]);
            switch(arr[0]) {
                case "Enter" : {                    
                    sb.append(nick).append(enter+"/");
                } break;
                case "Leave" : {
                    sb.append(nick).append(leave+"/");
                }break;
            }
        }
        
        
        return sb.toString().split("/");
    }
    
}