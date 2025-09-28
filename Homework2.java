package Homework;

import java.util.Scanner;

class Student{
    int id;
    long num;
    String name, major;

    Student() {}
    Student(int id, String name, String major, long num){
        this.id = id;
        this.name= name;
        this.major = major;
        this.num = num;
    }
    public int getId(){ return id; }
    public String getName(){ return name;}
    public String getMajor(){ return major; }
    public long getNum(){ return num; }

    void setId(int id){ this.id = id;}
    void setName(String name){ this.name = name;}
    void setMajor(String  major){ this.major = major;}
    void setNum(long num){ this.num = num;}

    String getPhoneNum(){
        String phone = Long.toString(num);
        while(phone.length() < 10){
            phone = "0" + phone;
        }
        return "0" + phone.substring(0,2)+"-"+phone.substring(2,6)+"-"+phone.substring(6);
    }
}
public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        for(int i=0; i<3; i++){
            students[i] = new Student();
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");

            int id = Integer.parseInt(scanner.next());
            String name = scanner.next();
            String major = scanner.next();
            long num = Long.parseLong(scanner.next());

            students[i].setId(id);
            students[i].setName(name);
            students[i].setMajor(major);
            students[i].setNum(num);
        }

        System.out.println("\n입력된 학생들의 정보는 다음과 같습니다.");
        for(int i=0; i<students.length; i++){
            System.out.println((i+1)+"번째 학생: "
                    +students[i].getId() + " "
                    +students[i].getName() + " "
                    +students[i].getMajor()+ " "
                    +students[i].getPhoneNum());
        }

    }
}