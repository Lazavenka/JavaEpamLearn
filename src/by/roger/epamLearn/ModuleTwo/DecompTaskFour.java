package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */
public class DecompTaskFour {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа вычисляет между какими из пар точек самое большое расстояние. " +
                "Точка является объектом с двумя координатами." +
                " \nВыберите вариант выполнения программы: 1 - координаты инициализируются случайно, 2 - координаты вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int count = DecompositionUtils.inputNumber("Введите количество точек для поиска максимальной дистанции: ", in);
        Dot[] dots = new Dot[count];
        switch (choose){
            case 1:
                for (int i = 0; i < dots.length; i++) {
                    dots[i] = new Dot();
                }
                break;
            case 2:
                for (int i = 0; i < dots.length; i++) {
                    String comment = "Введите координату X точки "+(i+1);
                    int x = DecompositionUtils.inputNumberNeg(comment, in);
                    comment = "Введите координату Y точки "+(i+1);
                    int y = DecompositionUtils.inputNumberNeg(comment, in);
                    dots[i] = new Dot(x,y);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println("Введен массив точек: ");
        System.out.println("-------------------------------------");
        printDots(dots);
        System.out.println("-------------------------------------");
        findMaxDistanceDots(dots);
    }
    public static void findMaxDistanceDots(Dot[] dots){
        double distance;
        double maxDistance = 0;
        int indexDotOne=0;
        int indexDotTwo=0;
        for (int i = 0; i < dots.length; i++) {
            for (int j = i+1; j < dots.length; j++) {
                distance = dots[i].findDistance(dots[j]);
                if (distance > maxDistance){
                    maxDistance = distance;
                    indexDotOne = i;
                    indexDotTwo = j;
                }
            }
        }
        System.out.printf("Максимальное расстояние %.3f между точками:\n", maxDistance);
        System.out.println((indexDotOne+1)+". "+dots[indexDotOne].toString());
        System.out.println((indexDotTwo+1)+". "+dots[indexDotTwo].toString());
    }
    private static void printDots(Dot[] dots){
        for (int i = 0; i < dots.length; i++) {
            System.out.println("Точка "+(i+1)+": "+dots[i].toString());
        }
    }
}
