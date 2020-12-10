package by.roger.epamLearn.ModuleTwo;

import java.util.Random;

public class Dot {
    private int x;
    private int y;
    public Dot(){
        Random random = new Random();
        x = random.nextInt(20)-10;
        y = random.nextInt(20)-10;
    }
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dot dot = (Dot) o;

        if (x != dot.x) return false;
        return y == dot.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public double findDistance(Dot dot){
        int deltaX = x - dot.getX();
        int deltaY = y - dot.getY();
        return Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
    }

    @Override
    public String toString() {
        return "Координаты X = "+x+", Y = "+y+".";
    }
}
