package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
Вычислить значение выражения по формуле (все переменные принимают действительные значения):
(𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦)/(𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦) ∗ 𝑡𝑔 𝑥𝑦
 */
public class LineTaskThree {
    public static void main(String[] args) {
        System.out.println("The program solves the equation z = (sin x + cos x)/(cos x - sin x) * tg xy");
        Scanner in = new Scanner(System.in);
        System.out.println("Input \"x\"");
        double x = in.nextDouble();
        System.out.println("Input \"y\"");
        double y = in.nextDouble();
        double z = (Math.sin(x)+Math.cos(y))/(Math.cos(x)-Math.sin(y))*Math.tan(x*y);
        System.out.printf("z = %.5f", z);
    }
}
