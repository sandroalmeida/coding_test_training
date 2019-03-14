package info.sandroalmeida;

import java.util.Arrays;

public class TrekSwin {

    public static int solution(int[] A){

        // First possible split
        int firstSplit = 1;
        // Last possible split
        int lastSplit = (A.length/2);

        // Best result
        int bestResult = 0;

        // base loop offers all possibilities to split the array
        // the idea is storage left and right length for each split
        // sum the values and storage the result in one collection
        for(int i = firstSplit; i <= A.length - 1; i++){

            int[] left = Arrays.copyOfRange(A, 0, i);
            // loop the left array to find longest sequence
            int sumLeft = 0;
            int longestLeft = 0;
            int sizeLeft = 0;
            for(int l = left.length - 1; l >= 0; l--){
                sumLeft += left[l];
                sizeLeft++;
                // Left Part (sum should be lower than size / 2)
                if(sumLeft < (sizeLeft / 2.0)){
                    longestLeft = sizeLeft;
                }
            }

            int[] right = Arrays.copyOfRange(A, i, A.length);
            // loop the right array to find longest sequence
            int sumRight = 0;
            int longestRight = 0;
            int sizeRight = 0;
            for(int r = 0; r < right.length; r++){
                sumRight += right[r];
                sizeRight++;
                // Right Part (sum should be higher than size / 2)
                if(sumRight > (sizeRight / 2.0)){
                    longestRight = sizeRight;
                }
            }

            if(((longestLeft + longestRight)>bestResult) && longestLeft > 0 && longestRight > 0)
                bestResult = (longestLeft + longestRight);

        }

        return bestResult;
    }

}
