package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    class Node {
        String key;
        String value;
        Node left;
        Node right;
    }

    Map<String, Node> map;
    Node start;
    Node end;
    int capacity;

    public LRU(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<String, Node>();
    }

    public void deleteNode(Node node){

        // If left is not null is not the first element
        // Update link between the previous element with next
        if(node.left != null){
            node.left.right = node.right;
        // If left is null it is the first element
        }else {
            start = node.right;
        }

        // If right is not null is not the last element
        // Update link between the previous element with next
        if(node.right != null){
            node.right.left = node.left;
        }else {
            end = node.left;
        }
    }

    public void addLinkedList(Node node){

        // Node entry at first position
        node.right = this.start;
        node.left = null;

        // Update start to second position
        if(this.start != null) this.start.left = node;

        // Update start property
        this.start = node;

        // If is the first insertion
        if(end == null) this.end = this.start;
    }

    public String get(String key){

        // If contains the key return the value and
        // update the node to the start position
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addLinkedList(node);
            return node.value;
        }
        return "None";
    }

    public void put(String key, String value){

        // If contains key update value and
        // update node to the start position
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addLinkedList(node);
        }
        // If not contains the key
        // create a new Node and add to Map
        else{
            Node newElement = new Node();
            newElement.left = null;
            newElement.right = null;
            newElement.value = value;
            newElement.key = key;
            // If capacity is full delete the last list element
            // and add to the first position
            if(map.size() >= capacity){
                map.remove(this.end.key);
                deleteNode(this.end);
                addLinkedList(newElement);
            }
            // If capacity is not full just add to the first position
            else {
                addLinkedList(newElement);
            }
            map.put(key, newElement);
        }
    }

    public void printList(){

        if(start != null){
            Node node = start;
            while (node!= null){
                System.out.print(node.value +  " - ");
                node = node.right;
            }
        }
        System.out.println(" ");

    }


}
