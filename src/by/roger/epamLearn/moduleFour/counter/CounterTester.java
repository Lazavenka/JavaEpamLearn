package by.roger.epamLearn.moduleFour.counter;

public class CounterTester {
    public static void main(String[] args) {
        Counter counter1 = new Counter(99,16,4);
        System.out.println(counter1.currentState());
        while(counter1.getError()==null){
            counter1.increaseValue();
            System.out.println(counter1.currentState());
        }


    }
}
