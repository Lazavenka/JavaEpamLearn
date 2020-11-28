package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них.
 */
public class OneDimArrTaskNine {
    public static void main(String[] args) {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Программа находит наиболее часто встречающееся число. Если таких чисел несколько," +
                " то определяет наименьшее из них" +
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
                array = RandomArrays.oneDimArrayRandomFilling(size);
                break;
            case 2:
                array = new int[size];
                for (int i = 0; i < size; i++) {
                    System.out.println("Введите "+(i+1)+"е число массива: ");
                    while (!in.hasNextInt()) {
                        System.out.println("Не корректный ввод!");
                        in.next();
                    }
                    array[i]  = in.nextInt();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println(Arrays.toString(array));
        int ans;
        int count = 0;
        int[] counts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int k : array) {
                if (array[i] == k) count++;
            }
            counts[i] = count;
            count = 0;
        }
        //System.out.println(Arrays.toString(counts));
        int uniqueNumbers=0;
        for (int k : counts) {
            if (k == 1) {
                uniqueNumbers++;
            }
        }
        //System.out.println("unique "+uniqueNumbers);
        if(uniqueNumbers==counts.length){
            System.out.println("В массиве все числа уникальны");
        }else{
            int max=counts[0];
            int numMaxEntry=0;
            for (int j : counts) {
                if (j > max) {
                    max = j;
                }
            }
            for (int j : counts) {
                if (max == j) {
                    numMaxEntry++;
                }
            }
            int[] equalCountNumbers = new int[numMaxEntry];
            for (int idxINI = 0, idxQCN=0; idxINI < counts.length;idxINI++) {
                if(counts[idxINI]==max){
                    equalCountNumbers[idxQCN]=array[idxINI];
                    idxQCN++;
                }
            }
            //System.out.println(" equalCountNumbers "+Arrays.toString(equalCountNumbers));
            if (equalCountNumbers.length==1){
                System.out.println("Наиболее часто встречающееся число: "+equalCountNumbers[0]);
            }else {
                ans = equalCountNumbers[0];
                for (int equalCountNumber : equalCountNumbers) {
                    if (equalCountNumber < ans) {
                        ans = equalCountNumber;
                    }
                }
                System.out.println("Наиболее часто встречающееся число: "+ans);
            }
        }
    }
}
