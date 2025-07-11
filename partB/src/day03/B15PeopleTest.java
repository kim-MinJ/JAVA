package day03;

//People 클래스 활용
public class B15PeopleTest {
    public static void main(String[] args) {
        People momo = new People();
        String name = momo.getName();
        int age = momo.getAge();
        boolean isAdult = momo.isAdult();
        System.out.println("회원 이름 : " + name); // 객체의 기본값 null
        System.out.println("회원 나이 : " + age); // 객체의 기본값 0
        System.out.println("회원 성인인증 : " + isAdult); // 객체의 기본값 false

        // momo 객체엑 name 필드를 "김모모" 하고 싶은데...
        momo.setName("김모모"); // setName 안에는 this.name = name 이 있음.
        System.out.println("momo 회원 이름 : " + momo.getName());

        People sana = new People();
        sana.setName("최사나"); // setName 안에는 this.name = name 이 있음. 인자 최사나 => 객체sana
        System.out.println("sana 회원 이름 : " + sana.getName());
        // 참고
        // int age; //오류 : 지역변수 기본값이 없습니다.
        // System.out.println(age);

        momo.setAge(22);
        System.out.println("momo 회원 나이 : " + momo.getAge());
        sana.setAge(18);
        System.out.println("sana 회원 나이 : " + sana.getAge());

        momo.setAdult(true);
        System.out.println("momo 성인 인증 : " + momo.isAdult());
        sana.setAdult(false);
        System.out.println("sana 성인 인증 : " + sana.isAdult());

    }
}
