package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 */

public class LineTaskOne {
    public static void main(String[] args) {
        System.out.println("The program solves the equation z = ( (a – 3 ) * b / 2) + c");
        Scanner in = new Scanner(System.in);
        System.out.println("Input \"a\"");
        double a = in.nextInt();
        System.out.println("Input \"b\"");
        double b = in.nextInt();
        System.out.println("Input \"c\"");
        double c = in.nextInt();
        double z = ((a-3)*b/2) + c;
        System.out.printf("z = %.2f", z);
    }
}
