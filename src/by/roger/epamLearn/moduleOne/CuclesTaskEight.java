package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */
public class CuclesTaskEight {
    public static void main(String[] args) {
        System.out.println("Программа определяет цифры, входящие в запись как первого так и второго числа." +
                " Цифры вводятся с клавиатуры.");
        Scanner in = new Scanner(System.in);

        double a;
        System.out.println("Введите первое число:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        a = in.nextDouble();

        double b;
        System.out.println("Введите второе число:");
        while (!in.hasNextDouble()) {
            System.out.println("Неправильный ввод! Введите число формата ххх,ххх!");
            in.next();
        }
        b = in.nextDouble();
        // Посимвольная проверка числа в виде строки на наличие общих цифр.
        String stringA = Double.toString(a);
        String stringB = Double.toString(b);
        int count = 0;
        System.out.print("В числах "+stringA + " и "+ stringB+" общие цифры: ");
        for (int i = 48; i < 58; i++) {
            if(stringA.indexOf((char)i)!=-1&&stringB.indexOf((char)i)!=-1){
                count++;
                System.out.print((char)i+"\t");
            }
        }
        if (count==0){
            System.out.println("не обнаружены.");
        }
    }
}
