package ru.stqa.geometry.figures;
public record Square (double a) {
    public double perimeter() {
        return 4*this.a;
    }
    public void printPerimeter() {
        System.out.println(String.format("Периметр квадрата со стороной %.2f равен %.2f", this.a, perimeter()));
    }
    public double Square() {
        return this.a * this.a;
    }
    public void printSquare() {
        System.out.println(String.format("Площадь квадрата со стороной %.2f = %.2f",this.a, Square()));
    }
}
