package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea() {
        Assertions.assertEquals(25.0, Square.area(5.0));
        Assertions.assertEquals(34.20, Triangle.Square(8,9,10));
    }
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20, Square.perimeter(5.0));
        Assertions.assertEquals(27, Triangle.perimeter(8, 9, 10));
    }
}
