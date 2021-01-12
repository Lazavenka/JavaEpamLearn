package by.roger.epamLearn.moduleFour;

import java.util.Scanner;

public class Common {
    public static String readNotEmptyString(Scanner in){
        //in.next();
        String ans = in.nextLine();
        while (ans.isEmpty()){
            //System.out.println("Line is empty! Write right line!");
            ans = in.nextLine();
        }
        return ans;
    }
}
