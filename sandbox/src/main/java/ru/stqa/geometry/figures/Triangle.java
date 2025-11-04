package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle (double side_a, double side_b, double side_c) {
    public Triangle {
        if (side_a < 0 || side_b < 0 || side_c < 0){
            throw new IllegalArgumentException("Triangle sides should be => 0");
        }
        if ((side_a + side_b < side_c)||(side_b + side_c < side_a)||(side_c + side_a < side_b)){
            throw new IllegalArgumentException("The sum of any two sides must be no less than the third side");
        }
    }
    public double perimeter() {
        return this.side_a + this.side_b + this.side_c;
    }
    public void printPerimeter(){
        System.out.println(String.format("Периметр треугольника со сторонами %.2f, %.2f, %.2f равен %.2f",
                this.side_a, this.side_b, this.side_c, perimeter()));
    }
    public double Square(){
        var pp = perimeter()/2;
        var almostSquare = pp*(pp-side_a)*(pp-side_b)*(pp-side_c);
        var S =  Math.sqrt(almostSquare);
        return Math.round(S*100.0)/100.0; /*; Добавила округление, чтобы в тесте не писать expected: 34.197039345533994*/
    }
    public void printSquare() {
    System.out.println(String.format("Площадь треугольника со сторонами %.2f, %.2f, %.2f равна %.2f",
            this.side_a, this.side_b, side_c, Square()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.side_a, triangle.side_a) == 0 && Double.compare(this.side_b, triangle.side_b) == 0 && Double.compare(this.side_c, triangle.side_c) == 0)
        || (Double.compare(this.side_b, triangle.side_a) == 0 && Double.compare(this.side_a, triangle.side_b) == 0 && Double.compare(this.side_c, triangle.side_c) == 0)
        || (Double.compare(this.side_b, triangle.side_c) == 0 && Double.compare(this.side_a, triangle.side_b) == 0 && Double.compare(this.side_c, triangle.side_a) == 0)
        || (Double.compare(this.side_c, triangle.side_c) == 0 && Double.compare(this.side_a, triangle.side_b) == 0 && Double.compare(this.side_b, triangle.side_a) == 0)
        || (Double.compare(this.side_a, triangle.side_c) == 0 && Double.compare(this.side_b, triangle.side_a) == 0 && Double.compare(this.side_c, triangle.side_b) == 0)
        || (Double.compare(this.side_a, triangle.side_c) == 0 && Double.compare(this.side_c, triangle.side_a) == 0 && Double.compare(this.side_b, triangle.side_b) == 0)
        || (Double.compare(this.side_a, triangle.side_a) == 0 && Double.compare(this.side_b, triangle.side_c) == 0 && Double.compare(this.side_c, triangle.side_b) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
