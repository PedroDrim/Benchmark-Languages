package box;

public class NumericBox {

    private int value;

    public NumericBox(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int doubleValue(){
        return this.value * 2;
    }
}
