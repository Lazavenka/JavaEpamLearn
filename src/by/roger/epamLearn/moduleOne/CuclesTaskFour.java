package by.roger.epamLearn.moduleOne;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
Составить программу нахождения произведения квадратов первых двухсот чисел
 */
public class CuclesTaskFour {
    public static void main(String[] args) {
        System.out.println("Я рассчитаю ПРОИЗВЕДЕНИЕ квадратов первых двухсот чисел, хотите Вы этого или нет. " +
                "Сами виноваты.");
        BigInteger ans = new BigInteger("1");
        for (int i = 1; i <=200 ; i++) {
            ans = ans.multiply(BigInteger.valueOf((long) i * i));
        }
        System.out.println("ПРОИЗВЕДЕНИЕ квадратов двухсот чисел равна " + ans);

    }
}
