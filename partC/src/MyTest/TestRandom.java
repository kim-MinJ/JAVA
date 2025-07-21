package MyTest;

public class TestRandom {
    public static void main(String[] args) {
        int[] result = new int[5]; // <= 배열 result를 생성하여 length를 5를 줌
        int answer = (int) (Math.random() * 50) + 1; // <= answer 값을 int로 강제 전환하여 숫자50까지 나올 수 있도록 함.
        int count = 0; // <= 카운트 기본값 0으로 시작
        boolean isCorrect = false; // <= 참, 거짓 기본값 설정

        System.out.println("[[[[[ 숫자게임을 시작합니다. ]]]]]]");
        System.out.println("- 너 휴먼은 맞춰보세요. (숫자는 1부터 50 사이)");

        String name = System.console().readLine("참가자 닉네임 (종료:end) >>> "); // <= 참가자 이름 기억시켜 name에 저장
        if (name.equals("end")) { // <= end 입력시 프로그램 종료가 출력되도록 if문 사용
            System.out.println("::프로그램 종료::");
            return;
        }

        do { // <= do~ while 문은 do~ 에 있는 것을 모두 1회 실행 후 여부에 따라 while을 실행
            System.out.print("너 휴먼 생각한 숫자 입력 (남은 기회 : " + (5 - count) + ") >>> "); // <= count를 사용하여 남은 기회 줄어드는걸 알려줌
            String line = System.console().readLine(); // <= 콘솔에서 입력한 값 받아와 line 변수에 저장
            int guess; // <= 비교해줄 값 guess를 설정
            try {
                guess = Integer.parseInt(line); // <= guess를 정수로 받아오기
            } catch (NumberFormatException e) { // <= 만약 정수가 아니라면 문장 출력
                System.out.println("숫자만 입력하세요!");
                continue;
            }

            result[count] = guess; // <= 입력한 값 result[]에 저장 예) 입력값 25이면 result[0] = 25
            count++; // <= 저장될 때마다 count값이 1씩 증가되도록 함

            if (guess == answer) { // <= 입력값과 정답이 같을 경우
                System.out.println("딩동댕!! 정답입니다.");
                isCorrect = true; // <= isCorrect를 true로 만들어 while 문에서 true로 적용되도록 하였음.
                break;
            } else if (guess < answer) {
                System.out.println("너무 작습니다."); // <= 만약 guess가 answer값보다 작을 경우 출력
            } else {
                System.out.println("너무 큽니다."); // <= 만약 guess가 answer값보다 클 경우 출력
            }

        } while (count < 5); // <= 아직 시도횟수가 모두 넘어가기 전에 실행을 기준

        if (isCorrect) { // <= isCorrect가 true일 경우 출력(위에서 바꿔줌)
            System.out.println("숫자 맞추기 성공!!");
        } else { // <= 만약 true가 아닐 경우 출력
            System.out.println("실패!! 5번의 기회를 다 썼습니다. 게임을 다시 시작하세요!!");
        }

        System.out.println("▶ 정답은 : " + answer + "  |  시도 횟수 : " + count); // <= 정답 및 시도 횟수 표기
        System.out.print("▶ 입력한 숫자 : "); // <= 입력한 숫자를 나열하도록 출력
        for (int i = 0; i < count; i++) { // <= i값은 count 미만이라고 기준을 잡음
            System.out.print(result[i]); // <= 입력했었던 값 배열로 나열
            if (i < count - 1)
                System.out.print(", ");
            // <= count-1을 이용하여 아직 입력하지 못했거나 하지 않은 값은 나오지 않도록 함
        }
        System.out.println();

        GameValue game = new GameValue(name, count, isCorrect);
        game.showResult(); // <= 방금 만든 game에 showResult라는 메서드 붙여줌
    }

    static class GameValue { // <= 클래스를 지정하여 gamer, tryCount, success 등을 넣어줌
        String gamer;
        int tryCount;
        boolean success;

        GameValue(String gamer, int tryCount, boolean success) { // <= 생성자 제작
            this.gamer = gamer;
            this.tryCount = tryCount;
            this.success = success;
        }

        void showResult() { // <= 생성자를 통해 가져온 값으로 확인함
            System.out.println("\nGameValue 객체 확인");
            System.out.println("gamer : " + gamer + ", 시도횟수 : " + tryCount + ", 성공여부 : " + success);
        }
    }
}