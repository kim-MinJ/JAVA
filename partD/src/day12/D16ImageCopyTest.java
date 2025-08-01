package day12;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 이미지는 이진파일형식. 바이트 단위로 처리합니다.
public class D16ImageCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            int b;
            int count = 0;
            String readFilename = D15FileTest.showFileDialog("파일 선택", FileDialog.LOAD);
            // 파일 읽기(이미지파일, 선택 예정)
            fis = new FileInputStream(readFilename); // 읽기를 위한 스트림

            // 파일 쓰기(저장)
            String saveFilename = D15FileTest.showFileDialog("파일 저장", FileDialog.SAVE);
            fos = new FileOutputStream(saveFilename); // 쓰기를 위한 스트림

            // FileInputStream 와 FileOutputStream 가 try-catch 문이 필요함

            while ((b = fis.read()) != -1) {
                // b= fis.read() 입력 버퍼에서 한개의 바이트를 읽어옵니다. (파일의 끝 -1)
                // 프로그램 변수에 저장할 때는 int 타입 저장
                count++; // 바이트 카운트
                fos.write(b); // 파일 쓰기
            }
            System.out.println("읽어온 바이트 수 : " + count + "bytes");
            System.out.println(count + "바이트 파일 복사 성공했습니다.");

        } catch (Exception e) {
            System.out.println("입출력 예외 : " + e.getMessage());
        } finally { // 리소스 정리(해제)
            try {
                fis.close(); // try-catch문 무조건 써야함
                fos.close();
            } catch (IOException e) {
            }
        }
    }
}
