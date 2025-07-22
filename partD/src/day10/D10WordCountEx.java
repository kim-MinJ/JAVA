package day10;

import java.util.HashMap;
import java.util.Map;

public class D10WordCountEx {
    public static void main(String[] args) {
        String lyrics = "Longing for you\r\n" +
                "Waiting for you\r\n" +
                "Hold me\r\n" +
                "Hold me in your eyes\r\n" +
                "너라는 걸\r\n" +
                "너뿐인 걸 모르겠니\r\n" +
                "I will be your love\r\n" +
                "\r\n" +
                "오 빨간 운동화 짧은 청바지\r\n" +
                "참 어째도 해결이 안 될 것 같은 곱슬머리\r\n" +
                "하지만 왜일까 자꾸 끌리는 내 마음이\r\n" +
                "어쩌면 사랑 아닐까\r\n" +
                "\r\n" +
                "Longing for you\r\n" +
                "Waiting for you\r\n" +
                "Hold me\r\n" +
                "Hold me in your eyes\r\n" +
                "너라는 걸\r\n" +
                "너뿐인 걸 모르겠니\r\n" +
                "I will be your love";

        // \s 정규식 기호는 공백, 탭, 줄바꿈. 문자열을 단어로 분리하는 기준
        String[] words = lyrics.split("\\s+"); // words = 가사(lyrics)를 단어로 분리한 것 모음
        System.out.println("단어의 갯수 : " + words.length);

        // 앞의 getOrDefault 메소드를 사용해서 단어가 나온 횟수 Map으로 저장하기
        // 횟수의 합계 = words.length (검증)
        Map<String, Integer> countMap = new HashMap<>();
        // 새로운 HashMap 생성후 HashMap의 변수를 countMap에 저장
        for (String word : words) { // words에 있는 단어를 word 변수에 대입
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            // countMap에 word라는 키가 있으면 그 값 반환, 없다면 기본값으로 0 반환
            // +1 = 해당 단어의 갯수를 1 증가
            // 없던 word값이라면 ()를 빠져나오자마자 +1이 되어서 기본값이 1이 되도록 저장
        }
        int sum = 0; // 단어의 총 출현 횟수 저장용
        int maxCount = 0; // maxCount 4회인 단어가 여러개
        // 최다 출현횟수 갯수 저장용
        StringBuilder sb = new StringBuilder(); // maxCount 단어를 추가
        // 최다 출현횟수 단어 문자 저장용

        for (String key : countMap.keySet()) { // countMap의 key값들을 key에 넣어줌
            int val = countMap.get(key); // 가져온 key의 value값을 val에 저장
            System.out.println(key + " (" + val + "회)"); // key(word에 있는 단어) + val(key의 value값(단어가 나온 횟수)) 으로 출력
            sum += val; // value(단어의 출현 횟수) 누적합계
            // val을 모두 더하여 sum에 저장(단어 총 출현 횟수가 됨)

            // 출현 횟수 최대값 찾기
            if (val > maxCount) // 현재의 val 와 최대횟수 maxCount 비교
                maxCount = val;
            // val이 maxCount를 넘으면 maxCount에 val값을 저장
        }
        // maxCount 에 해당하는 단어를 sb에 추가
        for (String key : countMap.keySet()) { // countMap의 key값들을 key에 넣어줌
            if (countMap.get(key) == maxCount) { // value 가 maxCount 와 같은지 비교
                // 만약 countMap에서 가져온 key의 value값과 maxCount가 일치하면 실행
                sb.append(key).append(", "); // 단어 추가
                // sb에 key값에 해당하는 value값 + , 을 추가
            }
        }

        System.out.println("출현 단어의 갯수 : " + countMap.size()); // 중복된 단어
        // 중복된 단어는 카운트되지 않기에 단어의 종류 갯수를 출력
        System.out.println("단어의 총 출현 횟수 : " + sum);
        // sum은 val(단어의 출현 횟수)의 누적이므로 중복도 카운트되어 모든 단어의 갯수 출력 (종류X)
        System.out.println("최다 출현 단어 : " + sb.toString() + "횟수 : " + maxCount);
        // sb.toString으로 sb에서 저장한 최다 출현 단어들의 문자열을 나열함
        // 마지막은 maxCount에 있는 단어들중 가장 출현 횟수가 많은 단어들의 출현 횟수 출력

    }
}