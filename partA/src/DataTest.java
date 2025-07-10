public class DataTest {
// public 클래스이름=파일이름

public static void main(String[] args) {
    //System 클래스의 out 속성(객체타입)이 println() 메소드 제공
    // -> 콘솔(터미널) 출력
    System.out.println("2025년 7월 9일 수요일 자바 첫번째 코드 -------------");   //sout 치면 기본형 나옴
    //(1) 변수 활용 - 변수 선언은 데이터 형식과 변수명이 필요합니다.
    int myage = 22;  //myage 변수이름에 int 정수 데이터 저장
    double weight = 49.456;  //weight      double 실수
    boolean isAdult=true;  //isAdult          boolean 불린(참, 거짓)    
    char gender = 'F';        //gender           char 문자(반드시1개) - 기호                 ''
    String name="twice";   //name             String 클래스 문자열- (첫번째 대문자)""

    System.out.println("myage:" +myage); //+ 는 문자열에서 연결 연산
    System.out.println("weight:"+ weight);
    System.out.println("isAdult:"+ isAdult);
    System.out.println("isAdult:"+ (isAdult? "성인":"청소년"));
    System.out.println("gender:"+ gender);
    System.out.println("name:"+ name);

    //(2) 변수의 초기값 변경
    name="트와이스🔥";
    weight = 45; //double 로 만들어진 변수입니다. 값은 정수데이터 저장 가능
    //myage = 25.5;  //int (오류)                               실수 데이터 저장 못합니다.

    //why? 메모리 저장 공간 int 4바이트, double 8바이트


    //byte, short, int, long, float, char, boolean 는
    //기본(원형primitive) 타입으로 데이터를 stack 에 저장합니다.

    //자바에서는 Byte, Short, Integer, Long, Float, Double, Character, Boolean (첫글자 대문자면 Class로 바뀜)
    //기본 데이터 타입을 객체로 다룰 수 있는 'wrapper 클래스'가 있습니다.

    
}
}