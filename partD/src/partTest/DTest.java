package partTest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class DTest {

    public static void main(String[] args) {
        writeFileAutoClose();
    }

    public static void writeFileAutoClose() {
        String line;
        int count = 0;

        try (
                FileReader fr = new FileReader(
                        "C:\\Class250615\\java_workspace\\partD\\src\\day09\\D05MemberManagerApp.java",
                        Charset.forName("UTF-8"));
                Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                // 정규표현식으로 단어 추출 (공백과 특수문자 기준으로 나누기)
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    if (!word.isEmpty()) { // 빈 문자열은 제외
                        // System.out.println(word);
                        count++;
                    }
                }
            }
            System.out.println("읽은 영문자 단어 개수 : " + count);
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }
}
