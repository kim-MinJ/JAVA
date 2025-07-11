package test;

import day03.B14AccessTest;

public class Score2Test {
    public static void main(String[] args) {
        // Score2 momo = new Score2(); // 오류 : default 접근 클래스 다른 클래스에서는 사용불가능 / 같은
        // package 내에서만 사용 가능
        B14AccessTest test = new B14AccessTest(); // public 접근 클래스 다른 클래스에서도 사용가능
        // 단, import 로 패키지 위치를 알려주고 사용
    }
}
