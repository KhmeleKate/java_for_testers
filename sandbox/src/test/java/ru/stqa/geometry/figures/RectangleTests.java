package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {
    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle(-6.0, 9);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
        }
    }
}
