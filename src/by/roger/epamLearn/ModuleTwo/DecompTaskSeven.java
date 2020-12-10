package by.roger.epamLearn.ModuleTwo;
/*
7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */
public class DecompTaskSeven {
    public static void main(String[] args) {
        System.out.println("Программа вычисляет сумму факториалов всех нечетных чисел от 1 до 9");
        long ans = 0;
        for (int i = 1; i < 10; i++) {
            if (isOdd(i)) {
                long fact = factorial(i);
                System.out.println(i+"! = "+fact);
                ans += fact;
            }
        }
        System.out.println("Сумма факториалов = "+ans);
    }

    private static long factorial(int number){
        long ans = 1;
        for (int i = 1; i < number+1; i++) {
            ans*=i;
        }
        return ans;
    }
    private static boolean isOdd(int number){
        return number % 2 == 1;
    }
}
