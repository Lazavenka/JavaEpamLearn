package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai<=ai+1, то продвигаются
на один элемент вперед. Если ai>ai+1, то производится перестановка и сдвигаются на один элемент назад.
Составить алгоритм этой сортировки.
 */
public class SortTaskSix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа сортирует массив чисел методом сортировки обменом." +
                " \nВыберите вариант выполнения программы: 1 - через случайные массивы чисел, 2 - массивы вводятся" +
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
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println("Сортировка Шелла выполнена!");
        System.out.println(Arrays.toString(array));
    }
    private static void shellSort(int[] array){
        for (int j = 0; j < array.length-1; ) {
            if (array[j] <= array[j+1]) {
                if(j!=array.length) j++;
            }else{
                CustomArrays.swap(array,j,j+1);
                if(j!=0) j--;
            }
        }
    }
}
