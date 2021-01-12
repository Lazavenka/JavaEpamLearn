package by.roger.epamLearn.moduleFour;

public class Main {
    public static void main(String[] args) {
        //taskOne
        Test1 obj = new Test1( 5, 10);
        System.out.println(obj);
        int summ = obj.summVariables();
        System.out.println("Сумма переменных "+obj.getClass().getSimpleName()+" = "+summ);
        System.out.println("Наибольшее из переменных: "+obj.findMaxVars());
        //taskTwo
    }
}
