package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MyMemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경  [S] 회원 목록  [E] 종료");
            ;
            String menu = System.console().readLine("선택 >>> ");

            switch (menu.toUpperCase()) {
                case "A":
                    addMember(list);

                    break;
                case "R":
                    int index = Integer.parseInt(System.console().readLine("삭제할 인덱스 입력 >>> "));
                    list.remove(list.get(index));
                    System.out.println(index + "번 인덱스를 삭제했습니다.");
                    break;
                case "U":
                    index = Integer.parseInt(System.console().readLine("수정할 인덱스 입력 >>> "));
                    int i = index;
                    for (i = 0; i < list.size(); i++) {
                        double x = Integer.parseInt(System.console().readLine("수정할 포인트값 입력 >>> "));
                        list.get(i).getPoint();
                    }
                    break;
                case "S":
                    System.out.println("회원 목록입니다. " + list);
                    break;
                case "E":
                    status = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    break;
            }
        }
    }

    public static void addMember(List<Member> members) {
        String newmember = System.console().readLine("새로운 회원을 등록의 이름을 알려주세요.");
        

    }
}
