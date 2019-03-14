package info.sandroalmeida;

import java.util.LinkedList;
import java.util.Queue;

public class TreeVerticalPrint {

    // create a tree node Integer, Left and Right
    // use internal class to node
    // create a constructor to fill the tree using for and random numbers
    // create a insertion function (add to tree in order min level at left position
    // create a normal print
    // create print vertical tree using hashtable with linked list

    private Node root;
    private LinkedNode[] hashTable;
    private boolean firstAdd;
    private int addPosition;

    public TreeVerticalPrint(int root, int size){

        this.root = new Node(root, 0);
        this.hashTable = new LinkedNode[size];
        this.firstAdd = true;
        for(int i = 0; i <= size; i++){
            int number = (int) (Math.random()*size);
            insert(number);
        }
    }

    public Node getRoot() {
        return root;
    }

    class Node {
        int value;
        Node left;
        Node right;
        int level;

        public Node(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    class LinkedNode{
        int value;
        LinkedNode link;

        public LinkedNode(int value) {
            this.value = value;
        }
    }

    public void insert(int number){

        Node node = this.root;

        if(node == null){
            this.root = new Node(number,0);
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()){

                Node current = queue.remove();

                if(current.left != null){
                    queue.add(current.left);
                } else{
                    current.left = new Node(number, current.level-1);
                    break;
                }

                if(current.right != null){
                    queue.add(current.right);
                } else{
                    current.right = new Node(number, current.level+1);
                    break;
                }
            }
        }
    }

    public void normalPrint(){

        Node node = this.root;
        if(node == null){
            System.out.println("Tree is empty!");
        } else{
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            int count = 0, currentLevel = 0;

            while(!queue.isEmpty()){
                Node current = queue.remove();
                int actualLevel = discoverLevel(count);
                if(actualLevel > currentLevel){
                    System.out.println("-");
                    currentLevel = actualLevel;
                }
                System.out.print(current.value + "(" + current.level + ") ");
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
                count++;
            }
        }
        System.out.println("");
    }

    public int discoverLevel(int position){

        int initial = 0, end = 0, level = 0;
        while(true){
            if(position >= initial && position <= end){
                return level;
            } else{
                initial = end + 1;
                end = initial * 2;
                level++;
            }
        }
    }

    public void verticalPrint(){

        DFSHashTable(getRoot());

        for(int i = 0; i < hashTable.length; i++){
            LinkedNode linkedNode = hashTable[i];
            if(linkedNode != null){
                System.out.print(linkedNode.value + " ");
                LinkedNode lNode = linkedNode.link;
                while(lNode != null){
                    System.out.print(lNode.value + " ");
                    lNode = lNode.link;
                }
                System.out.println("");
            }
        }
    }

    // <left><node><right>
    public void DFSHashTable(Node node){

        Node start = node;
        Node left = start.left;
        Node right = start.right;

        // recursion call left node
        if(left != null){
            DFSHashTable(left);
        }

        // Space to execute actions in DFS
        // **** start ****
        LinkedNode linkedNode = new LinkedNode(start.value);
        if(firstAdd){
            this.hashTable[0] = linkedNode;
            this.addPosition = Math.abs(start.level);
            this.firstAdd = false;
        } else{
            int hashPosition = start.level + addPosition;
            if(this.hashTable[hashPosition] == null){
                this.hashTable[hashPosition] = linkedNode;
            }else {
                addHashLink(linkedNode, hashPosition);
            }
        }
        // **** end ****

        // recursion call right node
        if(right != null){
            DFSHashTable(right);
        }
    }


    public void addHashLink(LinkedNode linkedNode, int hashPosition){

        LinkedNode parentNode = this.hashTable[hashPosition];
        while(parentNode.link != null){
            parentNode = parentNode.link;
        }
        parentNode.link = linkedNode;
    }

}
