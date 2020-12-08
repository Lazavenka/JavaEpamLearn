package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Сортировка вставками. Дана последовательность чисел a1,a2,...,an. Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть a1,a2,...,an - упорядоченная последовательность, т. е.
a1<=a2<=...<=an. Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */
public class SortTaskFive {
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
        insertionSort(array);
        System.out.println("Сортировка выполнена!");
        System.out.println(Arrays.toString(array));

    }
    private static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int idxBinary = binarySearch(array, key, i);
            if (i - idxBinary >= 0) System.arraycopy(array, idxBinary, array, idxBinary + 1, i - idxBinary);
            array[idxBinary]=key;
        }
    }

    private static int binarySearch(int[] array, int elementToSearch, int lastIndex) {
        int firstIndex = 0;
        while(firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] < elementToSearch)
            {
                firstIndex = middleIndex + 1;
            }
            else {
                lastIndex = middleIndex;
            }
        }
        return lastIndex;
    }
}
