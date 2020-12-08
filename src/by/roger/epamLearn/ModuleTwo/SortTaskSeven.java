package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
7. Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an и b1<=b2<=...<=bm.
Требуется указать те места, на которые нужно вставлять элементы последовательности b1<=b2<=...<=bm в первую
последовательность так, чтобы новая последовательность оставалась возрастающей.
 */
public class SortTaskSeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа определяет массив позиций в массиве A на которые надо установить элементы массива B." +
                " \nВыберите вариант выполнения программы: 1 - через случайные массивы чисел, 2 - массивы вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int sizeFirst = CustomArrays.inputArraySize("Введите размерность первого массива: ", in);
        int sizeSecond = CustomArrays.inputArraySize("Введите размерность второго массива: ", in);
        int[] arrayOne;
        int[] arrayTwo;
        switch (choose){
            case 1:
                //Создаем рандомные последовательности и сортируем чтоб они были неубывающими.
                arrayOne = CustomArrays.oneDimArrayRandomFillingNeg(sizeFirst);
                arrayTwo = CustomArrays.oneDimArrayRandomFillingNeg(sizeSecond);
                Arrays.sort(arrayOne);
                Arrays.sort(arrayTwo);
                break;
            case 2:
                arrayOne = CustomArrays.inputArray(sizeFirst, in);
                arrayTwo = CustomArrays.inputArray(sizeSecond, in);
                //На всякий случай может ошиблись в вводе, принудительная сортировка.
                Arrays.sort(arrayOne);
                Arrays.sort(arrayTwo);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));
        int[] positions = findPositions(arrayOne,arrayTwo);
        System.out.println(Arrays.toString(positions));

    }
    public static int[] findPositions(int[] a, int[] b){
        int[] ans = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (b[i]<a[j+1]&&b[i]>=a[j]){
                    ans[i] = j+2;
                }
            }
        }
        return ans;
    }
}
