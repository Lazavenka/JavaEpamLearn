package by.roger.epamLearn.moduleFour.triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle abc = new Triangle();
        abc.printTriangle();
        double perim = abc.findPerimeter();
        double square = abc.findSquare();
        String perimFormat = String.format("%.2f", perim);
        String squareFormat = String.format("%.2f", square);
        System.out.println("Периметр - "+perimFormat);
        System.out.println("Площадь - "+squareFormat);
        System.out.println("Точка пересечения медиан - "+abc.findMedianCross().toString());
    }
}