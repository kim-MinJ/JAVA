package day12;

import java.awt.FileDialog;
import java.io.File;

import javax.swing.JFrame;
import java.awt.FileDialog;

public class D15FileTest {
    public static void main(String[] args) {
        // String filename = "README.md"; // 파일명을 변수처리
        // 폴더 위치 현재폴더가 아닌 경우는 정확히 경로까지 작성.
        String filename = showFileDialog("파일 선택", FileDialog.LOAD);
        if (filename == null || filename.length() == 0) { // 파일이름이 없거나 길이가 0이면
            System.out.println("파일 선택 취소했습니다.");
            return; // 종료
        }
        File file = new File(filename); // 파일명 지정
        System.out.println("file 이 있나? " + file.exists()); // 파일이 존재하는거 참, 거짓

        // 1. 파일 생성 - 이미 있는지 확인하고 만들기
        try {
            if (file.exists()) { // 파일이 있는지 확인하는 참/거짓
                System.out.println("파일이 이미 존재합니다.");
            } else { // 파일이 없을 때
                if (file.createNewFile()) { // 파일이 생성되면
                    System.out.println("파일이 만들어졌습니다.");
                } else {
                    System.out.println("파일 생성 실패했습니다.");
                }
            }
        } catch (Exception e) {
            System.out.println("파일 처리 예외 : " + e.getMessage());
        }

        // 2. 파일 정보 출력
        System.out.println("파일 이름 : " + file.getName());
        System.out.println("파일 경로 : " + file.getAbsolutePath());
        System.out.println("파일 크기 : " + file.length());
    }

    // 운영체제의 파일선택 GUI 활용
    public static String showFileDialog(String title, int type) {   // title : 대화상자 타이틀 type : filedialog.load or filedialog.save
        // 윈도우 창 객체 생성. 파일 선택 대화상자의 컨테이너
        JFrame jf = new JFrame();
        jf.setVisible(false);

        // import java.awt.FileDialog
        FileDialog fd = new FileDialog(jf, title, type); // 대화상자의 제목(title)과 버튼이름(type) 설정
        fd.setVisible(true);

        // 선택한 파일의 정보는 fd 가 저장
        System.out.println(fd);
        System.out.println("선택한 폴더 : " + fd.getDirectory()); // 폴더 위치
        System.out.println("선택한 파일 : " + fd.getFile()); // 파일명
        jf.dispose(); // 프레임 해제

        if (fd != null && (fd.getDirectory() == null || fd.getFile() == null)) {
            return null;
        } else {
            return fd.getDirectory() + fd.getFile();
        }
    }

}
