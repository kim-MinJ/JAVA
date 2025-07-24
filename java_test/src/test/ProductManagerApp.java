package test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        initProductList(list);
        // list = initProductList(list); 1번 정답
        // -> initProductList에 인자로 list가 들어와있는데 list객체 에 또 list를 넣어주겠다함

        System.out.println(" ㅁㅁㅁㅁ 상품 관리 프로그램입니다. ㅁㅁㅁㅁ");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가   [R] 상품 삭제   [U] 가격 변경 \n"
                    + "[L] 전체 상품 목록  [S] 상품 조회  [E] 종료");
            String menu = System.console().readLine("선택 >>> ");
            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list);
                        break;
                    case "R":
                        int index = Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>> ")); // 2번 완
                        if (confirm("삭제")) {
                            Product p = list.remove(index);
                            // List p = remove(get(index)); //3번 완
                            /*
                             * List는 인터페이스 타입일뿐이며, Product라는 인터페이스 변수를 지정해줘야했고
                             * remove는 삭제는 list 내에 있는 index 전체를 지워버리는 것이기에 list 내에 있는 index를 직접 삭제시켜야함
                             * get(index)로 할 필요가 없음
                             * Product를 쓰는 이유는 List의 항목을 건드리기 때문?
                             */
                            System.out.println(("\t삭제 데이터 : " + p));
                        } else {
                            System.out.println("\t삭제를 취소했습니다.");
                        }
                        break;
                    case "U":
                        index = Integer.parseInt((System.console().readLine("\t수정할 인덱스 입력 >>>>")));
                        double prc = Double.parseDouble(System.console().readLine("\t판매 가격 입력 >>> ")); // 4번 완
                        if (confirm("가격 변경")) {
                            list.get(index).setPrice(prc); // 5번 완
                            System.out.println("\t업데이트 결과 : " + list.get(index)); // 6번 완
                        } else {
                            System.out.println("\t가격 변경을 취소했습니다.");
                        }
                        break;
                    case "L":
                        System.out.println("\t\t상품 리스트");
                        for (int i = 0; i < list.size(); i++) // 7번 완
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;
                    case "S":
                        String find = System.console().readLine("\t찾는 상품 제목 단어 입력 >>>"); // 8번 완
                        for (int i = 0; i < list.size(); i++) {
                            Product p = list.get(i);
                            // 정답 못씀
                            /*
                             * 틀린 이유 : p값에 list에서 for문에서 쓴 i값을 따라 하나씩 객체를 가져오도록함.
                             * 그 다음 if문에서 p에서 title을 getter로 가져와 cotains(find)로 찾아낸 값만 출력되도록 하였음.
                             */
                            if (p.getTitle().contains(find)) {
                                System.out.println("\t" + i + ": " + p);
                            }
                        }
                        break;
                    case "E":
                        status = false; // 10번 완
                        break;
                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                } // switch end
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
            /*
             * 위에 try를 넣어두고 세트로 나오는 catch문을 안넣어둠...
             * try를 넣으면 무조건 catch문이 따라 들어와 exception(예외)를
             * 알려줘야하는데 try넣은걸 생각안함...
             * 경고문으로 Syntax error, insert "Finally" to complete TryStatement 가
             * 뜨는데 catch로 잡아줘야했음
             * Exception중에서 NumberFormatException을 사용하는 이유는
             * switch문에서 list에 없는 index 입력시 예외 잡아줌
             */
        } // while end
    } // main end

    private static void initProductList(List<Product> list) {
        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);

        list.addAll(List.of(p1, p2, p3, p4));
        // List<Product> list = ListOf(p1, p2, p3, p4); 12번 정답
        // List.of()로 p1~4 객체를 불변객체로 만들어줌
        // 불변객체는 데이터를 바꿀 수 없으니
        // 데이터(요소)를 그대로 list에 복사하여 list 가변객체에 넣어줌

    }

    private static void addProduct(List<Product> list) {
        int pid = (int) (Math.random() * 8889) + 1111;

        // int pid = (int) (Math.random() * 9999) + 1;
        // if (pid < 1111)
        // pid = (int) (Math.random() * 9999) + 1;
        // 못적음 13번 정답
        /*
         * pid에서 Math랜덤을 하면 1이하의 실수로 나오는데 이를 최댓값이 9999로
         * 곱해준 뒤 + 1로 더해서 정수값이 제대로 나올 수 있도록 해줌
         * 
         */
        String title = System.console().readLine("\t상품 제목 입력 >>> ");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>> "));
        if (confirm("상품 등록")) {
            Product p = new Product(pid, title, price);
            list.add(p);
            // 못적음 14번 정답
            // list.add(p) 상품등록을 할 때에 새로 만들어준 new Product를 객체 p 에 담고
            // 그 담은 p를 list에 넣어주는(add())역할
            System.out.println("\t등록 확인 : " + p);
        } else {
            System.out.println("\t등록 취소 했습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을(를) 실행할까요? (확인:엔터, 취소:N) ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }

}