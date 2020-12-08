package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

/*
Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
положительных и нулевых элементов.
 */
public class OneDimArrTaskThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа подсчитывает количество отрицательных, положительных и нулевых элементов в массиве." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int size = CustomArrays.inputArraySize("Введите размерность массива: ", in);
        int[] array;
        switch (choose){
            case 1:
                array = CustomArrays.oneDimArrayRandomFillingNeg(size);
                break;
            case 2:
                array = CustomArrays.inputArray(size, in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        int neg = 0;
        int pos = 0;
        int zeros = 0;
        for (int j : array) {
            System.out.print(j + "\t");
            if (j > 0) {
                pos++;
            } else if (j < 0) {
                neg++;
            } else {
                zeros++;
            }

        }
        System.out.println("\nВ массиве " + pos + " положительных чисел, " + neg
                + " отрицательных чисел, и " + zeros + " нулей.");

    }

}
