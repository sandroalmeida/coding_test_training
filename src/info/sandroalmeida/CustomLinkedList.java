package info.sandroalmeida;

import java.util.Hashtable;

// Java program to implement
// a Singly Linked List 
public class CustomLinkedList {

    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public CustomLinkedList() {
    }

    public CustomLinkedList(int[] array) {
        for (int i : array) {
            insert(this, i);
        }
    }

    // Method to insert a new node
    public static CustomLinkedList insert(CustomLinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the CustomLinkedList.
    public static void printList(CustomLinkedList list) {
        Node currNode = list.head;

        System.out.print("CustomLinkedList: ");

        // Traverse through the CustomLinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println('\n');
    }

    // **************DELETION BY KEY**************

    // Method to delete a node in the CustomLinkedList by KEY
    public static CustomLinkedList deleteByKey(CustomLinkedList list, int key) {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the List
        return list;
    }

    // Method to delete a node in the CustomLinkedList by POSITION
    public static CustomLinkedList deleteAtPosition(CustomLinkedList list, int index) {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be deleted

        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(index + " position element deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the size of CustomLinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required position
                // Unlink currNode from linked list
                prev.next = currNode.next;

                // Display the message
                System.out.println(index + " position element deleted");
                break;
            } else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be at currNode
        // Therefore the currNode shall not be null
        //
        // CASE 3: The index is greater than the size of the CustomLinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(index + " position element not found");
        }

        // return the List
        return list;
    }

    public static CustomLinkedList deleteDupNotBuffer(CustomLinkedList list) {

        Node head = list.head;

        if (head == null)
            return null;

        Node previous = head;
        Node current = previous.next;

        while (current != null) {
            Node runner = head;
            while (runner != current) { // Check for earlier dups
                if (runner.data == current.data) {
                    Node tmp = current.next; // remove current
                    previous.next = tmp;
                    current = tmp; // update current to next node
                    break; // all other dups have already been removed
                }
                runner = runner.next;
            }
            if (runner == current) { // current not updated - update now
                previous = current;
                current = current.next;
            }
        }
        return list;
    }

    public static void deleteDupWithBuffer(CustomLinkedList list) {

        Node n = list.head;
        Hashtable table = new Hashtable();
        Node previous = null;
        while (n != null) {
            if (table.containsKey(n.data)) previous.next = n.next;
            else {
                table.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
    }

    public static Node nthToLast(CustomLinkedList list, int n) {

        Node head = list.head;
        if (head == null || n < 1) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
            if (p2 == null) {
                return null; // not found since list size < n
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static CustomLinkedList mergeLinkedLists(CustomLinkedList listA, CustomLinkedList listB) {

        Node currentA = listA.head;
        Node currentB = listB.head;

        if (currentA == null) return listB;
        if (currentB == null) return listA;

        CustomLinkedList newList = new CustomLinkedList();
        Node currentNew = newList.head;

        while (currentA != null) {

            if (currentNew == null) {
                // if it is the first element to new list add to heap
                newList.head = currentA;
                currentNew = newList.head;
            } else {
                // if is not the first element add to next
                currentNew.next = currentA;
                currentNew = currentNew.next;
            }
            // through to next element in the list A
            currentA = currentA.next;

            if (currentB != null) {
                // add new element new list using list B
                currentNew.next = currentB;
                currentNew = currentNew.next;
                // through to next element in the new list
                currentB = currentB.next;
            }
        }

        if (currentB != null) currentNew = currentB;

        while (currentB.next != null) {
            currentNew.next = currentB.next;
            currentB = currentB.next;
            currentNew = currentNew.next;
        }
        return newList;
    }

    public static int findMiddle(CustomLinkedList list) {

        Node slow = list.head;
        Node fast = list.head;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static CustomLinkedList reverseLinkedList(CustomLinkedList list){

        CustomLinkedList reversedList = new CustomLinkedList();
        Node current = list.head;

        while(current != null){
            if(reversedList.head == null){
                reversedList.head = new Node(current.data);
            } else{
                pushNode(new Node(current.data), reversedList);
            }
            current = current.next;
        }

        return reversedList;
    }

    public static void pushNode(Node node, CustomLinkedList list){

        Node head = list.head;
        list.head = node;
        node.next = head;

    }

} 
