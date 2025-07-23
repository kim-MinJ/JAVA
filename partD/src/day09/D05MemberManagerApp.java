package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        // List<Member> 라는 변수타입을 가진 list 변수에 할당된 새로운 객체를 생성
        // list 초기화 메소드 실행
        initMemberList(list); // list 변수 참조값 전달
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true; // while 문이 자동으로 반복하기 위해 선언
        while (status) { // status의 값이 true이기에 반복할 수 있음
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 회원 추가  [R] 회원 삭제  [U] 회원 포인트 변경  " +
                    "\n[S] 회원 목록  [N] 이름 조회  [E] 종료");
            ;
            String menu = System.console().readLine("선택 >>> ");
            // menu에 readLine 입력값을 넣어줌

            // 인덱스, 회원 id 입력 : 잘못된 문자 입력하면 Integer.parseInt() 메소드 예외 생깁니다.
            // 단순 처리 : swich 문을 try 구문으로 묶어서 예외 발생하면 다시 반복 처음 메뉴 입력 실행하기
            switch (menu.toUpperCase()) { // menu에 넣어준걸 대문자로 전환후 그에 따라 다른 반응이 나오도록함
                case "A":
                    addMember(list); // id, 이름 입력. point는 기본값 100
                    break;
                case "N":
                    String find = System.console().readLine("조회할 이름 입력 >>>");
                    // find에 입력한 이름값 넣어줌
                    int count = 0; // 조회시 데이터가 있는지 없는지 if문을 사용하기 위해 생성
                    for (int i = 0; i < list.size(); i++) {
                        Member m = list.get(i); // 해당하는 인덱스의 데이터값을 m에 저장
                        if (m.getName().contains(find)) {
                            // 순서대로 인덱스 i 의 데이터 가져와서 getter 이름값이 contains(find)(입력값에 포함되어 있을 경우)
                            System.out.println(("\t" + i + ": " + m));
                            // 출력값 = find한 인덱스 : id값+회원이름+포인트
                            count++;
                            // if문으로 조회데이터가 없을 경우의 출력문이 나오지 않도록 하기 위해
                        }
                    }
                    if (count == 0)
                        System.out.println("\t조회 데이터가 없습니다.");
                    // 위에 설정한 count값으로 나오도록 설정함. 위에 if문에 count++을 하지 않을 경우엔
                    // 위에 if문에서도 count가 0이기에 같이 송출되어 count++을 해줘야함
                    break;
                case "R":
                    int index = Integer.parseInt(System.console().readLine("삭제할 인덱스 입력 >>> "));
                    // 입력값을 index에 저장
                    if (confirm("회원 삭제")) {
                        Member m = list.remove(index); // index를 기준으로 list에서 삭제(remove)
                        System.out.println("\t 삭제 데이터 확인 : " + m);
                    } else {
                        System.out.println("\t 삭제 취소합니다.");
                    }

                    System.out.println(index + "번 인덱스를 삭제했습니다.");
                    break;
                case "U":
                    index = Integer.parseInt(System.console().readLine("수정할 인덱스 입력 >>> "));
                    double point = Double.parseDouble(System.console().readLine("\t 포인트 입력 >>> "));
                    if (confirm("포인트 변경")) {
                        list.get(index).setPoint(point);
                        // ✅ index 의 객체를 가져와서 (Member 타입) setter 로 point 값 변경
                        System.out.println("\t 업데이트 결과 : " + list.get(index));
                    } else {
                        System.out.println("\t 포인트 변경을 취소했습니다.");
                    }
                    break;
                case "S":
                    System.out.println("\t\t 회원 리스트. ");
                    for (int i = 0; i < list.size(); i++)
                        System.out.println("\t" + i + ": " + list.get(i));
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

    // 프로그램 실행할 때 마다 4개의 객체를 리스트에 저장하고 시작 : list 초기화
    // 메소드 인자는 main 메소드의 ArrayList 객체의 주소를 저장.
    private static void initMemberList(List<Member> list) {
        Member m1 = new Member(1, "김땡땡", 3.4);
        Member m2 = new Member(2, "반하나", 1.9);
        Member m3 = new Member(3, "최사과", 5.4);
        Member m4 = new Member(4, "박모모", 6.3);

        // 불변 객체 리스트가 메소드의 인자로 모든 요소를 가변 객체 list 에 모든 요소 추가
        list.addAll(List.of(m1, m2, m3, m4));
        // 가장 위에 List<Member> list = new ArrayList<>(); 라는 가변 list를 만들어줌
        // addAll()을 통해서 불변 리스트의 요소를 list라는 가변 리스트에 복사 및 추가
        // 결론 : addAll() = 객체(요소 ex)m1, m2)들만 가변 리스트에 복사 List.of = 불변리스트 생성
    }

    public static void addMember(List<Member> list) {
        int id = Integer.parseInt(System.console().readLine("\t 고객 id 입력 >>> "));
        String name = System.console().readLine("\t 고객 이름 입력 >>> ");
        if (confirm("회원 등록")) {
            Member m = new Member(id, name, 100);
            list.add(m);
            System.out.println("\t등록회원 : " + m);
        } else {
            System.out.println("\t 등록 작업을 취소하였습니다.");
        }
    }

    // JAVA TEST에는 랜덤값을 줄거임

    // 추가, 삭제, 변경 작업 반영할 때 확인 받는 메시지 출력 메소드
    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을 실행할까요? (확인:엔터, 취소:N)");
        // 엔터를 누르면 참 리턴
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
