package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой
С использованием пользовательского класса точка. Поля класса - int x, int y.
 */
public class BranchingTaskThree {
    public static void main(String[] args) {
        System.out.println("Программа проверяет находятся ли три точки на одной прямой. " +
                "Пожалуйста, введите координаты точек на двумерной плоскости.");
        Scanner in = new Scanner(System.in);
        Dot[] dots = new Dot[3];
        for (int i = 0; i < dots.length; i++) {
            System.out.println("Введите координаты точки "+(i+1));
            double x;
            System.out.println("Введите координату x точки "+(i+1));
            while (!in.hasNextDouble()) {
                System.out.println("That's not a number!");
                in.next();
            }
            x = in.nextDouble();
            double y;
            System.out.println("Введите координату y точки "+(i+1));
            while (!in.hasNextDouble()) {
                System.out.println("That's not a number!");
                in.next();
            }
            y = in.nextDouble();

            dots[i] = new Dot(x,y);
        }
        double deltaX1 = dots[1].getX() - dots[0].getX();
        double deltaX2 = dots[2].getX() - dots[1].getX();
        double deltaY1 = dots[1].getY() - dots[0].getY();
        double deltaY2 = dots[2].getY() - dots[1].getY();
        if ((deltaX1 != 0 || deltaY1 != 0) && (deltaX2 != 0 || deltaY2 != 0)) {
            if ((deltaY1 / deltaX1) == (deltaY2 / deltaX2)) {
                System.out.println("Точки находятся на одной прямой!");
            } else {
                System.out.println("Точки не находятся на одной прямой. :(");
            }
        } else {
            System.out.println("Как удачно совпало что точки имеют одинаковые координаты...");
        }
    }
}
