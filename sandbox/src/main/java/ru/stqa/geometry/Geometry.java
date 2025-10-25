package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(3.0);
        Square.printSquareArea(5.0);
        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 6.0 );
        Triangle.printPerimeter(8,9,10);
        Triangle.printSquare(12,13,2);

    }

}
