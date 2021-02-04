package by.roger.epamLearn.moduleFour.counter;

public class Counter {
    private int currentValue;
    private int minValue;
    private int maxValue;
    private String error;
    public Counter(){
        currentValue = 0;
        minValue = 0;
        maxValue = 10;
    }
    public Counter(int currentValue, int borderOne, int borderTwo){
        int tempMin = Math.min(borderOne, borderTwo);
        int tempMax = Math.max(borderOne,borderTwo);

        this.minValue = tempMin;
        this.maxValue = tempMax;

        if (currentValue < tempMin || currentValue > tempMax){
            this.currentValue = tempMin;
        }else{
            this.currentValue = currentValue;
        }
    }
    public void increaseValue(){
        if (currentValue+1>maxValue){
            currentValue = maxValue;
            error = "Превышен диапазон счетчика!";
        }else{
            currentValue++;
        }
    }
    public void decreaseValue(){
        if (currentValue-1<minValue){
            currentValue = minValue;
            error = "Превышен диапазон счетчика!";
        }else{
            currentValue--;
        }
    }
    public int currentState(){
        return currentValue;
    }
    public String getError(){
        return error;
    }
}
