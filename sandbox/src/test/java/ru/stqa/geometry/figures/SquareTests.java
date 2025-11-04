package ru.stqa.geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea() {
        Triangle my_triangle = new Triangle(8, 9, 10);
        Assertions.assertEquals(34.20, my_triangle.Square());
        Square my_square = new Square(3);
        Assertions.assertEquals(9.0, my_square.Area());
    }
    @Test
    void canCalculatePerimeter() {
        Triangle my_triangle = new Triangle(8, 9, 10);
        Square my_square = new Square(6);
       Assertions.assertEquals(24, my_square.perimeter());
       Assertions.assertEquals(27,  my_triangle.perimeter());
    }
    @Test
    void cannotCreateSquareWithNegativeSide() {
        try {
            new Square(-6.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
    }
    }
    @Test
    void testEquality() {
        var s1 = new Square(5.0);
        var s2 = new Square (5.0);
        Assertions.assertEquals(s1,s2);
    }
    @Test
    void testPass() {
        var s1 = new Square(5.0);
        var s2 = new Square (5.0);
        Assertions.assertTrue(s1.equals(s2));
}
}
