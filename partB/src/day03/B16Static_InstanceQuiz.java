package day03;

public class B16Static_InstanceQuiz {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // count++
        System.out.println("c1.getNum() : " + c1.getNum()); // 1
        Counter c2 = new Counter();
        System.out.println("c2.getNum() : " + c2.getNum()); // 1
        Counter c3 = new Counter();
        System.out.println("c3.getNum() : " + c3.getNum()); // 1
        Counter c4 = new Counter();
        System.out.println("c4.getNum() : " + c4.getNum()); // 1
        System.out.println(Counter.getCount()); // count : 4 // Counter : 클래스 , getCount : static
        // 참고 : System.out.println(c4.getCount());
        // 경고 메시지 : The static method getCount()
        // from the type Counter should be accessed in a static way
    }
}
/*
 * Counter.getCount() => 이 실행 코드로 알 수 있는 내용은?
 * getCount() 메소드는 1) static 이다.
 * 2) ()안에 값이 없다.(입력)이 없다. 인자X
 */

// 🔥이 코드는 Counter 객체가 몇 번 생성되었는지 알아내는 방법입니다.
// ----- static 이 저장되는 메모리 영역은 공유 영역입니다.
// ----- static 메소드는 static 변수 또는 메소드만 사용할 수 있습니다.
class Counter {
    private static int count = 0;
    private int num; // Counter 객체의 필드. 인스턴스(사본) 변수.

    public Counter() {
        // 생성자 메소드 - new 연산할 때 실행. 리턴이 없습니다. 반드시 클래스 이름과 똑같이

        count++;
        // count += 2; // 답 2+2+2+2 = 8
        num++;
    }

    // count 값을 리턴하는 getter 만들기 => 리턴 타입이 int

    public static int getCount() { // 2) 인자로 선언하는 변수 없음.
        // setNum(33); // 오류
        // System.out.println(num); //오류
        return count;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}

// 접근권한 접근방법 메소드(인자) {return에 값이 있으면 반드시 접근방법 알려줘야됨}