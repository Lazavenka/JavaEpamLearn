package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Вычислить значения функции на отрезке [а,b] c шагом h:
 */
public class CuclesTaskTwo {
    public static void main(String[] args) {
        System.out.println("Программа вычисляет значения функции на отрезке [а,b] c шагом h, " +
                "по функции с условием от значения Х");
        Scanner in = new Scanner(System.in);
        double a;
        System.out.println("Введите левую границу интервала a: ");
        while (!in.hasNextDouble()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        a = in.nextDouble();
        double b;
        System.out.println("Введите правую границу интервала b: ");
        while (!in.hasNextDouble()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        b = in.nextDouble();
        double h;
        System.out.println("Введите шаг h: ");
        while (!in.hasNextDouble()) {
            System.out.println("Не корректный ввод!");
            in.next(); // this is important!
        }
        h = in.nextDouble();
        if(a>b){
            System.out.println("Границы были перепутаны, я их поменяю местами.");
            double temp = a;
            a = b;
            b = temp;
        }
        double x = a;
        while(x>=a&&x<=b){
            if(x<=2){
                System.out.printf("y = %.2f\n",(-x));
            }else {
                System.out.printf("y = %.2f\n", x);
            }
            x+=h;
        }
    }
}
