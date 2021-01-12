package by.roger.epamLearn.moduleFour;

import java.util.Random;

public class Test2 {

    private int variableOne;
    private int variableTwo;

    public Test2(int variableOne, int variableTwo) {
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
    }

    public Test2() {
        variableOne = new Random().nextInt(100);
        variableTwo = new Random().nextInt(100);
    }

    public int getVariableOne() {
        return variableOne;
    }

    public void setVariableOne(int variableOne) {
        this.variableOne = variableOne;
    }

    public int getVariableTwo() {
        return variableTwo;
    }

    public void setVariableTwo(int variableTwo) {
        this.variableTwo = variableTwo;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "variableOne=" + variableOne +
                ", variableTwo=" + variableTwo +
                '}';
    }
}
