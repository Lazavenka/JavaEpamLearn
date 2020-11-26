package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
 */
public class CuclesTaskSeven {
    public static void main(String[] args) {
        System.out.println("Программа находит все делители для натуральных чисел из диапазона [m, n]." +
                " Границы диапазона m и n вводятся с клавиатуры.");
        Scanner in = new Scanner(System.in);
        int borderOne;
        do {
            System.out.println("Введите положительное целое число m: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            borderOne = in.nextInt();
        } while (borderOne <= 0);
        int borderTwo;
        do {
            System.out.println("Введите положительное целое число n: ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            borderTwo = in.nextInt();
        } while (borderTwo <= 0);
        if(borderOne>borderTwo){
            System.out.println("Границы были перепутаны, я их поменяю местами.");
            int temp = borderOne;
            borderOne = borderTwo;
            borderTwo = temp;
        }
        for (int i = borderOne; i <= borderTwo ; i++) {
            System.out.print("Число "+i+ " имеет делители: 1,");
            for (int j = 2; j <= (i/2); j++) {
                if (i%j==0){
                    System.out.print(" "+j+",");
                }
            }
            System.out.print(" "+i+".\n");
        }
    }
}
