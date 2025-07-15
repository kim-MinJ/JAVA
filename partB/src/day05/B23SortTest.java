package day05;

import java.util.Arrays;

public class B23SortTest {
    public static void main(String[] args) {

        double[] darr1 = new double[10]; // <=실수 darr에 새로운 배열의 저장가능값 10개를 만들어둠
        for (int i = 0; i < darr1.length; i++) { // <= for문을 사용하여 i가 darr1.length(10)가 될 때가지 상승시킴
            darr1[i] = Math.random(); // <= darr1 의 i는 하나하나 모두 소수의 랜덤값을 붙여줌
            darr1[i] = Math.floor(darr1[i] * 100) / 100; // <= 소숫점을 해결하기 위해서 100을 곱해 정수로 만든 뒤 100을 나눠 2자리수로 고정
            // floor() 메소드로 소수점 이하 2자리 램덤 값 만들기
        }
        // 선택정렬 darr1과 같은 값으로 실행할 배열
        double[] darr2 = darr1.clone(); // darr1 배열을 복사해서 darr2 로 참조 <= darr2가 darr1을 복사

        System.out.println("랜덤 double 배열 1 : " + Arrays.toString(darr1));
        System.out.println("랜덤 double 배열 2 : " + Arrays.toString(darr2));
        // <= 랜덤한 배열 darr1, darr2를 출력

        // 실행 시간 비교 : 성능 측정 nanoTime() 메소드
        long startTime = System.nanoTime(); // <= 알고리즘 시작시간 기록
        new B23SortTest().bubbleSort(darr1); // <= 버블 정렬 실행
        long endTime = System.nanoTime(); // <= 알고리즘 끝시간 기록
        System.out.println("double 배열 정렬 후: " + Arrays.toString(darr1)); // <=배열정렬후 출력
        System.out.println("실행 시간 : " + (endTime - startTime) + " ns"); // <= starttime-endtime 한 기록한 실행시간 출력
        // bubbleSort : 25562200 ns

        startTime = System.nanoTime();
        new B23SortTest().selectionSort(darr2);
        endTime = System.nanoTime();
        System.out.println("double 배열 정렬 후: " + Arrays.toString(darr2));
        System.out.println("실행 시간 : " + (endTime - startTime) + " ns");
        // selectionSort : 2221700 ns
        // <= 위와 동일하지만 정렬방식을 bubblesort 대신 selectionsort를 사용함

        // bubbleSort = 왼쪽부터 인접한 두 개 요소씩 비교 크면 자리 바꿈 -> 큰 값이 우측으로 이동(반복)
        // selectionSort = 남은 부분 중에서 가장 작은 값의 인덱스 찾아 현재 위치와 최소값 위치 교환
    }
    // ✅ 참고 : 정렬(알고리즘)의 성능 측정 -> 시간복잡도. 표기 Big-O. n은 데이터갯수
    // 버블 정렬, 선택 정렬 : O(n의 제곱)
    // 병합 정렬, 퀵 정렬... : O(n log n) < O(n의 제곱)
    // Arrays.sort() 등 라이브러리는 성능이 좋은 알고리즘 사용합니다.

    //남은 부분중에서 가장 작은 값의 인덱스 찾아 현재 위치와 최소값 위치 교환
    void selectionSort(double[] arr) {  
        for (int i = 0; i < arr.length - 1; i++) {  //<= i값은 초기값은0에 i는 최대 arr.length(현 예제는 10)까지 1씩 상승
            for (int j = i + 1; j < arr.length; j++) { //<= j값은 i+1이 초기값으로 arr.length까지 j를 1씩 상승
                double temp; // 변수의 값 교환을 위한 임시 변수
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(String.format("i=%d  %s", i, Arrays.toString(arr)));
        }
    }

    //왼쪽부터 인접한 두 개 요소씩 비교 크면 자리 바꿈 -> 큰 값이 우측으로 이동(반복)
    // 인접한 2개 값을 비교
    void bubbleSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                double temp; // 변수의 값 교환을 위한 임시 변수
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(String.format("i=%d  %s", i, Arrays.toString(arr)));
        }
    }
}