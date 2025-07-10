package day02;

public class B07MyCalculator {
    public static void main(String[] args) {

        int data1;
        int data2;

        String temp = System.console().readLine("첫번째 값");
        data1 = Integer.valueOf(temp);
        String temp2 = System.console().readLine("두번째 값");
        data2 = Integer.valueOf(temp2);

        System.out.println("add : " + MyCalculator.add(data1, data2));
        System.out.println("sub : " + MyCalculator.sub(data1, data2));
        System.out.println("mul : " + MyCalculator.mul(data1, data2));
        System.out.println("div : " + MyCalculator.div(data1, data2));

        // 지금 연습한 MyCalculator 클래스와 유사한 기능의 자바 클래스 Math 가 있습니다.
        System.out.println(Math.addExact(data1, data2));
        System.out.println(Math.subtractExact(data1, data2));
        System.out.println(Math.multiplyExact(data1, data2));
        System.out.println("min : " + Math.min(data1, data2));
        System.out.println("max : " + Math.max(data1, data2));

    }
}

class MyCalculator {
    // 4개의 메소드는 int형으로 return해야함

    static int add(int data1, int data2) {
        return data1 + data2;
    }

    static int sub(int data1, int data2) {
        return data1 - data2;
    }

    static int mul(int data1, int data2) {
        return data1 * data2;
    }

    static int div(int data1, int data2) {
        if (data2 == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0; // data2가 0이면 임의의 다른값을 리턴
        }
        return data1 / data2; // data2가 0이면 오류(Exception. 예외) 발생
    }
}
