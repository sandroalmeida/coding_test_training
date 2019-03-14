package info.sandroalmeida;

public class MinAverageSlice {

    public static int solution(int[] A) {

        int sizeMax = A.length - 1;
        int lastPosition = 0;
        double average = 0.0d;
        // for base in the size for each possible slice
        for(int size = 2; size <= sizeMax; size++){
            int start;
            // for segment
            for(start = 0; (start + size) <= A.length; start++){
                int end = start + size - 1;
                double sum = 0.0d;
                // for positions each segment
                int i;
                for(i = start; i <= end; i++){
                    sum += (A[i]);
                }
                // check if new average is lower than previous storage
                if((sum / size) < average || average == 0) {
                    lastPosition = (i - size);
                    average = sum / size;
                }else if((sum / size) == average && (i - size) < lastPosition){
                    lastPosition = (i - size);
                }
            }
        }
        return lastPosition;
    }

    public static int solution2(int[] A) {
        int startIndex = 0;

        if (A.length < 2) {
            return -1;
        }

        double minSliceSize = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            double sliceSize = (A[i] + A[i + 1]) / 2.0;
            if (sliceSize < minSliceSize) {
                minSliceSize = sliceSize;
                startIndex = i;
            }
            if (i + 2 < A.length) {
                sliceSize = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (sliceSize < minSliceSize) {
                    minSliceSize = sliceSize;
                    startIndex = i;
                }
            }
        }
        return startIndex;
    }
}
