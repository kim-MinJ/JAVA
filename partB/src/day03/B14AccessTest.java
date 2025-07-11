package day03;

/*
 * 접근권한 방식
 * 
 * - 클래스 : public, default(기본)
 * - 메소드 : public, default, private
 * - 전역변수 : public, default, private
 * 
 * public : 모든 클래스에서 사용 가능함.
 * default : 같은 패키지에서 사용 가능함.
 * private : 현재 클래스에서 사용 가능함.
 * 
 * - 접근 권한 protected 는 상속 (이후 진도에서)
 */
public class B14AccessTest {

    public static void main(String[] args) { // main은 public이여야함
        Score2 momo = new Score2();
        momo.name = "김모모";
        momo.kor = 99;
        momo.eng = 99;
        momo.math = 98;
        // System.out.println(momo.isKorValid()); // 오류 : private 접근자 메소드
    }
}
/*
 * //아래와 같이 test 패키지에서 public, default 차이를 확인함.
 * package test;
 * 
 * import day03.B14AccessTest;
 * 
 * public class Score2Test {
 * public static void main(String[] args) {
 * // Score2 momo = new Score2(); // 오류 : default 접근 클래스 다른 클래스에서는 사용불가능 / 같은
 * // package 내에서만 사용 가능
 * B14AccessTest test = new B14AccessTest(); // public 접근 클래스 다른 클래스에서도 사용가능
 * // 단, import 로 패키지 위치를 알려주고 사용
 * }
 * }
 */

class Score2 { // 같은 패키지에선 Score사용가능
    String name;
    int kor;
    int eng;
    int math;
    int grade;

    int sum() {
        return kor + eng + math;
    }

    double avg() {
        return (double) sum() / 3;
    }

    char getGrade() {

        int avg = sum() / 3;
        char grade;
        switch (avg / 10) {
            case 10, 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6, 5, 4, 3, 2, 1, 0:
                grade = 'F';
                break;
            default:
                grade = 'E';
                break;
        }
        return grade;
    }

    boolean isNameValid() {
        return name.matches("^[가-힣]{2,5}$");
    }

    boolean isScoresValid() {
        return isKorValid() && isEngValid() && isMathValid();
    }

    private boolean isKorValid() {
        return kor >= 0 && kor <= 100;
    }

    private boolean isEngValid() {
        return eng >= 0 && eng <= 100;
    }

    private boolean isMathValid() {
        return math >= 0 && math <= 100;
    }

    @Override
    public String toString() {
        return String.format("%s : %d, %d, %d", name, kor, eng, math);
    }
}
