package day12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class D18_1Test {
    public static void main(String[] args) {
        List<JavaKeyWord> javakeywords = new ArrayList<>();
        // writeFile();
        readByLine();

    }

    public static void writeFile() {
        String filename = "java_keyword.csv";
        try (
                FileWriter fw = new FileWriter(filename, Charset.forName("UTF-8"));
                PrintWriter pw = new PrintWriter(fw);) {
            int line = 0;
            String test = "public,공용의,1 private,사적인,1 list,목록,1 immutable,불변의,3 static,정적인,2";
            String[] lines = test.split("\\s+");
            for (int i = 0; i < lines.length; i++) {
                pw.println(lines[i]);
                line++;
            }
            System.out.println(line + "행이 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class JavaKeyWord {
        private String keyword;
        private String korean;
        private int level;

        @Override
        public String toString() {
            return keyword + "," + korean + "," + level;
        }
    }

    public static void readByLine() {
        String line = null;
        FileReader fr = null;
        Scanner sc = null;
        StringBuilder sb = new StringBuilder();
        String[] javakeyword = null;
        try {
            fr = new FileReader("java_keyword.csv", Charset.forName("UTF-8"));
            sc = new Scanner(fr);
            while (sc.hasNext()) {
                line = sc.nextLine();
                sb.append(line).append("\n");
                javakeyword = line.split(",");
                System.out.println(Arrays.toString(javakeyword));
            }
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        } finally {
            try {
                fr.close();
                sc.close();
            } catch (Exception e) {
            }
        }
    }

}
