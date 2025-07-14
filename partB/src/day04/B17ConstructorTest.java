package day04;

public class B17ConstructorTest {
    public static void main(String[] args) {
        // 기본 생성자 실행
        People sana = new People(); // null, 0, false 가 기본값
        // 기본값에서는 setter로 값을 저장해줄 필요가 있음.

        // 커스텀 생성자 실행
        People momo = new People("김모모", 24, true);
        // 생성자의 3개 인자값이 생성자로 전달되어 인스턴스 변수의 초기값으로 설정됩니다.
        // setter 실행하지 않고 객체 만들 때 값 초기화

        System.out.println("기본 생성자로 만든 sana : " + sana);
        System.out.println("커스텀 생성자로 만든 momo : " + momo);

        // 다른 형식의 커스텀 생성자
        People nana = new People(25);
        System.out.println("커스텀 생성자로 만든 nana : " + nana);

        Score nina = new Score("니나", 80, 90, 70);
        System.out.println("니나 점수 : " + nina);
    }
}
