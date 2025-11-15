package Homework;

abstract class Printer {
    protected String model;        // 모델명
    protected int printedCount;    // 현재까지 출력된 매수
    protected int availableCount;  // 출력 가능 매수

    public Printer(String model, int availableCount) {
        this.model = model;
        this.availableCount = availableCount;
        this.printedCount = 0;
    }

    // 추상 메소드
    public abstract boolean print();
}

class InkjetPrinter extends Printer {

    public InkjetPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            // 실패 메시지
            System.out.printf("%s: %d매째 인쇄 실패 - 잉크 부족.\n",
                    model, printedCount + 1);
            return false;
        }
        printedCount++;
        availableCount--;
        return true;
    }
}

class LaserPrinter extends Printer {

    public LaserPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            // 실패 메시지
            System.out.printf("%s: %d매째 인쇄 실패 - 토너 부족.\n",
                    model, printedCount + 1);
            return false;
        }
        printedCount++;
        availableCount--;
        return true;
    }
}

public class Homework7 {
    public static void main(String[] args) {
        InkjetPrinter inkjet = new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser = new LaserPrinter("Canon MFC643Cdw", 1500);

        // availableCount 떨어질 때까지 계속 print()
        while (inkjet.print());
        while (laser.print());
    }
}