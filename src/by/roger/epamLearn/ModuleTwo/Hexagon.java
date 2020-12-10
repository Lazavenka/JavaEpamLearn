package by.roger.epamLearn.ModuleTwo;

import java.util.Random;

/*
3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
 */
public class Hexagon {
    private final int length;

    public Hexagon(){
        Random random = new Random();
        length = random.nextInt(20);

    }
    public Hexagon(int l){
        length = l;
    }

    private double triangleSquare(){
        return Math.pow(this.length,2)*Math.sqrt(3)/4;
    }
    public double findSquare(){
        return 6*triangleSquare();
    }
    public int getLength(){
        return this.length;
    }

}
