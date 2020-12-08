package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;
import java.util.Scanner;

/*
Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */
public class OneDimArrTaskTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа сжимает массив, выбрасывая из него каждый второй элемент (освободившиеся " +
                "элементы заполняет нулями)." +
                " \nВыберите вариант выполнения программы: 1 - через случайный массив чисел, 2 - массив вводится" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int size = CustomArrays.inputArraySize("Введите размерность массива: ", in);
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
        for (int i = 0; i < array.length; i++) {
            for (int j=i+1;j<array.length-1;j++) {
                array[j] = array[j + 1];
            }
            array[array.length-1]=0;
        }
        System.out.println(Arrays.toString(array));
    }
}
