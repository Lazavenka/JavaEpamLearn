package by.roger.somesthing;

import java.util.Formatter;

public class Timer implements Runnable{
    private int hours;
    private int minutes;
    private int seconds;
    String name;
    Thread t;
    private boolean suspendFlag;
    private boolean stopFlag = false;

    public Timer(int hours, int minutes, int seconds, String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.start();
        suspendFlag = false;
        if(seconds>0&&seconds<60) {
            this.seconds = seconds;
        } else this.seconds = 0;
        if(minutes>0&&minutes<60) {
            this.minutes = minutes;
        } else this.minutes = 0;
        if(hours>0&&hours<24) {
            this.hours = hours;
        } else this.hours = 0;
    }
    public void timerRun(){
        if (seconds+1<60) {
            seconds++;
        }else{
            seconds = 0;
            if(minutes+1<60){
                minutes++;
            }else{
                minutes = 0;
                if (hours+1<24){
                    hours++;
                }else hours = 0;
            }
        }
    }
    synchronized public void mySuspend(){
        suspendFlag = true;
    }
    synchronized public void myResume(){
        suspendFlag = false;
        notify();
    }
    public void setStopFlag(boolean flag){
        stopFlag = flag;
    }
    public boolean getStopFlag(){
        return stopFlag;
    }
    public boolean isSuspendFlag() {
        return suspendFlag;
    }
    @Override
    public void run() {
        System.out.printf("Timer is start at %02d:%02d:%02d\n", hours,minutes,seconds);
        try {
            while (!stopFlag) {
                timerRun();
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }

            }
        }catch (InterruptedException e){
            System.err.println(e);
        }

    }

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        return fmt.format("Time: %02d:%02d:%02d", hours,minutes,seconds).toString();

    }
}
