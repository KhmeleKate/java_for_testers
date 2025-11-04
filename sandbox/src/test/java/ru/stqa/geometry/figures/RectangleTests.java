package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {
    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle(9.0, 9);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
        }
    }
    @Test
    void testEquality() {
        var r1 = new Rectangle(5.0,4.0);
        var r2 = new Rectangle (5.0,4.0);
        Assertions.assertEquals(r1,r2);

    }
    @Test
    void testPass() {
        var r1 = new Rectangle(5.0,4.0);
        var r2 = new Rectangle (4.0,5.0);
        Assertions.assertTrue(r1.equals(r2));
    }

}
