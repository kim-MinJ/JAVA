package MyTest;

public class W02Test {
    public static void main(String[] args) {

        /*
         * 1.
         * 다음 중 추상 클래스에 대한 설명으로 올바른 것은?
         * ① 추상 클래스는 생성자를 가질 수 없다 <= 가질 수 있음(직접 생성X, 자식 클래스가 super()로 호출시 사용)
         * ② 추상 클래스는 일반 메서드를 가질 수 없다 <= 둘 다 가질 수 있음
         * ③ 추상 클래스는 인스턴스를 직접 생성할 수 있다 <= 생성 불가능
         * ④ 추상 클래스는 추상 메서드와 일반 메서드를 모두 가질 수 있다 <= 추상은 자식이 반드시 오버라이딩, 일반은 공통 로직 제공
         * ⑤ 추상 클래스는 다중 상속이 가능하다 <= 다중상속불가 / 인터페이스는 가능
         * 답 : 4
         */

        /*
         * 2.
         * 인터페이스에 대한 설명으로 틀린 것은?
         * ① 인터페이스의 변수는 자동으로 public static final이다 <=
         * ② 자바 8 버전 이후에는 default 메서드와 static 메소드를 가질 수 있다
         * ③ 인터페이스는 생성자를 가질 수 있다
         * ④ 인터페이스는 다중 구현이 가능하다
         * ⑤ 인터페이스의 메서드는 기본적으로 public abstract이다
         * 답 : 5 정답 : 3
         */

        /*
         * interface Flyable {
         * //@Override 생략됨
         * default void fly() {
         * System.out.println("Flying high");
         * }
         * }
         * 
         * class Bird implements Flyable {
         * public void fly() {
         * System.out.println("Bird is flying");
         * }
         * }
         * 
         * public class Test {
         * public static void main(String[] args) {
         * // 익명 클래스로 인터페이스 구현. 익명클래스로 객체 생성
         * Flyable bird = new Flyable(){
         * };
         * bird.fly();
         * }
         * }
         * 답 : 2 정답 : 1
         */

        /*
         * 4.
         * 다음 중 올바른 코드는?
         * ①
         * 
         * abstract class A {
         * abstract(❌) A() { }
         * }
         * 생성자는 abstract 사용 불가능
         * ②
         * 
         * interface B {
         * private(❌) int x = 10;
         * }
         * 기본 권한 public이기에 private가 못들어옴
         * ③
         * 
         * abstract class C {
         * abstract void method();
         * void normalMethod() { }
         * }
         * ④
         * 
         * interface D {
         * void method() {} (❌)
         * 메소드 정의가 있을 수 없음(추상 메소드만 가능)
         * }
         * ⑤
         * 
         * class E extends A, B { }
         * 클래스는 다중 상속 불가능
         * 
         * 답 : 4 정답 : 3
         */

        /*
         * 5.
         * 다음 코드에서 컴파일 에러가 발생하는 이유는?
         * abstract class Shape {
         * abstract double getArea();
         * }
         * 
         * class Circle extends Shape {
         * double radius;
         * public Circle(double radius) {
         * this.radius = radius;
         * }
         * }
         * 답 : 4
         */

        /*
         * 6.
         * 다음 클래스 정의의 오류를 해결하기 위한 방법은?
         * (abstract) class Vehicle {
         * protected String brand;
         * 
         * public Vehicle(String brand) {
         * this.brand = brand;
         * }
         * 
         * (abstract)void start(int timeout);
         * 
         * (abstract)void stop();
         * }
         * 답 : 정답 : class 키워드 앞에, 그리고 2개의 추상메소드 선언 void 앞에 abstract 키워드 작성하기
         */

        /*
         * 7.
         * 다음 인터페이스 구현 코드의 빈칸을 채우시오.
         * interface Drawable {
         * int MAX_SIZE = 100;
         * void draw();
         * _default_ void print() {
         * System.out.println("Drawing...");
         * }
         * }
         * 답 : default - 반드시 재정의 하지 않아도 되는 메소드 (일반적인 접근권한 default 와는 다른 의미)
         */

        /*
         * 8.
         * 다음 다중 인터페이스 구현 코드의 빈칸을 채우시오.
         * interface Readable {
         * _void read();_
         * }
         * 
         * interface Writable {
         * void write();
         * }
         * 
         * class File implements Readable, _Writable_ {
         * public void read() {
         * System.out.println("Reading file");
         * }
         * 
         * public void write() {
         * System.out.println("Writing file");
         * }
         * }
         * 답 : void read(); , Writable 정답 : void read(); , Writable
         */

        /*
         * 9.
         * Comparable 인터페이스에 대한 설명으로 올바른 것은?
         * ① compareTo() 메서드는 boolean(❌) 타입을 반환한다 (int 타입 반환)
         * ② 음수를 반환하면 현재 객체가 매개변수보다 크다(❌)는 의미이다 (음수는 작다는 의미)
         * ③ 0을 반환하면 두 객체가 같다는 의미이다
         * ④ Comparable을 구현하면 자동으로 equals() 메서드도 재정의된다(comparable과 equals()는 별개)
         * ⑤ compareTo() 메서드는 static 메서드이다(static X 인스턴스 메소드)
         * 답 : 3 정답 : 3 ✅참고 : 래퍼클래스에 두 값 비교를 하는 static 메소드가 있습니다. -> compare
         */

        /*
         * 10.
         * Cloneable 인터페이스에 대한 설명으로 틀린 것은?
         * class Person implements Cloneable {
         * String name;
         * int age;
         * 
         * //Object 의 clone() 은 protected 이며 자식인 Person 이 접근 권한 변경함.
         * public Object clone() throws CloneNotSupportedException {
         * return super.clone();
         * }
         * }
         * 
         * //비교
         * 
         * @Override // Cloneable 인터페이스 재정의 - Member 객체의 어떤 속성값 비교할 것인지..
         * protected Member clone() throws CloneNotSupportedException { // 예외 처리 위임
         * return (Member) super.clone();
         * 
         * ✅ 참고 : 마커 인터페이스란 인터페이스 내부에 상수도, 메소드도 없는 특정 기능 허용, 의미를 부여하는 인터페이스
         * ① Cloneable은 마커 인터페이스이다 (단순히 clone을 허용함을 표시하는 역할)
         * ② clone() 메서드는 Object 클래스에 정의되어 있다
         * ③ Cloneable을 구현하지 않으면 CloneNotSupportedException이 발생한다
         * // 구현 X => 명시
         * ④ clone() 메서드는 깊은 복사❌를 자동으로 수행한다 (clone()은 얕은 복사만 수행)
         * ⑤ clone() 메서드는 protected로 선언되어 있으며 public 으로 접근 방식을 변경할 수 있다. (오버라이드해서 접근제한자
         * public으로 확장)
         * 
         * 답 : 5 정답 : 4
         */

        /*
         * 11.
         * Comparable 인터페이스 구현 코드의 오류를 수정하세요.
         * class Product implements Comparable<Product> {
         * private String name;
         * private Double price;
         * 
         * public int compareTo(Product other) {
         * return this.price - other.price;
         * }
         * }
         * 답 : double => Double 정답 :
         */

        /*
         * 12.
         * 위의 Product 를 예시로 객체 복사의 '깊은 복사'와 '얕은 복사' 의 차이점은?
         * 답 : 정답 : deep copy 는 참조값 속성 일 때, 참조값을 복사하지 않고 객체 자체를 새로 만듦
         * shallow copy 는 참조값 속성 일 때, 참조값(주소)를 복사합니다. -> 일반적인 clone() 의 동작
         */

        /*
         * 13.
         * 다음 빈칸을 O, X 로 표기하세요.
         * 자식(하위)클래스를 이야기한건 다른 패키지의 자식(하위)클래스를 이야기
         * 답 : O / X / O 정답 : O / X / O
         */

        /*
         * 14.
         * 상속 시 접근 권한 변경 규칙에 대한 설명입니다. O, X 를 표시하세요.
         * 하위 클래스에서 부모 클래스의 접근 제어자를 변경할 수 있다. ( O )
         * 더 좁은 범위로는 접근 권한을 줄일 수 있다. ( X )
         * protected 접근 권한을 public 으로 변경할 수 있다. ( X )
         * 답 : O, X, X 정답 : O, X, O
         */
    }
}
