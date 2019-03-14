package info.sandroalmeida;

import java.util.Arrays;

public class BubbleSort {

    private int[] unorderedArray;
    private int[] orderedArray;

    public BubbleSort(int size) {

        this.unorderedArray = new int[size];
        for(int i = 0; i < size; i++){
            unorderedArray[i] = (int) (Math.random() * 10000);
        }
    }

    public int[] getUnorderedArray() {
        return unorderedArray;
    }

    public int[] getOrderedArray() {
        return orderedArray;
    }

    // My implementation for Bubble Sort
    public void sortArray(){

        int count = 1;
        int totalSwitches = 0;
        int round = 0;
        this.orderedArray = Arrays.copyOf(getUnorderedArray(),getUnorderedArray().length);

        while(count > 0){

            count = 0;
            round++;

            for(int i = 0; i < this.orderedArray.length - 1; i++){
                if(this.orderedArray[i+1] < this.orderedArray[i]){
                    int temp = this.orderedArray[i];
                    this.orderedArray[i] = this.orderedArray[i + 1];
                    this.orderedArray[i + 1] = temp;
                    count++;
                }
            }
            totalSwitches += count;
            System.out.println("Verification " + round + " concluded, " + count + " switches were done.");

        }
        System.out.println("sortArray total switches " + totalSwitches);
    }

    // example code Bubble Sort Geek for Geek
    public void sortArrayGFG()
    {
        this.orderedArray = Arrays.copyOf(getUnorderedArray(),getUnorderedArray().length);
        int n = this.orderedArray.length;
        int count = 0;
        int totalSwitches = 0;
        for (int i = 0; i < n-1; i++){
            count = 0;
            for (int j = 0; j < n-i-1; j++){
                if (this.orderedArray[j] > this.orderedArray[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = this.orderedArray[j];
                    this.orderedArray[j] = this.orderedArray[j+1];
                    this.orderedArray[j+1] = temp;
                    count++;
                }
            }
            totalSwitches += count;
            System.out.println("Verification " + i + " concluded, " + count + " switches were done.");

        }
        System.out.println("sortArrayGFG total switches " + totalSwitches);
    }
}
