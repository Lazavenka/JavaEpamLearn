package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class OneDimArrTaskOne {
    public static void main(String[] args) {
        //Можно с вариантом где массив задается вручную, но проще через рандом
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа рассчитывает сумму элементов массива натуральных чисел, которые кратны данному К." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        System.out.println("Выберите вариант выполнения программы: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next();
            }
        choose = in.nextInt();

        int size;
        do {
            System.out.println("Введите размерность массива: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next(); // this is important!
            }
            size = in.nextInt();
        } while (size <= 0);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
         
        int ans = 0;
        int k;
        do {
            System.out.println("Введите K: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            k = in.nextInt();
        } while (k <= 0);

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
            if (array[i] % k == 0) {
                System.out.print("(кратно " + k + ") ");
                ans += array[i];
            }
        }
        System.out.println("Сумма элементов массива кратных " + k + " равна:" + ans);
    }
}
