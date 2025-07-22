package day10;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.val;

public class D08TodayVote {
    public static void main(String[] args) {
        // 투표 : 각 메뉴마다 득표 수를 저장
        String menu = "치킨, 떡볶이, 스파게티, 삼겹살, 곱창";
        Map<String, Integer> map = new LinkedHashMap<>();
        // 메뉴 등록 (value 값은 득표수)
        map.put("치킨", 0);
        map.put("떡볶이", 0);
        map.put("스파게티", 0);
        map.put("삼겹살", 0);
        map.put("곱창", 0);

        System.out.println("오늘의 저녁 메뉴 투표입니다.");
        System.out.println("메뉴 목록 : " + menu);
        Scanner sc = new Scanner(System.in);
        // 반복해서 원하는 메뉴 입력
        while (true) {
            System.out.print("투표 하세요.( 메뉴 목록 참고) >>>");
            String key = sc.next();
            if (key.equals("end")) // key값을 입력할 때 end라고 입력하면 break
                break; // 반복 종료는 end 입력
            // 입력된 key에 해당하는 현재 value 를 가져와서 +1 하여 다시 저장하기
            if (map.containsKey(key)) { // contains는 맞는 값인지 확인하는 boolean true면 실행
                int value = map.get(key); // key 에 해당하는 value. 없는 key는 오류.
                // 해당하는 key값의 value를 가져옴
                value++;
                // ?
                map.put(key, value); // put 이 변경의 기능도 있으니 put을 넣으면 됨
                // map.put(key, map.getOrDefault(key, value) + 1);
            } else {
                System.out.println("없는 메뉴입니다.");
            }

        }
        System.out.println("투표 결과");
        System.out.println(map);
        sc.close();

    }
}
