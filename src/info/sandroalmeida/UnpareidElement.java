package info.sandroalmeida;

import java.util.*;

public class UnpareidElement {

    public static int searchElementList(int[] A){

        List<Integer> list = new ArrayList<>();

        for (int e: A) {
            if(list.contains(e)){
                list.remove(list.indexOf(e));
            } else{
                list.add(e);
            }
        }
        return list.get(0);
    }

    public static int searchElementArraysSort(int[] A){

        // int[] A = {3, 3, 7, 9, 9, 9, 9};
        Arrays.sort(A);

        if(A.length > 1){
            for(int i = 0; i < A.length - 1; i++){
                if(A[i] == A[i+1]){
                    if(A.length - 1 >= (i + 3)){
                        i++;
                        continue;
                    }else{
                        return A[i+2];
                    }
                }else{
                    return A[i];
                }
            }
        }
        return A[0];
    }
}
