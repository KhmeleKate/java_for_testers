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
        Triangle my_triangle = new Triangle(8,9,10);
        my_triangle.printPerimeter();
        my_triangle.printSquare();

    }

}
