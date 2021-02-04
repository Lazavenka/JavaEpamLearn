package by.roger.epamLearn.moduleFour.train;

import java.util.Arrays;
import java.util.Comparator;

public class TrainTester {
    public static void main(String[] args) {
        Comparator<Train> trainNumberComparator = new Comparator<>() {
            @Override
            public int compare(Train o1, Train o2) {
                Integer com = o1.getTrainNumber();
                Integer toCom = o2.getTrainNumber();
                return com.compareTo(toCom);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Comparator<Train> trainDestinationComparator = (o1, o2) -> {
            String dest1 = o1.getDestination();
            String dest2 = o2.getDestination();
            int sCom = dest1.compareTo(dest2);
            if(sCom !=0 ){
                return sCom;
            }
            Long time1 = o1.getDispatchTime().getTime();
            Long time2 = o2.getDispatchTime().getTime();
            return time1.compareTo(time2);
        };
        System.out.println("До сортировки.");
        Train[] trains = new Train[10];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = new Train();
        }
        trains[0].setDestination("Лукошки");
        trains[1].setDestination("Лукошки");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        Arrays.sort(trains, trainNumberComparator);
        System.out.println("Сортировка: Номер поезда.");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        Arrays.sort(trains, trainDestinationComparator);
        System.out.println("Сортировка: Станция отправления->Время отправления.");
        for (Train train : trains) {
            System.out.println(train.toString());
        }

    }
}

