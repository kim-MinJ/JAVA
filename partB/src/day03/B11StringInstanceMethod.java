package day03;

// String 클래스의 인스턴트 메소드(객체값으로 실행)
//                                  ㄴ 생성된 객체를 대상으로 실행하며 객체의 값에 따라 결과가 다름
public class B11StringInstanceMethod {

    public static void main(String[] args) {
        String message = "hello";
        // String temp = new String("hello"); //message, temp, temp2 중 참조값이 다른 하나가 temp
        // => new가 붙었기에)
        // String temp2 = "hello";

        // message 문자열 객체의 인스턴스 메소드(자바스크립트, 파이썬 등 거의 유사)
        message = "hello~  java!!"; // 문자열을 구성하는 문자의 위치 0 부터 시작
        System.out.println(message); // message.toString() 실행. //hello~ java!!

        // 각 메소드가 어떤 형식의 데이터를 리턴하는가?
        // 🔥 인스턴스 메소드 실행으로 원래 문자열 객체의 상태가 변하지 않습니다.(메소드를 어떤걸 넣든 message가 바뀌지는 않음.)
        // ㄴ 리턴 타입이 String 경우, 새로운 문자열이 만들어집니다.
        System.out.println(message.length()); // 14 / int / 문자열의 길이
        System.out.println(message.charAt(4)); // o / char / 문자열의 해당 인덱스의 문자
        System.out.println(message.toUpperCase()); // HELLO~ JAVA!! / String / 대문자로 출력
        System.out.println(message.indexOf("java")); // 8 / int / 해당 문자열이 시작하는 인덱스 값
        System.out.println(message.indexOf("*")); // -1 / int / 없는 문자열은 -1
        System.out.println(message.startsWith("hello")); // true / boolean / 해당 문자열로 시작하는지 참, 거짓
        System.out.println(message.endsWith("java")); // false boolean / 해당 문자열로 끝나는지 참, 거짓
        System.out.println(message.replace(" ", "*")); // hello~**java!! / String / 타겟을 해당 문자열로 바꿈
        System.out.println(message.substring(1, 4)); // ell / String / 1~3인덱스를 출력함(endindex는 포함 X)
        System.out.println(message.substring(3)); // lo~ java!! / String / 해당 인덱스부터 끝까지 출력함
        System.out.println(message.lastIndexOf(" ")); // 7 / int / 해당 문자열이 마지막으로 나오는 인덱스를 출력함
        System.out.println(message.concat("??")); // hello~ java!!?? / String / 문자열 마지막에 입력한 문자열을 이어붙여서 출력함
        System.out.println(message.equals("hello~  java")); // false / boolean / 해당값이 같은 문자열인지 확인함 참, 거짓
        // 주의 : 자바는 문자열 같은지 비교할 때 == 안됩니다.(참조값을 비교함)
        // 꼭 equals 쓰세요.
        String test = "  ";
        System.out.println(test.isBlank()); // true / boolean / test.length() > 0, 공백만 있으면 true
        System.out.println(test.isEmpty()); // false / boolean / 문자열의 길이가 0일 때 true

        // 정규식 패턴을 검사 : 예시) 핸드폰 번호 010-숫자4자리-숫자4자리
        String regex = "^010-\\d{4}-\\d{4}$";
        String hpnum = "010-3456-9999"; // 011-345-6666

        System.out.println(hpnum.matches(regex)); // true
        System.out.println("011 - 345 - 6666".matches(regex)); // false
        // - 기호를 선택적. 없거나 한번 나오기는 ?
        // 문자열 기호 시작은 ^ 끝은$
        System.out.println("01033456666".matches("^010-?\\d{4}-?\\d{4}$")); // true

        String name = "김땡땡"; // 이름은 한글만 허용
        // 순서는 없고, 가능한 문자셋을 []기호 안에 나열, 범위는 a-z 또는 A-Z
        // + 기호는 반드시 한글자 이상.
        regex = "^[가-힣]{2,5}$"; // "^[가-힣]+$"; 는 이름이 1개문자일때도 허용
        System.out.println(name.matches(regex)); // true
        System.out.println("john".matches(regex)); // false
        // 영문자 검사
        System.out.println("john".matches("^[A-Z][a-zA-z\\s]+$")); // true
        // "^[A-Z][a-zA-z\\s]+$" 는 첫글자는 [A-Z]를 따라서 대문자만 가능하고 그 이후 문자를 소문자, 대문자 가능
        // "^[a-zA-z\\s]+$"는 \글자 자리 상관없이 소문자 대문자 가능

    }
}
