package day10;

import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class D07MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // 1. 데이터 저장(추가, 변경)
        map.put("t1", "사나");
        map.put("t2", "모모");
        map.put("t3", "나연");
        map.put("t4", "다현");
        map.put("t1", "나나"); // key "t1" 의 value 가 사나 -> 나나로 변경
        // put 메소드가 추가 기능도 있지만 같은 값이 있을 경우 변경도 가능

        // 2. map 의 크기
        System.out.println("map 크기 : " + map.size());
        // 출력값 : 4

        // 3. toString 출력
        System.out.println("map : " + map);
        // 출력값 : {t4=다현, t1=나나, t2=모모, t3=나연} 순서는 Set마냥 무작위

        // 4. LinkedHashMap
        // 생성자로 전달된 map 의 값을 linkMap 에 저장하기
        Map<String, String> linkMap = new LinkedHashMap<>();
        linkMap.put("t1", "사나");
        linkMap.put("t2", "모모");
        linkMap.put("t3", "나연");
        linkMap.put("t4", "다현");
        System.out.println("LinkedHashMap : " + linkMap);
        // 출력값 : {t1=사나, t2=모모, t3=나연, t4=다현}

        // 5. TreeMap
        Map<String, String> treeMap = new TreeMap<>(map);
        System.out.println("TreeMap : " + treeMap);
        // 출력값 : {t1=나나, t2=모모, t3=나연, t4=다현}

        // 6. key 로 value 가져오기
        String temp = treeMap.get("t1");
        System.out.println("t1 의 value : " + temp);
        temp = treeMap.get("t2");
        System.out.println("t2 의 value : " + temp);
        // 출력값 : t1의 value : 사나 t2의 value : 모모

        //
        System.out.println("keyset : " + treeMap.keySet());
        // 출력값 : keyset : {t1, t2, t3, t4}

        // 7. map 의 반복문
        for (String key : treeMap.keySet()) {
            // map 의 key 값만 모아서 set 을 만들고 (keyset) 여기서 key를 가져와 반복
            System.out.println(key + ":" + treeMap.get(key));
        }
        // 출력값 : t1:나나 \t t2:모모 \t t3:나연 \t t4:다현

        System.out.println("Map.Entry 내부클래스는 k,v 를 한쌍으로 저장.");
        System.out.println("\nentry set : " + treeMap.entrySet().toString());
        System.out.println("~~~ entry set 반복문(stream) ~~~");
        System.out.println("key 와 value 의 getter 는 entry 타입으로 각각 가져옵니다.");
        // for 문 작성해보세요.
        treeMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry + "     " + entry.getKey() + "," + entry.getValue()));

        System.out.println("values : " + treeMap.values());
        // 출력값 : values : [나나, 모모, 나연, 다현]
    }

}
/*
 * 지금까지 hash라는 단어를 많이 사용함
 * hash(해시함수)
 * 입력값 --> 해시함수 --> 출력값
 * 
 * "abc" (데이터)
 * 3.14 (데이터) ---- hash(해시함수) --> 고유한 식별값(고정길이)을 만듭니다. --> 객체의 참조값(hashcode)
 * 999 (데이터)
 * hashcode는 참조값(주소 X!)
 * 
 * 
 * Member 객체(속성)
 * Set 또는 Map 에 저장된 요소(객체) -> 각각의 요소를 저장하면 접근을 위한
 * 참조값이 필요합니다. 참조값은 해시함수를 사용한 해시테이블에 저장합니다.
 * Map 은 key값을 입력으로 하여 해시값을 생성합니다. -> value 객체의 참조값
 * ✅ Map을 예시로하면 'key', 'key의 객체가 저장된 참조값(해시)'를 표 형식으로 저장
 * 
 * 해시 함수 사용 예시 : 비밀번호 저장 등에 사용.
 * 
 * ✅ 해시 함수 특징 :
 * 1) 해시값을 다시 평문(입력값)으로 변환할 수 없음.
 * 2) 입력값이 다르면 해시값도 다른 값이 나와야 함. (알고리즘의 중요성)
 * 
 * 
 */