package mytest;

public class W02Test {
public static void main(String[] args) {
    
    /*
     * 1. static 키워드에 대한 설명으로 올바른 것은?
a) static 변수는 객체마다 각각 다른 값을 가진다 
b) static 메소드는 인스턴스 변수에 직접 접근할 수 있다 
c) static 변수는 클래스가 메모리에 로드될 때 생성된다 
d) static 메소드는 this 키워드를 사용할 수 있다

답 : c     static은 객체랑 연관없음. 인스턴스 변수랑 못엮음. 클래스랑 연관됨. this도 객체에 닿아야됨.
     */

     /*
      * 2. 다음 코드의 출력 결과는?
public class Test {
    static int count = 0;
    
    public Test() {
        count++;
    }
    
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(Test.count);
    }
}
a) 0 b) 1 c) 2 d) 컴파일 오류

답 : c
      */

      /*
       * 3. 기본 생성자에 대한 설명으로 틀린 것은?
a) 매개변수가 없는 생성자이다 
b) 명시적으로 생성자를 만들지 않으면 자동으로 제공된다 
c) 리턴 값은 기본값이 null 이다. 
d) 객체가 생성될 때만 실행된다.

답 : c 기본 생성자는 기본값 X
       */


       /*
        * 4. 다음 클래스에서 컴파일 오류가 발생하는 것은?
public class Test {
    static int staticVar = 10;
    int instanceVar = 20;
    
    // 다음 중 오류가 발생하는 것은?
}
a) public static void method1() { System.out.println("static"); }
b) public void method2() { System.out.println(staticVar); }
c) public static void method3() { System.out.println(instanceVar); }
d) public static void method4() { method1(); }

답 : c
        */

        /*
         * 5. 다음 코드에서 빈칸을 채우시오.
public class Counter {
    private int count = 0;
    private _static_ int totalCount = 0;  // 모든 카운터가 공유하는 변수
    
    public void increment() {
        count++;
        _totalCount_++;  // 공유 변수 증가
    }
    
    public _static_ int getTotalCount() {  // 객체 생성 없이 호출 가능한 메소드
        return totalCount;
    }
}
         */

         /*
          * 6. 다음 코드에서 빈칸을 채우시오.
public class Calculator {
    private int result;
    
    public __int_() {  // 기본 생성자
        result = 0;
    }
    
    public _void__ add(int num) {  // 반환형이 없는 인스턴스 메소드
        result += num;
    }
    
    public _int_ getResult() {  // 결과를 반환하는 인스턴스 메소드
        return result;
    }
}
          */

          /*
           * 7. 다음 코드에서 빈칸을 채우시오.
public class MathUtils {
    public _static_ final double PI = 3.14159;  // 클래스 상수
    
    public _static_ double calculateArea(double radius) {  // 인스턴스 생성 없이 호출
        return _radius_ * radius * radius;  // 위에서 선언한 상수 사용
    }
}
           */

           /*
            * 8. 다음 코드에서 빈칸을 채우시오.
public class Car {
    private String brand;
    private int speed;
    private _static_ int maxSpeed = 200;  // 모든 자동차가 공유하는 최고 속도
    
    // 기본 생성자
    public _Car_() {
        brand = "Unknown";
        speed = 0;
    }
    
    public _static_ void printMaxSpeed() {  // 객체 생성 없이 호출 가능
        System.out.println("Max speed: " + maxSpeed);
    }
}
            */

            /*
             * 9. 다음 코드에서 기본 생성자의 역할을 설명하고, 출력 결과를 예측하시오.
public class Student {
    private String name;
    private int grade;
    
    // 기본 생성자
    public Student() {
        name = "Anonymous";
        grade = 1;
    }
    
    public void printInfo() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
    
    public static void main(String[] args) {
        Student s = new Student();
        s.printInfo();

        답 : 기본생성자Student는 name을 Anonymous로 grade를 1로 지정해주고 있으며,
        출력 결과 : 새로운 new Student를 지정해주었으므로 값이 나오지 않는다.
    }
}
             */

             /*
              * 10. 다음 코드의 실행 결과를 예측하고, 그 이유를 설명하시오.
public class Counter {
    private int instanceCount = 0;
    private static int staticCount = 0;
    
    public Counter() {
        instanceCount++;
        staticCount++;
    }
    
    public void printCounts() {
        System.out.println("Instance: " + instanceCount + ", Static: " + staticCount);
    }
    
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.printCounts();
        c2.printCounts();
    }
} 답 : 

              */
}
}
