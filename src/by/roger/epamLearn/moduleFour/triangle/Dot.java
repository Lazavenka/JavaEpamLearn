package by.roger.epamLearn.moduleFour.triangle;

import java.util.ArrayList;
import java.util.Random;

public class Dot {
    private double x;
    private double y;
    public Dot(){
        Random random = new Random();
        x = random.nextInt(20)-10;
        y = random.nextInt(20)-10;
    }
    public Dot(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String xToString = String.format("%.2f", x);
        String yToString = String.format("%.2f", y);
        return "Dot{" +
                "x=" +xToString +
                ", y=" + yToString +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot dot = (Dot) o;

        if (Double.compare(dot.x, x) != 0) return false;
        return Double.compare(dot.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double findDistance(Dot dot){
        double deltaX = x - dot.getX();
        double deltaY = y - dot.getY();
        return Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
    }
    public void printDot(){
        System.out.println("Координаты X = "+x+", Y = "+y+".");
    }
    public void findMaxDistanceDots(ArrayList<Dot> dots){
        double distance;
        double maxDistance = 0;
        int indexDotOne=0;
        int indexDotTwo=0;
        for (int i = 0; i < dots.size(); i++) {
            for (int j = i+1; j < dots.size(); j++) {
                distance = dots.get(i).findDistance(dots.get(j));
                if (distance > maxDistance){
                    maxDistance = distance;
                    indexDotOne = i;
                    indexDotTwo = j;
                }
            }
        }
        System.out.println("Максимальное расстояние "+maxDistance+" между точками:");
        System.out.print((indexDotOne+1)+". ");
        dots.get(indexDotOne).printDot();
        System.out.print((indexDotTwo+1)+". ");
        dots.get(indexDotTwo).printDot();

    }

}
