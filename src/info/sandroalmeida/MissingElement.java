package info.sandroalmeida;

import java.util.Arrays;

public class MissingElement {

    public static int solution1(int[] A){

        if(A != null && A.length > 0){
            Arrays.sort(A);
            int value = A[0];
            if(A.length == 1){
                return value;
            } else{
                for(int i = 1; i <= A.length - 1; i++){
                    value++;
                    if(value != A[i])
                        return value;
                }
            }
        }
        return 1;
    }

    public static int solution2(int[] A){
        int missing_element = A.length + 1;

        for(int i=0; i <= A.length -1; i++){
            System.out.println(i);
            missing_element = missing_element ^ A[i] ^ (i+1);
        }

        return missing_element;
    }

    public static int solution3(int[] A){
        int shouldBe = A.length;
        int sum = 0;

        for(int i = 0; i <= A.length - 1; i++){
            sum += A[i];
            shouldBe += i+1;
        }
        return shouldBe - sum +1;
    }

}
