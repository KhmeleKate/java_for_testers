package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(2.0, 2.0, 2.0);
            Assertions.fail();
            //System.out.println("OK");
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
