package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea() {
        Triangle my_triangle = new Triangle(8, 9, 10);
        Assertions.assertEquals(25.0, Square.area(5.0));
        Assertions.assertEquals(34.20, my_triangle.Square());
    }
    @Test
    void canCalculatePerimeter() {
        Triangle my_triangle = new Triangle(8, 9, 10);
        Assertions.assertEquals(20, Square.perimeter(5.0));
        Assertions.assertEquals(27,  my_triangle.perimeter());
    }
}
