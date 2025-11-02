package ru.stqa.geometry.figures;
public record Triangle (double side_a, double side_b, double side_c) {
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
}
