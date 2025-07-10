package day02;

public class B10SwitchCase {

    public static void main(String[] args) {

        String op; // +, -, *, / 값만 사용합니다.

        boolean status = true;
        while (status) {
            op = System.console().readLine("연산 선택하기 (+, -, *, /) | 종료는 N 또는 n 입력 >>>");
            switch (op) {
                case "+":
                    System.out.println("더하기 선택 하셨습니다.");
                    break;
                case "-":
                    System.out.println("빼기 선택 하셨습니다.");
                    break;
                case "*":
                    System.out.println("꼽하기 선택 하셨습니다.");
                    break;
                case "/":
                    System.out.println("나누기 선택 하셨습니다.");
                    break;
                case "N", "n": // while 종료 조건
                    status = false;
                    break;
                default:
                    System.out.println("잘못된 선택 입니다. +, -, *, / 값만 사용합니다.");
                    break;
            }
        }
    }
}
