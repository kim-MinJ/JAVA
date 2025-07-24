package day12;

public class D14CharEncodingTest {
  public static void main(String[] args) {
    char ga = '가'; // 한글 첫음절
    char hit = '힣'; // 마지막 음절

    // 각각의 코드값을 출력. 출력된 값을 이용해서 '가'~'힣' 사이에 몇개의 문자가 있는지

    int code_ga = ga; // char 는 int 로 자동 캐스팅
    int code_hit = hit;
    System.out.println("'가' UTF-8 : " + code_ga);
    System.out.println("'힣' UTF-8 : " + code_hit);
    System.out.println("한글 음절의 갯수 : " + (code_hit - code_ga + 1));

    System.out.println(String.format("가 = %d , %x", code_ga, code_ga)); // ac00
    System.out.println(String.format("힣 = %d , %x", code_hit, code_hit)); // d7a3

    // 정수 코드값 50000 은 무슨 글자일까요?
    System.out.println(String.format("%c", 50000)); // 자동 캐스팅
    int some = 50000;
    // char imoji = ' 🔥 '; // 오류 : 이모지는 3바이트 이상. 문자열로만 저장.
    char some_code = (char) some; // 강제 캐스팅
    System.out.println(some_code);
  }

}
