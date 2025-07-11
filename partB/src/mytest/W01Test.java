package mytest;

public class W01Test {

    // 1. 답 : String 앞에 대문자인건 class

    // 2. 답 : true, false str3 는 new String 을 통하여 새로운 객체를 제시하였다.

    // 3. 답 : false, true p1과 p2는 서로 다른 객체이지만 p3는 p1을 지정해주었기에 같은 참조값이 된다.

    // 4.
    public static void main(String[] args) {
        Student momo = new Student();
        momo.name = "홍길동";
        momo.age = 20;
        System.out.println(momo);
        // 5. 2 (1은 static은 객체랑 상관없음 3)

        // 6.
        

        // 7. -128 overflow되면 b가 가진 byte의 최댓값을 넘어 최솟값으로 돌아가기에 127에서 -128이 된다.

        // 8. int x = 10; 이라는건 {} 안에서만 적용되는 숫자로 {}을 벗어나게되면 값을 가지지 않기에 x는 존재하지 않는 것이 되어서
        // 찾지못하여 컴파일 오류가 뜨게된다.

        // 9. B12 참조
    }
}

class Student {
    String name;
    int age;

    @Override
    public String toString() {
        return ("이름 : " + name + ", " + "나이 : " + age);
    }
    // toString() 메소드를 여기에 작성
}

class MyCalculator {
    // 2의 n승 계산하기(n=0일 때 결과는 1)
    static int powerOfTwo(int count) {  
     
    }
}