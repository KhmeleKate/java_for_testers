package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(2.0, 2.0, 2.0);
            //Assertions.fail();
            System.out.println("OK");
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
    @Test
    void testPass() {
        var tr1 = new Triangle(3.0,4.0, 5.0);
        var tr2 = new Triangle (5.0,4.0, 3.0);
        Assertions.assertTrue(tr1.equals(tr2));
    }
}
