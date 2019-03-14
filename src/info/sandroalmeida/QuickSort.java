package info.sandroalmeida;

import java.util.Arrays;

public class QuickSort {

    private int[] unorderedArray;
    private int[] orderedArray;

    public QuickSort(int size) {

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

    public void quickSort(int low, int high){

        if(low < high){

            int pi = partition(low, high);

            quickSort(low, pi-1);
            quickSort(pi+1, high);

        }
    }

    private int partition(int low, int high) {

        int pivot = this.orderedArray[high];
        int i = low - 1;

        for(int j = low; j <= high -1; j++){
            if(this.orderedArray[j] <= pivot){
                i++;
                int temp = this.orderedArray[i];
                this.orderedArray[i] = this.orderedArray[j];
                this.orderedArray[j] = temp;
            }
        }
        int temp = this.orderedArray[high];
        this.orderedArray[high] = this.orderedArray[i+1];
        this.orderedArray[i+1] = temp;

        return (i+1);
    }

}
