package by.roger.epamLearn.moduleOne;
/*
Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
        данное значение длительности в часах, минутах и секундах в следующей форме:
        ННч ММмин SSc.
 */

import java.util.Scanner;

public class LineTaskFive {
    public static void main(String[] args) {
        System.out.println("The program calculates the number of hours minutes and seconds in T seconds.");
        Scanner in = new Scanner(System.in);
        int seconds;
        do {
            System.out.println("Input seconds count:");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                in.next(); // this is important!
            }
            seconds = in.nextInt();
        } while (seconds <= 0);
        int hours = seconds/3600;
        int minutes = (seconds%3600)/60;
        System.out.println(seconds+" секунд составляют: "+hours+" часов "+minutes +" минут "
                +(seconds - minutes*60 - hours*3600) +" секунд."); // Можно подкорректировать вывод.

    }
}
