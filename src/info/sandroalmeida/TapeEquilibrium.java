package info.sandroalmeida;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TapeEquilibrium {

    public static int calculate(int[] A){

        int sum = 0, leftSum = 0, rightSum = 0, dif = 0;

        for (int i : A) {
            sum += i;
        }

        for(int i = 0; i < A.length - 1; i++){
            leftSum += A[i];
            rightSum = sum - leftSum;
            if(i == 0){
                if(leftSum > rightSum){
                    dif = leftSum - rightSum;
                } else{
                    dif = rightSum - leftSum;
                }
            } else{
                if(leftSum > rightSum){
                    if((leftSum - rightSum) < dif){
                        dif = leftSum - rightSum;
                    }
                } else{
                    if((rightSum - leftSum) < dif){
                        dif = rightSum - leftSum;
                    }
                }
            }
        }

        return dif;
    }
}
