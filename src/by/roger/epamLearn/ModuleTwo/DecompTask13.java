package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
Для решения задачи использовать декомпозицию.
 */
public class DecompTask13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа выполняет поиск простых чисел \"близнецов\" из отрезка [n, 2n], то есть таких " +
                "двух простых чисел, которые отличаются друг от друга на 2. \nВыберите вариант выполнения программы: " +
                "1 - N генерируется случайно, 2 - N вводится вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int n;
        switch (choose){
            case 1:
                n = new Random().nextInt(5000);
                System.out.printf("Сгенерирован отрезок чисел [%d, %d]\n", n, (2*n));
                break;
            case 2:
                n =  DecompositionUtils.inputNumber("Введите число n:", in);
                System.out.printf("Сгенерирован отрезок чисел [%d, %d]\n", n, (2*n));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        geminiNumbers(n);
    }
    private static boolean isPrime(int n){
        boolean ans = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return ans;
    }
    public static void geminiNumbers(int n){
        for (int i = n; i < 2*n; i++) {
            if (isPrime(i)&&isPrime(i+2)){
                System.out.println("Найдены близнецы: " + i + " и "+ (i+2)+".");
            }
        }
    }
}
