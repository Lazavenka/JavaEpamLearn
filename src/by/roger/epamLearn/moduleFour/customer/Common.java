package by.roger.epamLearn.moduleFour.customer;

import java.util.Scanner;

public class Common {
    public static String readNotEmptyString(Scanner in){
        //in.next();
        String ans = in.nextLine();
        while (ans.isEmpty()){
            //System.out.println("Line is empty! Write right line!");
            ans = in.nextLine();
        }
        return ans;
    }
    public static int inputNumber(String comment, Scanner in, int border){
        int number;
        do {
            System.out.println(comment);
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextInt();
        }while(number<0||number>border);
        return number;
    }
    public static int inputNumber(Scanner in, int border){
        int number;
        do {
            while (!in.hasNextInt()) {
                System.out.println("Не корректный ввод!");
                in.next();
            }
            number = in.nextInt();
        }while(number<0||number>border);
        return number;
    }

}
