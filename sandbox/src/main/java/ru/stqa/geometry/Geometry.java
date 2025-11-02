package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Triangle my_triangle = new Triangle(8,9,10);
        my_triangle.printPerimeter();
        my_triangle.printSquare();
        Square my_square = new Square(5.6);
        my_square.printPerimeter();
        my_square.printSquare();
        Rectangle my_rectangle = new Rectangle(3.5, 6.1);
        my_rectangle.printRectangleArea();


    }

}
