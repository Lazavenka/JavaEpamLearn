package by.roger.epamLearn.ModuleTwo;
/*
Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен.
 */
import java.util.Arrays;
import java.util.Scanner;

public class OneDimArrTaskTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа заменяет в массиве чисел те члены которые больше заданного Z." +
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
        int z;
        System.out.println("Введите Z: ");
        while (!in.hasNextInt()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        z = in.nextInt();
        int countRepls = 0;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = z;
                countRepls++;
            }
        }
        System.out.println("Количество замен: "+countRepls);
        System.out.println(Arrays.toString(array));
    }

}
