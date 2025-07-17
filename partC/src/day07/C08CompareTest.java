package day07;

public class C08CompareTest {
    public static void main(String[] args) {
        // 래퍼 Wrapper 클래스 : Integer, Double, ....
        // compareTo 메소드가 있습니다. => implements Comparable

        Integer n1 = 23; // int 가 Integer 타입으로 자동 캐스팅 저장
        Integer n2 = 34;
        // 비교
        System.out.println(n1 < n2);
        int diff = n1 - n2; // diff > 0 일때 n1>n2, diff < 0 일때는 n1<n2

        // Comparable 인터페이스의 추상 메소드 : compareTo
        // Integer, Double ,, 래퍼 클래스는 compareTo 메소드는 -1, 0, 1 만 리턴 값이 -면 -1, 값이 같으면 0 값이
        // +면 1
        diff = n1.compareTo(n2);
        System.out.println("n1.compareTo(n2) : " + diff); // -1 n1-n2 < 0
        diff = n2.compareTo(n1);
        System.out.println("n2.compareTo(n1) : " + diff); // 1 n2-n1 > 0

        // String 타입의 compareTo는 문자의 차이
        String name1 = "a";
        String name2 = "d";
        // diff = name1 - name2;
        // System.out.println(name1 < name2);
        diff = name1.compareTo(name2);
        System.out.println("name1.compareTo(name2) : " + diff);

    }
}
