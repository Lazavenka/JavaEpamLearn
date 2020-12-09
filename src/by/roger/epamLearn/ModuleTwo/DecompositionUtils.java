package by.roger.epamLearn.ModuleTwo;

import java.util.Scanner;

public class DecompositionUtils {
    public static int inputNumber(String comment, Scanner in){
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextInt();
        }while(number<=0);
        return number;
    }
}
