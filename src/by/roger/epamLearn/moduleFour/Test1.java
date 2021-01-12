package by.roger.epamLearn.moduleFour;

public class Test1 {
    private int variableOne;
    private int variableTwo;

    public Test1(int variableOne, int variableTwo) {
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
    }

    public Test1() {
    }

    public int getVariableOne() {
        return variableOne;
    }

    public int getVariableTwo() {
        return variableTwo;
    }

    public void setVariableOne(int variableOne) {
        this.variableOne = variableOne;
    }

    public void setVariableTwo(int variableTwo) {
        this.variableTwo = variableTwo;
    }
    public int summVariables(){
        return variableOne+variableTwo;
    }
    public int findMaxVars() {
        return Math.max(variableOne, variableTwo);
    }
    @Override
    public String toString() {
        return "Test1{" +
                "variableOne=" + variableOne +
                ", variableTwo=" + variableTwo +
                '}';
    }
}
