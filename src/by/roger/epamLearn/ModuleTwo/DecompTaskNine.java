package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой.
 */
public class DecompTaskNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа определяет площадь четырехугольника со сторонами X, Y, Z, Т." +
                " \nВыберите вариант выполнения программы: 1 - через случайный набор чисел, 2 - стороны вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        double x;
        double y;
        double z;
        double t;
        switch (choose){
            case 1:
                x = new Random().nextDouble()*1000;
                y = new Random().nextDouble()*1000;
                z = new Random().nextDouble()*1000;
                t = new Random().nextDouble()*1000;
                break;
            case 2:
                x = DecompositionUtils.inputNumberDouble("Введите сторону X:", in);
                y = DecompositionUtils.inputNumberDouble("Введите сторону Y:", in);
                z = DecompositionUtils.inputNumberDouble("Введите сторону Z:", in);
                t = DecompositionUtils.inputNumberDouble("Введите сторону T:", in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.printf("Четырехугольник имеет стороны a = %.3f, b = %.3f, c = %.3f, d = %.3f.\n", x, y, z, t);
        double square = square(x,y,z,t);
        System.out.printf("Площадь четырехугольника %.3f.", square);

    }
    private static double findHypotenuse(double x, double y){
        //Поиск диагонали по теореме Пифагора. Четырехугольник делится на прямоугольный треугольник и случ. треугольник.
        return Math.sqrt(x*x+y*y);
    }
    private static double findRightTriangleSq(double x, double y){
        //Площадь прямоугольного треугольника.
        return x*y/2;
    }
    private static double findRndTriSq(double a, double b, double c){
        //Площадь треугольника через 3 стороны по формуле Герона
        double poluperimeter = (a+b+c)/2;
        return Math.sqrt(poluperimeter*(poluperimeter-a)*(poluperimeter-b)*(poluperimeter-c));
    }
    public static double square(double x, double y, double z, double t){
        return findRightTriangleSq(x,y) + findRndTriSq(findHypotenuse(x,y),z,t);
    }
}
