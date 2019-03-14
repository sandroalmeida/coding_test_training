package info.sandroalmeida;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {

        int[] counters = new int[N];
        Arrays.fill(counters, 0);
        int maxCount = 0;

        for(int i = 0; i < A.length; i++){
            int value = A[i];
            if(value >= 1 && value <= N){

                counters[value - 1]++;
                if(counters[value -1] > maxCount) maxCount = counters[value -1];

            } else if (value == (N + 1)){
                Arrays.fill(counters, maxCount);
            }
        }
        return counters;
    }

}

class Solution {
    public static int[]  solution(int N, int[] A) {
        int[] counters = new int[N];
        int idx = 0, max = 0, tmp = 0;
        for (int i : A) {
            if (i >= 1 && i <=N) {
                tmp =counters[i-1];
                tmp++;
                max = max > tmp ? max : tmp;
                counters[i-1] = tmp;
            } else if (i == (N + 1)) {
                if(N >1) {
                    counters[0] = max;
                    counters[1] = max;
                    for (int x = 1; x < N; x +=x) {
                        System.arraycopy(counters, 0, counters, x, ((N - x) < x) ? (N - x) : x);
                    }
                } else {
                    counters[0]= max;
                }
            }
        }
        return counters;

    }
}


