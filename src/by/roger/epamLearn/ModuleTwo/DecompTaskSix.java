package by.roger.epamLearn.ModuleTwo;

import java.util.Random;
import java.util.Scanner;

/*
6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 */
public class DecompTaskSix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа определяет, являются ли 3 числа взаимно простыми." +
                " \nВыберите вариант выполнения программы: 1 - через случайный набор чисел, 2 - числа вводятся" +
                " вручную из консоли.");
        int choose = CustomArrays.inputChoose("Выберите вариант выполнения программы: ",2,in);
        int a;
        int b;
        int c;
        switch (choose){
            case 1:
                a = new Random().nextInt(1000);
                b = new Random().nextInt(1000);
                c = new Random().nextInt(1000);
                break;
            case 2:
                a = DecompositionUtils.inputNumber("Введите первое число:", in);
                b = DecompositionUtils.inputNumber("Введите второе число:", in);
                c = DecompositionUtils.inputNumber("Введите третье число:", in);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        System.out.printf("Введены следующие числа: %d, %d, %d.\n", a, b, c);
        String ans = (isCoPrime(a,b,c))?"Введенные числа являются взаимно простыми!":"Введенные числа не являются взаимно простыми!";
        System.out.println(ans);
    }
    private static boolean isCoPrime(int a, int b, int c){
        return gcdEvclidus(a, b) == 1 && gcdEvclidus(b, c) == 1 && gcdEvclidus(a, c) == 1;
    }
    private static int gcdEvclidus(int a, int b){
        while (a - b != 0){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        return a;
    }
}
