package info.sandroalmeida;

public class RotationArray {

    public static int[] rotate(int[] A, int K){

        if(A != null && A.length != 0){
            int realRotation = K > A.length ? K % A.length : K;
            int[] B = new int[A.length];
            int position;

            if(A.length != realRotation && realRotation != 0){
                for(int i = 0; i <= A.length - 1; i++){
                    position = i + realRotation;
                    if(position > A.length - 1)
                        position = position - A.length;
                    B[position] = A[i];
                }
                return B;
            }
        }
        return A;
    }
}
