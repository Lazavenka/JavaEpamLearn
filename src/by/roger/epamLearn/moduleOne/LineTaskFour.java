package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
дробную и целую части числа и вывести полученное значение числа.
 */
public class LineTaskFour {
    public static void main(String[] args) {
        System.out.println("The program makes swap of number parts according to principle: nnn.ddd -> ddd.nnn");
        System.out.println("Input number nnn.ddd:");
        Scanner in = new Scanner(System.in);
        double number;
        do {
            while (!in.hasNextDouble()) {
                System.out.println("That's not a number!");
                in.next(); // this is important!
            }
            number = in.nextDouble();
        } while (number <= 0);
        double answer = (number * 1000) % 1000 + (int) number / 1000.0;
        System.out.printf("z = %.3f", answer);
    }
}
