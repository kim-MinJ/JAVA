public class PeopleTest {
public static void main(String[] arg) {
    //People 클래스를 이용하여 객체를 만듭니다.
    //-> 객체를 만드는 연산은 new 입니다.
    //변수는 참조형 타입으로 객체의 주소를 저장합니다.
    People sana = new People();  //new 클래스타입 변수명 = new 클래스이름()
    People momo = new People();

    System.out.println("sana People 객체 정보(속성 기본값 확인)---------  ");
    System.out.println("name : " +sana.name);             //null
    System.out.println("age : " +sana.age);                   //0
    System.out.println("isAdult : " +sana.isAdult);         //false
    System.out.println("gender : " +sana.gender);        //' '

    //momo 객체에 속성값을 저장하기
    //객체(object)는 데이터의 대상이 여러 값(또는 기능/메소드)로 표현될때 사용.
    momo.name = "김모모";
    momo.age=23;
    momo.isAdult=true;
    momo.gender='F';

        System.out.println("momo People 객체 정보(속성 저장값 확인)---------  ");
        System.out.println("name :" +momo.name);
        System.out.println("age :" +momo.age);
        System.out.println("isAdult :" +momo.isAdult);
        System.out.println("gender :" +momo.gender);
        //System.out.println("weight :" +momo.weight);  //오류 : People 클래스에 없는 속성

    //참고 : 문자열 객체 생성
    String test = new String();
    String test2 = "트와이스";

}
}
