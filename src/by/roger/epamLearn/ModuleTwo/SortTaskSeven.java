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
        int[] newArray = arrayOne;
        for (int k : arrayTwo) {
            int[] tempArray = new int[newArray.length + 1];
            int position = binarySearch(newArray, k);
            for (int j = 0; j < tempArray.length; j++) {
                if (j < position) {
                    tempArray[j] = newArray[j];
                } else if (j == position) {
                    tempArray[j] = k;
                } else {
                    tempArray[j] = newArray[j - 1];
                }
            }
            newArray = tempArray;
            System.out.printf("Элемент %d был вставлен в позицию %d", k, position);
            System.out.println("\nНовый массив:");
            System.out.println(Arrays.toString(newArray));
        }


    }
    private static int binarySearch(int[] array, int number){
        int firstIndex = 0;
        int lastIndex = array.length-1;
        int midIndex = 0;
        while (firstIndex<=lastIndex){
            midIndex = (firstIndex + lastIndex) / 2;
            if (array[midIndex]==number){
                return midIndex;
            }else if (array[midIndex]<number){
                firstIndex = midIndex + 1;
            }else if (array[midIndex] > number && midIndex != 0 && !(array[midIndex - 1] < number)){
                lastIndex = midIndex - 1;
            }else{
                break;
            }
        }
        return midIndex;
    }
}
