package practice2;

public class MathArrayUtils {

    private MathArrayUtils(){

    }
    static int sum(int[] values){
        int sum = 0;
        for(int value : values){
            sum+=value;
        }
        return sum;
    }

    static double average(int[] values){
        int sum = 0;
        double average;
        for(int value : values){
            sum+=value;
        }
        average = (double)sum / values.length;
        return average;
    }

    static int min(int[] values){
        int min = values[0];
        for(int value : values){
            if(min > value){
                min = value;
            }
        }
        return min;
    }

    static int max(int[] values){
        int max = values[0];
        for(int value : values){
            if(max < value){
                max = value;
            }
        }
        return max;
    }

}
