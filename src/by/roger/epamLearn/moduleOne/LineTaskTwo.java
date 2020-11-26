package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*Вычислить значение выражения по формуле (все переменные принимают действительные значения):
        (𝑏 + √(𝑏^2 + 4𝑎𝑐))/2𝑎 − 𝑎^3𝑐 + 𝑏^−2
 */
public class LineTaskTwo {
    public static void main(String[] args) {
        System.out.println("The program solves the equation z = (\uD835\uDC4F + √(\uD835\uDC4F^2 + " +
                "4\uD835\uDC4E\uD835\uDC50))/2\uD835\uDC4E " +
                "− \uD835\uDC4E^3\uD835\uDC50 + \uD835\uDC4F^−2");
        Scanner in = new Scanner(System.in);
        System.out.println("Input \"a\"");
        double a = in.nextDouble();
        System.out.println("Input \"b\"");
        double b = in.nextDouble();
        System.out.println("Input \"c\"");
        double c = in.nextDouble();
        double temp = Math.pow(b, 2) + 4 * a * c;
        double z;
        if(temp > 0) {
            z = (b + Math.sqrt(temp)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
            System.out.printf("z = %.5f", z);
        }else {
            System.out.println("Incorrect input");
        }
    }
}
