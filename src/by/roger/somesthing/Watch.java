package by.roger.somesthing;

import java.util.Scanner;

public class Watch {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Программа таймер. Используемые команды: /start, /stop, /time, /exit.");
        Timer timer = new Timer(10,10,10, "TimerOne");
        timer.mySuspend();
        while (!timer.getStopFlag()){
            input = scanner.nextLine();
            if(input.equals("/start")){
                timer.myResume();
                System.out.println("Таймер запущен ["+timer.toString()+"]");
                System.out.println();
            }
            if(input.equals("/stop")){
                System.out.println("Таймер остановлен ["+timer.toString()+"]");
                timer.mySuspend();
            }
            if (input.equals("/time")){
                System.out.println(timer.toString());
            }
            //Придумать как завершать поток в случае если таймер приостановлен
            if (input.equals("/exit")){
                timer.myResume();
                timer.setStopFlag(true);
                break;
            }
        }

    }
}
