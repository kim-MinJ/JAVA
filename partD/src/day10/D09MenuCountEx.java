package day10;

import java.util.HashMap;
import java.util.Map;

public class D09MenuCountEx {
    public static void main(String[] args) {

        String[] votes = { "치킨", "떡볶이", "스파게티", "삼겹살", "곱창", "치킨", "스파게티", "스파게티", "곱창", "치킨" };

        // 배열의 값을 Map으로 저장하면서 동시에 메뉴(key)가 몇번 나왔는지(value) 카운트
        Map<String, Integer> menuCount = new HashMap<>();
        for (String key : votes) { // votes에 있는 문자열을 key값에 넣어줌 key <= votes
            if (menuCount.containsKey(key)) { // menuCount 내에 존재하는 key값이라면 실행
                menuCount.put(key, menuCount.get(key) + 1); // 한번 나온 메뉴. map에 저장된 상태
                // key값이 있는 상태라면 key의 value값에 +1
            } else {
                menuCount.put(key, 1); // 처음 나온 메뉴. map에 저장 안된 상태
                // key값이 없는 상태라면 새로운 key값을 넣어주면서 동시에 value를 1로 만들어줌
            }
        }

        Map<String, Integer> menuCount2 = new HashMap<>();
        for (String key : votes) { // votes에 있는 문자열을 key값에 넣어줌
            menuCount2.put(key, menuCount2.getOrDefault(key, 0) + 1);
            // 위의 for 문의 if 역할 메소드 사용합니다.
            // getOrDefault 는 key 값이 있으면 가져오고 없으면 기본값 0 으로 리턴
            // menuCount2에 value값이 있다면 get(key), 없다면(or) 기본값생성(Default) 0을 주면서 바로 +1 해서 가본값
            // 1이 됨
        }

        System.out.println("메뉴 득표수");
        for (String key : menuCount2.keySet()) { // menuCount2의 keySet(key값 전부)를 key에 넣어줌
            System.out.println(key + " : " + menuCount2.get(key));
            // key값(투표에서 나온 음식메뉴) + menuCount2의 value값(득표수) 나열
        }
    }

}