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
         * 답 : 5(인터페이스와 햇갈림) 정답 : 4
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
         * Flyable bird = new Flyable(){
         * };
         * bird.fly();
         * }
         * }
         * 답 : 2
         */

        /*
         * 4.
         * 다음 중 올바른 코드는?
         * ①
         * 
         * abstract class A {
         * abstract A() { }
         * }
         * ②
         * 
         * interface B {
         * private int x = 10;
         * }
         * ③
         * 
         * abstract class C {
         * abstract void method();
         * void normalMethod() { }
         * }
         * ④
         * 
         * interface D {
         * void method() {}
         * }
         * ⑤
         * 
         * class E extends A, B { }
         * 
         * 답 : 4
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
         * 답 : 1
         */

        /*
         * 6.
         * 다음 클래스 정의의 오류를 해결하기 위한 방법은?
         * class Vehicle {
         * protected String brand;
         * 
         * public Vehicle(String brand) {
         * this.brand = brand;
         * }
         * 
         * void start(int timeout);
         * 
         * void stop();
         * }
         * 답 :
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
         * 답 : default
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
         * 답 : void read(); , Writable
         */

        /*
         * 9.
         * Comparable 인터페이스에 대한 설명으로 올바른 것은?
         * ① compareTo() 메서드는 boolean 타입을 반환한다
         * ② 음수를 반환하면 현재 객체가 매개변수보다 크다는 의미이다
         * ③ 0을 반환하면 두 객체가 같다는 의미이다
         * ④ Comparable을 구현하면 자동으로 equals() 메서드도 재정의된다
         * ⑤ compareTo() 메서드는 static 메서드이다
         * 답 : 3
         */

        /*
         * 10.
         * Cloneable 인터페이스에 대한 설명으로 틀린 것은?
         * class Person implements Cloneable {
         * String name;
         * int age;
         * 
         * public Object clone() throws CloneNotSupportedException {
         * return super.clone();
         * }
         * }
         * ① Cloneable은 마커 인터페이스이다
         * ② clone() 메서드는 Object 클래스에 정의되어 있다
         * ③ Cloneable을 구현하지 않으면 CloneNotSupportedException이 발생한다
         * ④ clone() 메서드는 깊은 복사를 자동으로 수행한다
         * ⑤ clone() 메서드는 protected로 선언되어 있으며 public 으로 접근 방식을 변경할 수 있다.
         * 
         * 답 : 5
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
         * 답 : double => Double
         */

        /*
         * 12.
         * 위의 Product 를 예시로 객체 복사의 '깊은 복사'와 '얕은 복사' 의 차이점은?
         * 답 :
         */

        /*
         * 13.
         * 다음 빈칸을 O, X 로 표기하세요.
         * 답 : X / O / O 정답 : O / X / O
         */

        /*
         * 14.
         * 상속 시 접근 권한 변경 규칙에 대한 설명입니다. O, X 를 표시하세요.
         * 하위 클래스에서 부모 클래스의 접근 제어자를 변경할 수 있다. ( O )
         * 더 좁은 범위로는 접근 권한을 줄일 수 있다. ( X )
         * protected 접근 권한을 public 으로 변경할 수 있다. ( X )
         * 답 :
         */
    }
}
