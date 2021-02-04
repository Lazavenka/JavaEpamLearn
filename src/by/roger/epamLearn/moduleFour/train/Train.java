package by.roger.epamLearn.moduleFour.train;

import java.sql.Time;
import java.util.Random;

public class Train implements Comparable<Train> {
    private String destination;
    private int trainNumber;
    private Time dispatchTime;

    public Train(String destination, int trainNumber, Time dispatchTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.dispatchTime = dispatchTime;
    }
    public Train(){
        destination = destinationGenerator();
        trainNumber = numberGenerator();
        dispatchTime = dispatchTimeGenerator();
    }

    private String destinationGenerator(){
        StringBuilder sb = new StringBuilder();
        String[] prefix = {"Бе", "Ля","У","Ту" ,"Па" , "Е","Во" ,"Ку" , "Жда", "Бе","Му" ,"Ле"};
        String[] root = {"резов", "кан","зов" , "гов", "гор", "чмов","нов","кор" ,"сук" ,"шко" , "чкав", "коч","выр" ,"левск" , "кон", "чен",};
        String[] postfix = {"ко", "ва","ки","ов","ка",""};

        sb.append(prefix[new Random().nextInt(prefix.length)]);
        sb.append(root[new Random().nextInt(root.length)]);
        sb.append(postfix[new Random().nextInt(postfix.length)]);

        return sb.toString();
    }
    private int numberGenerator(){
        return new Random().nextInt(1000);
    }
    private Time dispatchTimeGenerator(){
        long time = new Random().nextLong() + 900000000;
        return new Time(time);
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Time getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Time dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public static void printTrainInfo(Train[] trains, int number){
        for (Train train: trains) {
            if(number==train.getTrainNumber()){
                System.out.println("Поезд номер "+train.getTrainNumber()+" отправляется в "+train.getDispatchTime().toString()+
                        " до станции " +train.getDestination());
            }else {
                System.out.println("Поезд с номером "+number+" не найден.");
            }

        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (trainNumber != train.trainNumber) return false;
        if (destination != null ? !destination.equals(train.destination) : train.destination != null) return false;
        return dispatchTime != null ? dispatchTime.equals(train.dispatchTime) : train.dispatchTime == null;
    }

    @Override
    public int hashCode() {
        int result = destination != null ? destination.hashCode() : 0;
        result = 31 * result + trainNumber;
        result = 31 * result + (dispatchTime != null ? dispatchTime.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Train o) {
        Integer com = trainNumber;
        Integer toCom = o.getTrainNumber();
        return com.compareTo(toCom);
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNumber=" + trainNumber +
                ", dispatchTime=" + dispatchTime +
                '}';
    }
}