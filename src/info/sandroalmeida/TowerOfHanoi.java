package info.sandroalmeida;

import java.util.Stack;

public class TowerOfHanoi {

    // Move elements from first rod to the last one
    // Rules:
    //(A) Only one disk can be moved at a time.
    //(B) A disk is slid off the top of one rod onto the next rod.
    //(C) A disk can only be placed on top of a larger disk.

    Stack<Integer> rod1 = new Stack<>();
    Stack<Integer> rod2 = new Stack<>();
    Stack<Integer> rod3 = new Stack<>();

    public TowerOfHanoi(int numberElements) {

        for(int i = numberElements; i > 0; i--){
            this.rod1.push(i);
        }
    }

    public void showStacks(){
        System.out.println("Stack 1: " + rod1.toString());
        System.out.println("Stack 2: " + rod2.toString());
        System.out.println("Stack 3: " + rod3.toString());
    }

    public int solution(){



        return 0;
    }
}
