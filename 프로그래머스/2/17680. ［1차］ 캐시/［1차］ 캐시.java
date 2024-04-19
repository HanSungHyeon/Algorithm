/*
LRU - 가장 구석에 있는 값은(오랫동안 사용하지 않은 캐시) 더 이상 사용할 확률이 적다고 판단
캐시 히트 : CPU가 참조하고자 하는 값이 캐시에 존재하고 있는 경우
-> 기존 값을 제거하고 맨 앞에 추가
캐시 미스 : 참조하고자 하는 값이 캐시에 존재하지 않는 경우
-> 가장 오래된 값을 제거하고 새로운 값을 맨 뒤에 추가
0 인덱스 = 오래된 거 head
last 인덱스 = 최근거 rear
5 5 5 5 5
*/

import java.io.*;
import java.util.*;

class Solution {
    static LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for(String city : cities) {
            city = city.toUpperCase();
            if(map.containsKey(city)) {
                answer += cacheHit(city);
            }
            else answer += cacheMiss(city, cacheSize);
        }
        return answer;
    }
    //캐시 히트
    static int cacheHit(String city) {
        map.remove(city);
        map.put(city, 0);
        return 1;
    }
    //캐시 미스
    static int cacheMiss(String city, int size) {
        if(size == 0) return 5;
        
        if(map.size() >= size) {
        //head 제거
            for(String key : map.keySet()) {
                map.remove(key);
                break;
            }    
        }
        
        map.put(city, 0);
        return 5;
    }
}