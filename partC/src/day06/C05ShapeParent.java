package day06;

public class C05ShapeParent {
    public static void main(String[] args) {
        ShapeParent s1 = new Rectangle(10, 10, 220, 190, "yellow");
        ShapeParent s2 = new Circle(10, 20, 0, 0, "blue");
        ShapeParent s3 = new Triangle(50, 100, 400, 500, "orange");

        // 부모 클래스로 객체 생성 가능
        ShapeParent s4 = new ShapeParent(); // 너무 추상적인 객체
        // 너무 추상적인 객체 => 부모클래스는 객체 못함.

        System.out.println(s1.getId());
        System.out.println(s2.getId());
        System.out.println(s3.getId());

        s1.draw();
        s2.draw();
        s3.draw();

        // 자식클래스는 다른 객체를 만듭니다. 이 다른 객체를 부모 타입으로 참조했을 때
        // 실체 타입 검사 : instanceof 연산자

        System.out.println("rec instanceof Rectangle : " + (s1 instanceof Rectangle)); // true
        System.out.println("rec instanceof Triangle : " + (s1 instanceof Triangle)); // false
        System.out.println("rec instanceof Circle : " + (s1 instanceof Circle)); // false

        // 사용할 모든 도형을 배열 자료구조에 저장하기 (예시)
        ShapeParent[] shapes = new ShapeParent[] { s1, s2, null, s3, null }; // 맨처음 초기화할때만 {s1, s2, null, s3, null} 가능
        // shapes[0] = s1;

        // 모든 도형 중에 'Circle'만 반지름을 지정해서 그리기 : Circle 클래스는 radius 정의.
        for (ShapeParent sh : shapes) { // sh = shapes[i] (i값은 자동으로 증가)
            if (sh instanceof Circle) { // null instanceof Circle 는 false 처리
                System.out.println("원(circle)입니다. " + sh.toString());
                // 🔥 setRadius 를 실행하기 위해 Circle 타입으로 캐스팅해야합니다.
                // sh.setRadius 를 실행하기 위해 Circle 타입이지만 현재 참조는 부모 타입이므로 실행 못함.
                Circle temp = (Circle) sh; // 부모타입 변수를 자식타입으로 참조 X.
                temp.setRadius(40);
                temp.draw();
            } else {
                System.out.println("기타 도형 입니다. " + sh); // sh.toString()은 NullpointerException 발생
            }
        }

        // shapes 를 다시 새로운 배열로 대입할 때는 반드시 shapes = new ShpaeParente[]{s1, s2, null, s3,
        // null}

        /*
         * 번외
         * 움직이게 하려면
         * public int[] getPosition() {
         * return new int[] { posX, posY };
         * }
         * 메소드 제작 후
         * System.out.println("이전 위치: " + shape.getPosition()[0] + ", " +
         * shape.getPosition()[1]);
         * shape.move(offsetX, offsetY);
         * System.out.println("이동 후 위치: " + shape.getPosition()[0] + ", " +
         * shape.getPosition()[1]);
         */
    }
}

class ShapeParent { // <= 제작 순서 1번 시작
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String color;
    private int id;

    private static int count = 0;

    // <= 각각 필드 구현

    ShapeParent() { // <=일반 생성자 구현
        count++; // <=카운트 1개씩 더하도록함.
        this.id = count; // <=id값에 카운트를 넣음.
        this.color = "black"; // <=기본 컬러는 black으로 지정
    }

    ShapeParent(int posX, int posY, int width, int height, String color) {
        this();
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
    } // 커스텀 생성자

    @Override // <= 재정의 포맷 형식 바꿔줌
    public String toString() {
        return String.format("shape id[%d] pos(%d, %d) size(%d, %d) %s",
                id, posX, posY, width, height, color);
    } // <=id값/x,y값/w,h값/색

    public void move(int offsetX, int offsetY) { // <=move 기능 만들어줌
        this.posX += offsetX; // <=offsetX 만큼 움직이게
        this.posY += offsetY; // <= offsetY 만큼 움직이게
    }

    public void resize(int offsetW, int offsetH) { // <= resize 기능 만들어줌
        this.width += offsetW; // <= offsetW 만큼 움직이게
        this.height += offsetH; // <= offsetH 만큼 움직이게
    }

    public void color(String color) {
        this.color = color; // <= 사용자가 전달한 color 값을 현재 객체의 색상(this.color)에 저장
    }

    public double calcArea() { // <= 면적 계산식을 만들어줌
        return width * height; // <= 가로 세로 길이 곱하여 면적 계산
    }

    public void draw() {
        System.out.println("도형 그리기 : " + this.toString() + " area: " + calcArea());
    } // <= toString 과 면적 계산식을 출력하게함

    public int getId() {
        return id;
    } // <= 객체 생성될 때마다 증가되는 count 값에 따라 id 외부에 사용할 수 있도록 제공

    public String getColor() {
        return color; // <= color 값 외부에 사용할 수 있도록 제공
    }

    public int[] getPosition() {
        return new int[] { posX, posY }; // <= 위치값
    }

    public int[] getSize() {
        return new int[] { width, height }; // <= 크기값
    }

}

class Rectangle extends ShapeParent { // <= 자식 클래스

    // 부모클래스의 커스텀 생성자를 사용하기 위해서 자식 클래스도 정의합니다.
    Rectangle() {
        super(); // 생략 가능
    } // <= 커스텀 생성자를 정의하지 않으면 커스텀 생성자 사용 불가
      // 그렇기에 일반 생성자를 먼저 정의

    Rectangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color); // 부모 클래스의 커스텀 생성자 호출
        // 인자의 형식, 개수는 일치
    } // <= 이후에 커스텀 생성자를 정의

    @Override // <= Rectangle.draw에 모양 재정의 해둠.
    public void draw() {
        super.draw();
        System.out.println("■■■■■■■■■■■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■■■■■■■■■■■");
    }

}

class Triangle extends ShapeParent { // <= 삼각형 자식 클래스 정의

    Triangle() {
        super(); // 생략 가능
    } // <= 커스텀 생성자를 정의하지 않으면 커스텀 생성자 사용 불가
      // 그렇기에 일반 생성자를 먼저 정의

    Triangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }// <= 이후에 커스텀 생성자를 정의

    @Override // <= Triangle.draw에 모양 재정의 해둠.
    public void draw() {
        super.draw();
        System.out.println("    #    ");
        System.out.println("   ###   ");
        System.out.println("  #####  ");
        System.out.println(" ####### ");
        System.out.println("#########");
    }
}

class Circle extends ShapeParent { // <= 원형 자식 클래스 정의

    // 원에 필요한 반지름을 새로운 속성으로 추가
    private int radius; // <= 반지름 속성 추가
    private static final double PI = 3.14; // <= 원주율 추가

    Circle() {
        super(); // 생략 가능 // <= 커스텀 생성자를 정의하지 않으면 커스텀 생성자 사용 불가
        // 그렇기에 일반 생성자를 먼저 정의
    }

    Circle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }// <= 이후에 커스텀 생성자를 정의

    @Override // <= 면적값 재정의 반지름*반지름*원주율로 (원래는 가로*세로)
    public double calcArea() {
        return radius * radius * PI;
    }

    public int getRadius() { // <= getter
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    } // <= setter로 값 외부로 전달

    @Override // <= Circle.draw에 모양 재정의 해둠.
    public void draw() {
        super.draw();
        System.out.println("   @@@@  ");
        System.out.println(" @      @ ");
        System.out.println("@        @");
        System.out.println("@        @");
        System.out.println(" @      @ ");
        System.out.println("   @@@@    ");
    }

}
