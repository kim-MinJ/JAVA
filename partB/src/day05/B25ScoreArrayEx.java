package day05;

import java.util.Arrays;

public class B25ScoreArrayEx {
    public static void main(String[] args) {
        StudentScore sana = new StudentScore();
        StudentScore momo = new StudentScore("김모모", 78, 100, 88);
        // 여기까지 1번 제작
        sana.updateScores(99, 90, 89);
        momo.setKor(92);
        System.out.println();
        System.out.println("sana 성적 : " + Arrays.toString(sana.getScores())
                + "avg : " + sana.getAverage() + ", " + sana.getGrade()); // sana 성적 : [99, 90, 89] avg : 92, 66, A
        System.out.println("momo 성적 : " + Arrays.toString(momo.getScores())
                + "avg : " + momo.getAverage() + ", " + momo.getGrade()); // momo 성적 : [92, 100, 88] avg : 93, 33, A

        // // scores 배열 테스트
        int[] temp = momo.getScores();
        temp[2] = 11; // MATH 인덱스
        System.out.println(momo.getMath()); // 객체의 배열 요소값이 수정됩니다.
        // -> 배열을 리턴할 때(getXXX 메소드) : 참조값 vs 새로운 배열
        System.out.println(Arrays.toString(momo.getScores()));
        // 😢

        System.out.println("사나의 최대 점수 : " + sana.getMaxScore());
        System.out.println("사나의 최대 점수 : " + sana.getMinScore());
    }
}

class StudentScore { // 여기부터 2번 제작
    private String name;
    private int[] scores; // 국어, 영어, 수학 점수를 저장하는 배열

    // 상수 정의 (배열 인덱스) : final 키워드는 변수의 값을 변경할 수 없도록 설정합니다.
    private static final int KOR = 0;
    private static final int ENG = 1;
    private static final int MATH = 2;
    // public이든 private든 상관없음

    // 기본 생성자
    public StudentScore() {
        this.scores = new int[3]; // 3개 과목
    }

    // 매개변수 생성자
    public StudentScore(String name, int kor, int eng, int math) {
        this(); // 자신의 기본생성자 호출. this 가 생성된 객체 자신. 꼭 첫줄에 작성.
        this.name = name;
        this.scores = new int[3]; // 1번 문제 : scores에 있는 [KOR, ENG, MATH]를 넣어주는 역할
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    // 이름 getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 국어 점수 getter/setter
    public int getKor() {
        return scores[KOR];
    }

    public void setKor(int kor) {
        this.scores[KOR] = kor;
    }

    // 영어 점수 getter/setter
    public int getEng() {
        return scores[ENG];
    }

    public void setEng(int eng) {
        this.scores[ENG] = eng;
    }

    // 수학 점수 getter/setter
    public int getMath() {
        return scores[MATH];
    }

    public void setMath(int math) {
        this.scores[MATH] = math;
    }

    // 점수 배열 전체 getter
    public int[] getScores() {
        return scores.clone(); // 4.번 문제 //외부에서 배열 요소를 변경할 수 없도록 새로운 배열 리턴
        // return this.scores; //this.scores 를 해버리면 참조값 리턴.
    }

    // 총점 계산
    public int getTotal() {
        int total = 0;
        for (int score : scores) { // <= for-each를 이용해 scores(배열)에서 score(값)를 하나씩 꺼냄
            total += score; // 5번 문제 //<= 꺼낸 score(값)을 total에 +(저장)하고 모든 값을 저장해서 합침
        }
        return total;
    }

    // 평균 계산 - 소수점 이하 둘째짜리로 리턴
    public double getAverage() {
        return Math.floor((double) getTotal() / scores.length * 100) / 100; // 6번 문제
    }

    // 등급 계산 (평균 기준)
    public String getGrade() {
        int avg = (int) getAverage(); // 7번 문제 getAverage는 소수이기에 (int)로 강제로 전환
        // getAverage가 double이였다는게 중요한 포인트
        return switch (avg / 10) { // 몫
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    // 모든 점수 업데이트
    public void updateScores(int kor, int eng, int math) {
        this.scores[KOR] = kor; // 8번 문제
        this.scores[ENG] = eng; // 9번 문제
        this.scores[MATH] = math; // 10번 문제
    }

    // 최고 점수 찾기
    public int getMaxScore() {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) { // 11번 문제 배열에 있는 값이 max 보다 클 때만 max를 바꿔줌
                max = scores[i];
            }
        }
        return max;

    }

    // 최소 점수 찾기
    public int getMinScore() {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }
    // 여기까지 2번
}