package Homework;

import java.util.Scanner;

public class Homework4 {
    int gcd(int m, int n){
        if(n==0){return m;}
        else{return gcd(n, m%n);}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Homework4 gcd = new Homework4();

        System.out.print("두 수를 입력하세요: ");
        int m = scanner.nextInt();;
        int n = scanner.nextInt();

        int result = gcd.gcd(m, n);
        System.out.printf("두 수의 최대공약수는 %d입니다.", result);
    }
}

