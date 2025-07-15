package day05;

import java.util.Arrays;

public class B22SortAlgorithm {
    public static void main(String[] args) {
        // {}안에 숫자는 B21에서 나온 난수 6자리
        int[] nums = { 11, 13, 26, 44, 41, 12 };
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp; // 변수의 값 교환을 위한 임시 변수
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(nums)));
        }

        // selectionSort 메소드 실행
        int[] nums2 = { 88, 45, 23, 78, 56, 99, 84, 55, 78, 34 };
        selectionSort(nums2);
        System.out.println("nums2 정렬 후 : " + Arrays.toString(nums2));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp; // 변수의 값 교환을 위한 임시 변수
                if (arr[i] > arr[j]) { // ex) i=4 j=2
                    temp = arr[i]; // i를 temp에 저장 i=비었음 j=2 temp=4
                    arr[i] = arr[j]; // i=j값을 가져옴 i=2 j=비었음 temp=4
                    arr[j] = temp; // j가 다시 temp값을 가져옴 i=2 j=4 temp=사라짐
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(arr)));
        }
    }
}
