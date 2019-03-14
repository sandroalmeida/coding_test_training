package info.sandroalmeida;

import java.util.Arrays;

public class MergeSort {

    private int[] unorderedArray;
    private int[] orderedArray;

    public MergeSort(int size) {

        this.unorderedArray = new int[size];
        for(int i = 0; i < size; i++){
            unorderedArray[i] = (int) (Math.random() * 10000);
        }
        this.orderedArray = Arrays.copyOf(this.unorderedArray, this.unorderedArray.length);
    }

    public int[] getUnorderedArray() {
        return unorderedArray;
    }

    public int[] getOrderedArray() {
        return orderedArray;
    }

    public void recursiveCall(int start, int end){

        if(start < end){
            int medium = (start + end) / 2;

            recursiveCall(start, medium);
            recursiveCall(medium+1, end);

            mergeSort(start, medium, end);

        }
    }

    public void mergeSort(int start, int medium, int end){

        // Size of temp arrays
        int size1 = medium - start + 1;
        int size2 = end - medium;

        // Create temp arrays
        int[] half1 = new int[size1];
        int[] half2 = new int[size2];

        // Copy data
        for (int i = 0; i < size1; ++i)
            half1[i] = this.orderedArray[start + i];
        for (int j = 0; j < size2; ++j)
            half2[j] = this.orderedArray[medium + 1 + j];

        // Counters for the temp arrays
        int i = 0, j = 0;

        // Initial position to do the switches
        int k = start;

        // Comparison between the two halves
        while(i < size1 && j < size2){

                if(half1[i] <= half2[j]){
                    this.orderedArray[k] = half1[i];
                    i++;
                } else{
                    this.orderedArray[k] = half2[j];
                    j++;
                }
                k++;
        }

        // Copy remaining elements from half1
        while(i < size1){
            this.orderedArray[k] = half1[i];
            i++;
            k++;
        }

        // Copy remaining elements from half2
        while(j < size2){
            this.orderedArray[k] = half2[j];
            j++;
            k++;
        }

    }
}
