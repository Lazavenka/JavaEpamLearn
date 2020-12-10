package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
Задание выполнено при помощи класса Hexagon.java
 */
public class DecompTaskThree {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа вычисляет площадь правильного шестиугольника со стороной a." +
                " \nВыберите вариант выполнения программы: 1 - сторона a выбирается случайно, 2 - a вводится" +
                " вручную из консоли.");
        choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        Hexagon hexagon;
        switch (choose){
            case 1:
                hexagon = new Hexagon();
                break;
            case 2:
                int length = CustomArrays.inputArraySize("Введите длину стороны а: ", in);
                hexagon = new Hexagon(length);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        double square = hexagon.findSquare();
        System.out.printf("Правильный шестиугольник со стороной a = %d имеет площадь %.3f.", hexagon.getLength(), square);
    }
}
