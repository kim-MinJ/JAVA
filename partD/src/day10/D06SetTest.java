package day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// Set : 집합. 1) 동일한 값의 데이터는 중복없이 저장
//          2) HashSet, LinkedHashSet, TreeSet 구현 클래스
//          3) 인덱스가 없습니다. (데이터의 순서가 없습니다.)
//          4) 활용예시 - 인터넷서비스의 접속자 ip, 아이디 수집 중......
//                                  중복값 제거 또는 중복값 확인에 활용 됩니다.
public class D06SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 1. 데이터 추가
        set.add("sana");
        set.add("momo");
        set.add("nana");
        set.add("sana");

        // 2. set 의 크기
        System.out.println("set 크기 : " + set.size());
        // set 크기 : 3 * sana 중복으로 4가 아니라 3

        // 3. toString 출력
        set.add("dahyeon");
        System.out.println("set : " + set); // 순서 없음 : 출력 순서는 랜덤

        // set : [dahyeon, sana, nana, momo]

        // 오류 : 인덱스로 접근하는 get 메소드 없습니다.
        // for(int i=0; int<set.size();i++)
        // set.get(i);

        // 4.
        System.out.println("반복문 출력은 인덱스 없는 형식만 가능");
        for (String s : set) {
            System.out.println(s);
        }
        // dahyeon \t sana \t nana \t momo 출력시 순서 X

        // HashSet 은 해시테이블에서 데이터를 저장/관리
        // LinkedHashSet 은 '다음 입력값의 주소' 포인터를 저장. ✅데이터 입력 순서 유지
        Set<String> linkSet = new LinkedHashSet<>();
        // 6. LinkedHashSet 데이터 추가
        System.out.println("LinkedHashSet 데이터");
        linkSet.add("sana");
        linkSet.add("momo");
        linkSet.add("nana");
        linkSet.add("sana");
        linkSet.add("dahyeon");

        System.out.println(linkSet);
        // LinkedHashSet = [sana, momo, nana, dahyeon]

        // 7. 데이터 제거 : 값으로 제거
        boolean result = linkSet.remove("momo"); // set 값 제거
        System.out.println("linkSet.remove(\"momo\") : " + result); // remove는 boolean이기에 ture / false로 나뉨
        // set 내부에 있는 데이터이기에 제거해서 true
        result = linkSet.remove("nano");
        System.out.println("linkSet.remove(\"nano\") : " + result);
        // set 내부에 없는 데이터이기에 제거못하여 false
        System.out.println("확인 출력 : " + linkSet);
        // momo가 삭제되어 [sana, nana, dahyeon]

        // 8. TreeSet : 이진 트리 탐색이 가능한 자료구조(정렬)
        Set<String> treeset = new TreeSet<>(set); // treeset을 String을 기준으로 함
        System.out.println("Treeset -------");
        System.out.println(treeset);
        //출력값 : [dahyeon, momo, nana, sana]

    }

}
