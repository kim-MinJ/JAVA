package day09;

// shift 연산은 비트를 왼쪽 또는 오른쪽으로 이동합니다.
// 1. 맨 왼쪽의 부호를 고려하는 연산(부호 비트는 변경안함)
// 2. 부호를 고려하지 않는 연산
public class D02ShiftTest {
    public static void main(String[] args) {
        int a = 25;
        System.out.println(to32BitBinary(a) + " " + a);
        int result = a >> 1; // 오른쪽으로 1비트 이동
        System.out.println("1. right shift - 정수의 나누기 2와 같은 동작");
        System.out.println(to32BitBinary(result) + " " + result);
        result = a >> 2;
        System.out.println(to32BitBinary(result) + " " + result);
        result = a >> 3;
        System.out.println(to32BitBinary(result) + " " + result);
        System.out.println("1. left shift - 정수의 곱하기 2와 같은 동작");
        result = a << 1; // 왼쪽으로 1비트 이동
        System.out.println(to32BitBinary(result) + " " + result);
        result = a << 2;
        System.out.println(to32BitBinary(result) + " " + result);
        result = a << 3;
        System.out.println(to32BitBinary(result) + " " + result);

        int b = -25;
        System.out.println(to32BitBinary(b) + " " + b);
        result = b >> 1;
        System.out.println("음수의 오른쪽 shift 1회");
        // 질문 : 오른쪽 shift 연산에서 왼쪽에 새로 들어오는 bit는? 부호 비트와 같음
        System.out.println(to32BitBinary(b >> 1) + result);
        result = b << 1;
        System.out.println("음수의 왼쪽 shift 1회");
        System.out.println(to32BitBinary(b << 1) + result);

        // 오른쪽 shift 연산에서 부호를 고려하지 않는 연산 >>> 은 새로 들어오는 비트를 무조건 0
    }

    private static String to32BitBinary(int x) {
        return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
    }
}
