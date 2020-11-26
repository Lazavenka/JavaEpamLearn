package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Найти max{min(a, b), min(c, d)}
 */
public class BranchingTaskTwo {
    public static void main(String[] args) {
        System.out.println("Программа определяет max{min(a, b), min(c, d)}");
        Scanner in = new Scanner(System.in);
        double a;
        System.out.println("Введите a:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        a = in.nextDouble();
        double b;
        System.out.println("Введите b:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        b = in.nextDouble();
        double c;
        System.out.println("Введите c:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        c = in.nextDouble();
        double d;
        System.out.println("Введите d:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        d = in.nextDouble();
        double tempMinAB;
        if(a<b){
            tempMinAB = a;
        }else tempMinAB = b;
        double tempMinCD;
        if (c<d){
            tempMinCD = c;
        }else tempMinCD = d;
        if (tempMinAB>tempMinCD){
            System.out.println("max{min(a, b), min(c, d)} = " + tempMinAB);
        } else System.out.println("max{min(a, b), min(c, d)} = "+ tempMinCD);
    }
}
