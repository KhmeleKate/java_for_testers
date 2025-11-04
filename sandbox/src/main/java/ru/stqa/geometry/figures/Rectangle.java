package ru.stqa.geometry.figures;

import java.util.Objects;

public record Rectangle (double a, double b) {
    public Rectangle {
        if (a < 0 || b < 0){
            throw new IllegalArgumentException("Rectangle sides should be => 0");
        }
    }
    private double rectangleArea() {
        return this.a * this.b;
    }
    public void printRectangleArea() {
        var text = String.format("Площадь прямоугольника со сторонами %.2f и %.2f = %.2f", this.a, this.b, rectangleArea());
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                ||(Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.a, rectangle.b)==0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
