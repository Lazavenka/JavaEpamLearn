package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */
public class CuclesTaskSix {
    public static void main(String[] args) {
        System.out.println("Программа выведет на экран соответствия между символами и их " +
                "численными обозначениями в памяти компьютера ");
        Scanner in = new Scanner(System.in);
        int borderOne;
        System.out.println("Введите левую границу желаемого диапазона численных ободначений. ");
        do {
            System.out.println("Введите положительное целое число в диапазоне от 0 до 65536 : ");
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            borderOne = in.nextInt();
        } while (borderOne <= 0);
        int borderTwo;
        System.out.println("Введите правую границу желаемого диапазона численных ободначений. ");
        do {
            System.out.println("Введите положительное целое число в диапазоне от 0 до 65536 : ");
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
        for (int i = borderOne; i <= borderTwo; i++) {
            char c = (char) i;
            System.out.println("Символ для "+i+" - "+c);
        }

    }
}
