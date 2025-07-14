package day04;

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
        //c1.printCounts();    // 여기서는 staticCount 는 1입니다.
        Counter c2 = new Counter();
        c1.printCounts();  //staticCount 는 2 입니다. c1, c2객체 만들 때 +1 두번 함.
        c2.printCounts();
    }
}
