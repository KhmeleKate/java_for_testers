package ru.stqa.geometry.figures;
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
}
