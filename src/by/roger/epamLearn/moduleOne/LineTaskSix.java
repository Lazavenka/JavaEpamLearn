package by.roger.epamLearn.moduleOne;

import java.util.Scanner;

/*
 Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
принадлежит закрашенной области, и false — в противном случае: картинка.
 */
public class LineTaskSix {
    public static void main(String[] args) {
        System.out.println("The program determine if dot with coordinates (x, y) belongs to the area.");

        Scanner in = new Scanner(System.in);
        int x;
        System.out.println("Input x:");
        while (!in.hasNextInt()) {
            System.out.println("That's not a number!");
            in.next();
        }
        x = in.nextInt();
        int y;
        System.out.println("Input y:");
        while (!in.hasNextInt()) {
            System.out.println("That's not a number!");
            in.next();
        }
        y = in.nextInt();

        if (((x>=-4&&x<=4)&&(y>=-3&&y<=0))||((x>=-2&&x<=2)&&(y>=0&&y<=4))&&(x!=0&&y!=-1)){
            System.out.println("The dot with coordinates ("+x+", "+y+") belongs to the area."+"\n"+true);
        }else{
            System.out.println("The dot with coordinates ("+x+", "+y+") not belongs to the area."+"\n"+false);
        }
    }
}
