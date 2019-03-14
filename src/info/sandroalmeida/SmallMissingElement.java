package info.sandroalmeida;

import java.util.Arrays;

public class SmallMissingElement {

    public static int solution1(int[] A){

        Arrays.sort(A);
        int initial = 1;

        for(int i = 0; i < A.length; i++){
            if(i > 0 && A[i] == A[i-1])
                continue;
            if(A[i] <= 0){
                continue;
            } else{
                if(A[i] > initial)
                    return initial;
                else
                    initial++;
            }
        }
        return initial;
    }
}
