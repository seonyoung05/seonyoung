package Homework;

class Monitor {
    private String monitorSize;
    private String color;
    private String power;

    public Monitor(String monitorSize, String color, String power) {
        this.monitorSize = monitorSize;
        this.color = color;
        this.power = power;
    }

    public String turnOn() {
        return "Turning on the monitor.";
    }

    public String printInfo() {
        return "The spec of the monitor\n" +
                " Size: " + monitorSize + "\n" +
                " Color: " + color + "\n" +
                " Power: " + power;
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String hd;
    private String color;
    private String power;

    public Computer(String cpu, String memory, String hd, String color, String power) {
        this.cpu = cpu;
        this.memory = memory;
        this.hd = hd;
        this.color = color;
        this.power = power;
    }

    public String turnOn() {
        return "Turning on the computer.";
    }

    public String printInfo() {
        return "The spec of the computer\n" +
                " CPU: " + cpu + "\n" +
                " Memory: " + memory + "\n" +
                " HDD: " + hd + "\n" +
                " Color: " + color + "\n" +
                " Power: " + power;
    }
}

class PersonalComputer {
    private Computer computer;
    private Monitor monitor;

    public PersonalComputer(Computer computer, Monitor monitor) {
        this.computer = computer;
        this.monitor = monitor;
    }

    public void turnOn() {
        System.out.println(computer.turnOn());
        System.out.println(monitor.turnOn());
    }

    public void printInfo() {
        System.out.println(computer.printInfo());
        System.out.println();
        System.out.println(monitor.printInfo());
    }
}

public class Homework5 {
    public static void main(String[] args) {
        Computer com = new Computer("Core i7", "16GB", "2TB", "White", "500W");
        Monitor mon = new Monitor("24 inch", "Black", "45W");
        PersonalComputer pc = new PersonalComputer(com, mon);

        pc.turnOn();
        pc.printInfo();
    }
}

