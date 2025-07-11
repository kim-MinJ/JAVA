package mytest;

public class DeleteTest {
public static void main(String[] args) {
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
}
}
}
