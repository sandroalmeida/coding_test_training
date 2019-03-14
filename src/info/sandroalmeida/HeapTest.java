package info.sandroalmeida;

import java.util.LinkedList;
import java.util.Queue;

public class HeapTest {

    // Heap Test
    // Create a Tree based on an array and implemented a method
    // to sort the tree array in a Main Heap

    // Build a Complete Tree not ordered using Array
    // Create a insertion using as a parameter an array of int
    // Create a insertion using as a parameter one int
    // Create a BFS search to print the Tree
    // Create a DFS search returning the last element
    // use <Left><Root><Right> schema
    // Create a method for sorting the tree in increasing order
    // Replace the array with the new data turning the tree as a heap

    private Integer[] heap;
    private boolean recursive;

    public HeapTest(int size) {
        this.heap = new Integer[size];
    }

    public void addElementNode(Integer element, int nodeKey){

        int left, right;
        for(int i = 0; i < heap.length; i++){
            if(heap[i] == nodeKey){
                left = (i*2)+1;
                right = (i*2)+2;

                if(left < heap.length && heap[left] == null){
                    heap[left] = element;
                    break;
                } else if(right < heap.length && heap[right] == null){
                    heap[right] = element;
                    break;
                } else if(heap[left] != null && heap[left] != null){
                    System.out.println("Child elements are already fulfill for this node.");
                    break;
                }
            }
        }
        System.out.println("Nodekey not found");
    }

    public void addArray(int[] array){

        for(int i = 0; i < heap.length && i < array.length; i++){
            heap[i] = array[i];
        }
        // check size of both arrays
        if(array.length > heap.length)
            System.out.println("Heap is smaller then array some elements were not used.");
        else
            System.out.println("Heap is bigger then array some elements still null.");
    }

    public void setLeft(int element, int nodeKey){

        for(int i = 0; i < heap.length; i++){
            if(heap[i] != null && heap[i] == nodeKey){
                int left = (2*i)+1;
                if(left < heap.length){
                    if(heap[left] == null){
                        heap[left] = element;
                        break;
                    } else
                        System.out.println("Element " + i + " is already full with the key: " + heap[left]);
                } else
                    System.out.println("Left position beyond array size.");
            }
        }
    }

    public void setRight(int element, int nodeKey){

        for(int i = 0; i < heap.length; i++){
            if(heap[i] != null && heap[i] == nodeKey){
                int right = (2*i)+2;
                if(right < heap.length){
                    if(heap[right] == null){
                        heap[right] = element;
                        break;
                    } else
                        System.out.println("Element " + i + " is already full with the key: " + heap[right]);
                } else
                    System.out.println("Right position beyond array size.");
            }
        }
    }

    public void printHeap(){

        //Father=p then left_son=(2*p)+1 and right_son=(2*p)+2
        Queue<Integer> queuePositions = new LinkedList<>();
        queuePositions.add(0);

        while(!queuePositions.isEmpty()){

            int position = queuePositions.remove();
            if(heap[position] != null)
                System.out.print(heap[position] + "-");
            else
                System.out.print('\20' + "-");

            int leftPosition = (position * 2) + 1;
            if(leftPosition < heap.length)
                queuePositions.add(leftPosition);

            int rightPosition = (position * 2) + 2;
            if(rightPosition < heap.length)
                queuePositions.add(rightPosition);
        }
        System.out.println("");
    }

    public Integer lastElement(){

        int nextElement = 0;
        int left, right;

        while (true){
            left = (nextElement * 2) + 1;
            right = (nextElement * 2) + 2;

            if(left < heap.length && heap[left] != null){
                nextElement = left;
            }else if(right < heap.length && heap[right] != null){
                nextElement = right;
            }else if(left >= heap.length && right >= heap.length){
                break;
            }else if(heap[left] == null && heap[right] == null){
                break;
            }
        }

        return heap[nextElement];
    }

    public void heapSort(){

        Integer[] sortArray = new Integer[this.heap.length];
        int lastPosition = 0, parentPosition = 0;

        // Find the last element valid
        for(int i = 0; i < heap.length; i++){
            if(heap[i] != null){
                lastPosition = i;
            }
        }

        // Find the parent element for the last element
        parentPosition = (lastPosition - 1)/2;

        // Return the range and layer for the last parent layer to start loop
        int[] range = calcRange(parentPosition);
        int layer = range[2];
        recursive = false;

        // loop through out layers
        while(layer >= 0) {
            // loop through out range
            for(int i = range[0]; i <= range[1]; i++){

                if(heap[i] != null){
                    int lPos = (i*2)+1;
                    int rPos = (i*2)+2;
                    Integer temp;
                    if(heap[lPos] != null && heap[lPos] < heap[i]){
                        temp = heap[i];
                        heap[i] = heap[lPos];
                        heap[lPos] = temp;
                        recursive = true;
                    }
                    if(heap[rPos] != null && heap[rPos] < heap[i]){
                        temp = heap[i];
                        heap[i] = heap[rPos];
                        heap[rPos] = temp;
                        recursive = true;
                    }
                    if(heap[rPos] != null && heap[lPos] != null && heap[rPos] < heap[lPos]){
                        temp = heap[lPos];
                        heap[lPos] = heap[rPos];
                        heap[rPos] = temp;
                        recursive = true;
                    }
                    // Recursive call if some change happens
                    // Every times one change occurs all tree need to be checked
                    if(recursive) heapSort();
                }
            }
            range = calcRange((range[0]-1)>= 0 ? (range[0]-1) : 0);
            layer--;
        }


    }

    // Parameter is a position inside the tree
    // Return is the initial position in that level
    // follow by the last position in that level
    // and number of the level
    public int[] calcRange(int position){

        int initial = 0, end = 0, count = 0;
        while(true){
            if(position >= initial && position <= end){
                break;
            }else {
                initial = end + 1;
                end = initial * 2;
            }
            count++;
        }
        return new int[]{initial, end, count};
    }


}
