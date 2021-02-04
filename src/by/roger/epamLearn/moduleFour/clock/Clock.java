package by.roger.epamLearn.moduleFour.clock;
/*
Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут и секунд.
 */
import java.util.Random;

public class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    public Clock(){
        Random rnd = new Random();
        hours = rnd.nextInt(24);
        minutes = rnd.nextInt(60);
        seconds = rnd.nextInt(60);
    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public void setTime(int hours, int minutes, int seconds){
        if (hours >= 0 && hours <= 24) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
        if (minutes >= 0 && minutes <= 60) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
        if (seconds >= 0 && seconds <= 60) {
            this.seconds = seconds;
        } else {
            this.seconds = 0;
        }
    }
    public void setHours(int hours) {
        if (hours >= 0 && hours <= 24) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <= 24) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds <= 24) {
            this.seconds = seconds;
        } else {
            this.seconds = 0;
        }
    }
    public void runClock() {
        if (seconds + 1 < 60) {
            seconds++;
        } else {
            seconds = 0;
            if(minutes + 1 < 60){
                minutes++;
            }else{
                minutes = 0;
                if (hours + 1 < 24){
                    hours++;
                }else {
                    hours = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        String hours = String.format("%02d", this.hours);
        String minutes = String.format("%02d",this.minutes);
        String seconds = String.format("%02d",this.seconds);
        return "Текущее время: " + hours +
                ":" + minutes +
                ":" + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clock clock = (Clock) o;

        if (hours != clock.hours) return false;
        if (minutes != clock.minutes) return false;
        return seconds == clock.seconds;
    }

    @Override
    public int hashCode() {
        int result = hours;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        return result;
    }

}
