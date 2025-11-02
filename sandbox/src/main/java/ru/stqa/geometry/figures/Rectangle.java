package ru.stqa.geometry.figures;
public record Rectangle (double a, double b) {
    private double rectangleArea() {
        return this.a * this.b;
    }
    public void printRectangleArea() {
        var text = String.format("Площадь прямоугольника со сторонами %.2f и %.2f = %.2f", this.a, this.b, rectangleArea());
        System.out.println(text);
    }
}
