package ru.stqa.geometry.figures;

public class Triangle {
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }
    public static void printPerimeter(double a, double b, double c){
        System.out.println(String.format("Периметр треугольника со сторонами %.2f, %.2f, %.2f равен %.2f", a, b, c, perimeter(a,b,c)));
    }
    public static double Square(double a, double b, double c){
        var pp = perimeter(a, b, c)/2;
        var almostSquare = pp*(pp-a)*(pp-b)*(pp-c);
        var S =  Math.sqrt(almostSquare);
        return Math.round(S*100.0)/100.0; /*; Добавила округление, чтобы в тесте не писать expected: 34.197039345533994*/
    }
    public static void printSquare(double a, double b, double c) {
    System.out.println(String.format("Площадь треугольника со сторонами %.2f, %.2f, %.2f равна %.2f", a, b, c, Square(a,b,c)));
    }
}
