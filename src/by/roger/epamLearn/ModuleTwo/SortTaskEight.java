package by.roger.epamLearn.ModuleTwo;
/*
Даны дроби ( pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.
 */
public class SortTaskEight {
    public static void main(String[] args) {
        FractionalNumber[] numbers = {new FractionalNumber(4, 12), new FractionalNumber(5, 2),
                new FractionalNumber(13, 3), new FractionalNumber(5, 4),
                new FractionalNumber(4, 5), new FractionalNumber(34, 6),
                new FractionalNumber(3, 21), new FractionalNumber(23, 4),
                new FractionalNumber(19, 18), new FractionalNumber(2, 12),};

        for (FractionalNumber a: numbers) {
            System.out.println(a.toString());
        }
        int commonDenom = findCommonDivider(numbers);
        setCommonDenominator(numbers, commonDenom);
        for (FractionalNumber a: numbers) {
            System.out.println(a.toString());
        }
    }
    private static int findCommonDivider(FractionalNumber[] numbers){
        int num = numbers[0].getDenom();
        for (FractionalNumber number : numbers) {
            num = (num * number.getDenom()) / gcd(num, number.getDenom());
        }
        //Алгоритм перебора.. дико долгий.
        /*
        while(!find){

            find = true;
            common++;
            for (FractionalNumber number : numbers) {
                if (common % number.getDenom() != 0) {
                    find = false;
                }
            }
        }
       */
        return num;
    }
    private static int gcd(int a, int b){
        //алгоритм Евклида
        while (a - b != 0){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        return a;
    }
    private static void setCommonDenominator(FractionalNumber[] numbers, int common){
        for (FractionalNumber number : numbers) {
            number.setNumber(number.getNumber() * common / number.getDenom());
            number.setDenom(common);
        }


    }

}
