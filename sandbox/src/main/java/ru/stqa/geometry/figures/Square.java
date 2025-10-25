package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side) {
        System.out.println(String.format("Площадь квадрата со стороной %.2f = %.2f",side,squareArea(side)));
    }
    static double squareArea(double a) {
        return a * a;
    }
}
