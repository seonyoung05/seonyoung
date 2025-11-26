package Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework8 {

    public static void main(String[] args) {

        // HashMap에 미리 ID/Password 저장
        Map<String, String> loginData = new HashMap<>();
        loginData.put("myId", "myPass");
        loginData.put("myId2", "myPass2");
        loginData.put("myId3", "myPass3");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            String id = sc.nextLine().trim();

            // ID 존재 확인
            if (!loginData.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
                continue;
            }

            // ID 존재하므로 비밀번호 입력
            System.out.print("password : ");
            String pwd = sc.nextLine().trim();

            // 비밀번호 일치 여부 확인
            if (!loginData.get(id).equals(pwd)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
                continue;
            }

            // 로그인 성공
            System.out.println("id와 비밀번호가 일치합니다.");
            break;
        }

        sc.close();
    }
}
