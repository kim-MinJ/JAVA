package test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        initProductList(list);
        System.out.println("ㅁㅁㅁㅁ 상품 관리 프로그램입니다. ㅁㅁㅁㅁ");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가    [R] 상품 삭제    [U] 가격 변경  \n"
                    + "[L] 전체 상품 목록    [S] 상품 조회    [E] 종료  ");
            String menu = System.console().readLine("선택 >>>> ");
            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list);
                        break;
                    case "R":
                        int index = Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>>"));
                        removeProduct(list, index);
                        break;
                    case "U":
                        index = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력 >>>>"));
                        modifyProduct(list, index);
                        break;
                    case "L":
                        System.out.println("\t\t상품리스트");
                        for (int i = 0; i < list.size(); i++)
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;
                    case "S":
                        String find = System.console().readLine("\t찾는 상품 제목 단어 입력 >>> ");
                        for (int i = 0; i < list.size(); i++) {
                            Product p = list.get(i);
                            if (p.getTitle().contains(find)) {
                                System.out.println("\t" + i + ": " + p);
                            }
                        }
                        break;
                    case "E":
                        status = false;
                        break;

                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                } // switch end
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        } // while end
    } // main end

    private static void initProductList(List<Product> list) {
        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);
        Product p5 = new Product(7890, "삼성 갤럭시북", 452000.0);

        list.addAll(List.of(p1, p2, p3, p4, p5));
    }

    private static void addProduct(List<Product> list) {
        int id = (int) (Math.random() * 8890) + 1111;
        String title = System.console().readLine("\t상품 제목 입력 >>> ");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>> "));
        if (confirm("상품 등록")) {
            Product p = new Product(id, title, price);
            list.add(p);
            System.out.println("\t등록 확인 : " + p);
        } else {
            System.out.println("\t등록 취소했습니다.");
        }
    }

    private static void removeProduct(List<Product> list, int index) {
        if (confirm("삭제")) {
            Product p = list.remove(index);
            System.out.println("\t삭제 데이터 : " + p);
        } else {
            System.out.println("\t삭제를 취소했습니다.");
        }
    }

    private static void modifyProduct(List<Product> list, int index) {
        double pr = Double.parseDouble(System.console().readLine("\t판매 가격 입력 >>>> "));
        if (confirm("가격 변경")) {
            list.get(index).setPrice(pr);
            System.out.println("\t업데이트 결과 : " + list.get(index));
        } else {
            System.out.println("\t가격 변경을 취소했습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + "을(를) 실행할까요?(확인:엔터, 취소:N)  ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
