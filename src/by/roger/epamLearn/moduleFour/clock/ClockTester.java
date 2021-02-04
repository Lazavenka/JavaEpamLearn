package by.roger.epamLearn.moduleFour.clock;

public class ClockTester {
    public static void main(String[] args) {
        Clock rndClock =  new Clock();
        System.out.println("Random Clock: "+rndClock.toString());
        rndClock.setHours(15);
        rndClock.setMinutes(15);
        rndClock.setSeconds(15);
        System.out.println("Random clock Hours(15) Minutes(15) Seconds(15): "+rndClock.toString());
        rndClock.setTime(12,34,56);
        System.out.println("Random clock setTime: "+rndClock.toString());
        rndClock.setSeconds(99);
        System.out.println("Random clock setSeconds(99): "+rndClock.toString());
        Clock clock = new Clock(23, 59,55);

        for (int i = 0; i < 15; i++) {
            clock.runClock();
            System.out.println(clock.toString());
        }

    }
}