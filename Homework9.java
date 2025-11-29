package Homework;

import java.io.*;
import java.util.*;

public class Homework9 {

    public static void main(String[] args) {

        // ID-Password 쌍 저장할 HashMap
        Map<String, String> dbMap = new HashMap<>();

        // ------------------------------
        // 1) db.txt 파일 읽어서 HashMap에 저장
        // ------------------------------
        try (Scanner fileScanner = new Scanner(new File("db.txt"))) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue; // 빈 줄 무시

                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    dbMap.put(parts[0].trim(), parts[1].trim());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("db.txt 파일을 찾을 수 없습니다.");
            return; // 실행 종료
        }

        // ------------------------------
        // 2) 로그인 기능 구현
        // ------------------------------
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");
            System.out.print("id : ");
            String inputId = sc.nextLine().trim();

            // ID 존재 확인
            if (!dbMap.containsKey(inputId)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
                continue;  // 다시 처음으로
            }

            System.out.print("password : ");
            String inputPw = sc.nextLine().trim();

            if (!dbMap.get(inputId).equals(inputPw)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
                continue;
            }

            System.out.println("id와 비밀번호가 일치합니다.");
            break;
        }
    }
}
