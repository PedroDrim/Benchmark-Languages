package box;

import java.util.ArrayList;
import java.util.List;

public class start {

    public static void main(String args[]){

        List<NumericBox> list = new ArrayList<>();

        long antes = System.currentTimeMillis();

        for(int index = 0; index < 1000000; index++){
            list.add(new NumericBox(index));
        }

        long depois = System.currentTimeMillis();

        System.out.println("Diff: " + (depois - antes));
    }
}
