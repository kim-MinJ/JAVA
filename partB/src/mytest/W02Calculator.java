package mytest;

public class W02Calculator {
    public static void main(String[] args) {

        int data1;
        int data2;

        String op; // +, -, *, / 값만 사용합니다.

        boolean status = true;
        while (status) {
            String temp = System.console().readLine("첫번째 값");
            data1 = Integer.valueOf(temp);
            String temp2 = System.console().readLine("두번째 값");
            data2 = Integer.valueOf(temp2);
            op = System.console().readLine("연산 선택하기 (+, -, *, /) | 종료는 N 또는 n 입력 >>>");
            switch (op) {
                case "+":
                    String tempadd = System.console().readLine("더하기 선택 하셨습니다.");
                    op = String.valueOf(tempadd);
                    break;
                case "-":
                    String tempsub = System.console().readLine("빼기 선택 하셨습니다.");
                    op = String.valueOf(tempsub);
                    break;
                case "*":
                    String tempmul = System.console().readLine("곱하기 선택 하셨습니다.");
                    op = String.valueOf(tempmul);
                    break;
                case "/":
                    String tempdiv = System.console().readLine("나누기 선택 하셨습니다.");
                    op = String.valueOf(tempdiv);
                    break;
                case "N", "n": // while 종료 조건
                    status = false;
                    break;
                default:
                    System.out.println("잘못된 선택 입니다. +, -, *, / 값만 사용합니다.");
                    break;
            }

            System.out.println(
                    "결과값 : " + MyCalculator.qus1(data1) + String.valueOf(op) + MyCalculator.qus2(data2));

            status = false;

        }

    }
}

class MyCalculator {

    static int qus1(int data1) {
        return data1;
    }

    static int qus2(int data2) {
        return data2;
    }

    static String opString(String op) {
        return op;
    }

    static int div(int data1, int data2) {
        if (data2 == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }
        return data1 / data2; // data2가 0이면 오류(Exception. 예외) 발생
    }
}