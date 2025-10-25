public class Geometry {
    public static void main(String[] args) {
        printSquareArea(3.0);
        printSquareArea(5.0);
        printTriangleArea(3.0, 5.0);
        printTriangleArea(7.0, 6.0 );

    }

    private static void printTriangleArea(double a, double b) {
        System.out.println("Площадь треугольника со сторонами " + a + " и " + b + " = " + rectangleArea(a,b));
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    private static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }

    static double squareArea(double a) {
        return a * a;
    }

}
