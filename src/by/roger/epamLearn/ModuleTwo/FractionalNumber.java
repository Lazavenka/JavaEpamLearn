package by.roger.epamLearn.ModuleTwo;

public class FractionalNumber {
    private int number;
    private int denom;

    public FractionalNumber(int number, int denom) {
        this.number = number;
        this.denom = denom;
    }
    public double toDouble(){
        return (double)number/denom;
    }
    public int getNumber() {
        return number;
    }

    public int getDenom() {
        return denom;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", number, denom);
    }

}
