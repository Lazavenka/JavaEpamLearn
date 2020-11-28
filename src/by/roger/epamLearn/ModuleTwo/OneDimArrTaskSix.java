package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
являются простыми числами.
 */
public class OneDimArrTaskSix {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа вычисляет сумму чисел, порядковые номера которых являются простыми числами." +
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
                in.next();
            }
            size = in.nextInt();
        } while (size <= 0);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println(Arrays.toString(array));
        double ans = 0;
        Eratosfen primes = new Eratosfen(array.length);
        primes.fillSieve();
        for (int i = 0; i < array.length+1; i++) {
            if(primes.get(i)){
                ans+=array[i-1];
            }
        }
        System.out.println("Сумма чисел с простыми порядковыми номерами: "+ans);

    }
}
