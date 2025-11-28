package Homework;

// 1) BoundingBox
// ---------------------------
class BoundingBox {
    double minX, minY;
    double maxX, maxY;

    public BoundingBox(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    // 두 박스를 합쳐서 새로운 박스를 만든다 (merge)
    public static BoundingBox merge(BoundingBox a, BoundingBox b) {
        return new BoundingBox(
                Math.min(a.minX, b.minX),
                Math.min(a.minY, b.minY),
                Math.max(a.maxX, b.maxX),
                Math.max(a.maxY, b.maxY)
        );
    }

    @Override
    public String toString() {
        return String.format("min (%.6f %.6f), max (%.6f %.6f)", minX, minY, maxX, maxY);
    }
}


// ---------------------------
// 2) Node + 자식 클래스들
// ---------------------------
class Node {
    int index;
    BoundingBox box;

    public Node(int index) {
        this.index = index;
    }
}


// ---------------------------
// InnerNode
// ---------------------------
class InnerNode extends Node {
    Node left, right;

    public InnerNode(int index, Node left, Node right) {
        super(index);
        this.left = left;
        this.right = right;

        // 두 자식의 bounding box를 merge하여 자신의 box 계산
        this.box = BoundingBox.merge(left.box, right.box);
    }

    @Override
    public String toString() {
        return String.format("node(%d): %s, child index (%d %d)",
                index, box.toString(), left.index, right.index);
    }
}


// ---------------------------
// LeafNode
// ---------------------------
class LeafNode extends Node {
    Shape shape;

    public LeafNode(int index, Shape shape) {
        super(index);
        this.shape = shape;
        this.box = shape.computeBoundingBox();
    }

    @Override
    public String toString() {
        return String.format("node(%d): %s, shape index (%d)",
                index, box.toString(), shape.index);
    }
}


// ---------------------------
// 3) Shape + Rectangle + Circle
// ---------------------------
abstract class Shape {
    int index;

    public Shape(int index) {
        this.index = index;
    }

    abstract BoundingBox computeBoundingBox();
}


// Rectangle: 중심 x,y + width + height
class Rectangle extends Shape {
    double cx, cy;
    double width, height;

    public Rectangle(int index, double cx, double cy, double width, double height) {
        super(index);
        this.cx = cx;
        this.cy = cy;
        this.width = width;
        this.height = height;
    }

    @Override
    BoundingBox computeBoundingBox() {
        double minX = cx - width / 2.0;
        double maxX = cx + width / 2.0;
        double minY = cy - height / 2.0;
        double maxY = cy + height / 2.0;

        return new BoundingBox(minX, minY, maxX, maxY);
    }
}


// Circle: 중심 x,y + radius
class Circle extends Shape {
    double cx, cy;
    double r;

    public Circle(int index, double cx, double cy, double r) {
        super(index);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    BoundingBox computeBoundingBox() {
        return new BoundingBox(cx - r, cy - r, cx + r, cy + r);
    }
}


// ---------------------------
// 4) main 제공된 대로 사용
// ---------------------------
public class Project2 {
    public static void main(String[] args) {
        //Rectangle의 파라미터 - 인덱스, 중점의 X좌표, 중점의 Y좌표, 가로길이, 세로길이
        Rectangle rect0 = new Rectangle(0, -1, -1, 2, 2);
        Rectangle rect1 = new Rectangle(1, 1, 1, 4, 3);

        //Circle의 파라미터 - 인덱스, 중점의 X좌표, 중점의 Y좌표, 반지름
        Circle circle2 = new Circle(2, 4, 3, 1);

        //LeafNode의 파라미터 - 인덱스, Shape 객체
        LeafNode node0 = new LeafNode(0, rect0);
        LeafNode node1 = new LeafNode(1, rect1);
        LeafNode node2 = new LeafNode(2, circle2);

        //InnerNode의 파라미터 - 인덱스, 왼쪽 자식 Node 객체, 오른쪽 자식 Node 객체
        InnerNode node3 = new InnerNode(3, node1, node0);
        InnerNode node4 = new InnerNode(4, node3, node2);

        System.out.println(node4);
        System.out.println(node3);
        System.out.println(node2);
        System.out.println(node1);
        System.out.println(node0);
    }
}
