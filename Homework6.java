package Homework;

class Course {
    protected String code;
    protected String name;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // toString method for the Course class (can be overridden in subclasses)
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name;
    }
}

// OnlineCourse.java
class OnlineCourse extends Course {

    public OnlineCourse(String code, String name) {
        super(code, name);
    }

    // Overriding the toString method to add "Type: Online"
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Type: Online";
    }
}

// OfflineCourse.java
class OfflineCourse extends Course {

    public OfflineCourse(String code, String name) {
        super(code, name);
    }

    // Overriding the toString method to add "Type: Offline"
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Type: Offline";
    }
}

// Homework6.java
public class Homework6 {
    public static void main(String[] args) {
        // Creating instances of OfflineCourse and OnlineCourse
        OfflineCourse course1 = new OfflineCourse("HAEA9201", "Object Oriented Programming");
        OnlineCourse course2 = new OnlineCourse("HAFL0012", "C Programming 1");

        // Printing the course details using the toString method
        System.out.println(course1);
        System.out.println(course2);
    }
}
