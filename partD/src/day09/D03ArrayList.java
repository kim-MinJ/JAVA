package day09;

import java.util.ArrayList;
import java.util.List;

// ArrayList : List 인터페이스를 구현한 클래스
public class D03ArrayList {
    public static void main(String[] args) {
        // ArrayList 만들기
        List<String> list = new ArrayList<>(); // 왼쪽은 인터페이스 이름, 오른쪽은 구현한 클래스 이름
        // 데이터 저장하기
        list.add("apple"); // 인덱스 0
        list.add("mango");
        list.add("melon");
        list.add("strawberry");
        list.add("kiwi"); // 인덱스 4
        System.out.println(list);
        // 리스트의 크기(가변적)
        int size = list.size();
        System.out.println("리스트의 크기 : " + size);

        // 리스트 항목 삭제 : 리스트 크기 변경
        String result = list.remove(1);
        System.out.println("remove 리턴 : " + result);
        System.out.println("삭제 후 list : " + list);
        System.out.println("삭제 후 list 크기 : " + list.size());

        // 리스트 인덱스를 [] 기호로 지정하지 않고 get(인덱스) 메소드
        System.out.println("리스트의 데이터 1개씩 가져오기");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i));
        }

        // 리스트의 특정 위치 값 변경 : set(인덱스, 값)
        list.set(list.size() - 1, "grape");
        for (String s : list) { // list.get(i) 역할
            System.out.println("\t" + s);
        }

        // 특정 요소 찾기
        list.add("melon"); // 같은 문자열 하나 추가
        list.add("mango");
        System.out.println(list);
        System.out.println("melon 의 위치 찾기");
        System.out.println("\tlist.indexOf : " + list.indexOf("melon")); // 1
        System.out.println("\tlist.lastIndexOf : " + list.lastIndexOf("melon")); // 4
        // 없는 요소 찾으면 -1 리턴

        System.out.println("특정 데이터의 저장 여부 : contains");
        System.out.println("\t mango 있음? " + list.contains("mango"));
        System.out.println("\t bluebarry 있음? " + list.contains("blueberry"));

        // 정렬
        list.sort(null);
        System.out.println("정렬 후 : " + list);

    }
}
