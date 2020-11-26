package by.roger.epamLearn.moduleOne;
/*
Найти сумму квадратов первых ста чисел.
 */
public class CuclesTaskThree {
    public static void main(String[] args) {
        System.out.println("Я рассчитаю сумму квадратов первых ста чисел, хотите Вы этого или нет. Сами виноваты.");
        double ans = 0;
        for (int i = 0; i <=100 ; i++) {
            ans += Math.pow(i,2);
        }
        System.out.println("Сумма квадратов ста чисел равна " + ans);
    }
}
