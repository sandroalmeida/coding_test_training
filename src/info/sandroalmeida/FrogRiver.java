package info.sandroalmeida;

import java.util.HashSet;

public class FrogRiver {

    public static int calc(int X, int[] A){

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] <= X)
                set.add(A[i]);
            if(set.size() == X)
                return i;
        }
        return -1;
    }

}
