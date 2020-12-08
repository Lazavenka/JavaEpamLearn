package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
2. Даны две последовательности a1<=a2<=...<=an и b1<=b2<=...<=bn . Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */
public class SortTaskTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа объединяет две неубывающих последовательности в новую неубывающую последовательность." +
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
        int[] arrayAns = mergeArrays(arrayOne, arrayTwo);
        System.out.println(Arrays.toString(arrayAns));
    }
    private static int[] mergeArrays(int[] arrayA, int[] arrayB){
        int[] ans = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < ans.length; i++) {
            if (i< arrayA.length){
                ans[i] = arrayA[i];
            }else {
                ans[i] = arrayB[i - arrayA.length];
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
