package info.sandroalmeida;

import java.util.Arrays;

public class Permutation {

    public static int isPermutation(int[] A){

        Arrays.parallelSort(A);
        int initial = 1;
        int response = 1;


        for(int i = 0; i < A.length; i++){
            if(initial != A[i]){
                response = 0;
                break;
            }
            initial++;
        }

        return response;
    }
}
