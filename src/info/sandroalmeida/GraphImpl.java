package info.sandroalmeida;

import java.util.*;

// Un-direct graph to represent Friends and Friendships in a social network
class Friend{

    String firstName;
    String lastName;
    int age;
    char gender;

    public Friend(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}

public class GraphImpl {


    int vertices;
    LinkedList<Friend> adjListArray[];

    public GraphImpl(int vertices) {
        this.vertices = vertices;
        this.adjListArray = new LinkedList[vertices];
    }

    // Friends are nodes in the graph
    public void addFriend(Friend friend){
        for(int i = 0; i < this.adjListArray.length; i++){
            if(this.adjListArray[i] == null){
                LinkedList<Friend> linkedList = new LinkedList(){};
                linkedList.add(friend);
                this.adjListArray[i] = linkedList;
                System.out.println("Friend " + friend.firstName + " added ;) ");
                return;
            }
        }
        System.out.println("Array full Friend " + friend.firstName + " cannot be added :( ");
    }

    // Friendships are edges in the graph
    public void addFriendship(Friend buddy1, Friend buddy2){

        int count = 0;
        LinkedList<Friend> friendshipsBuddy1 = null;
        LinkedList<Friend> friendshipsBuddy2 = null;

        for(LinkedList<Friend> list : this.adjListArray){
            if(list != null && list.getFirst() == buddy1){
                friendshipsBuddy1 = list;
                count++;
            }
            if(list != null && list.getFirst() == buddy2){
                friendshipsBuddy2 = list;
                count++;
            }
            if(count == 2){
                break;
            }
        }
        if(count < 2){
            System.out.println("One buddy is not in the array :o");
        } else if(count == 2 && friendshipsBuddy1 != null && friendshipsBuddy2 != null){
            friendshipsBuddy1.add(buddy2);
            friendshipsBuddy2.add(buddy1);
            System.out.println("Now " + buddy1.firstName + " and " + buddy2.firstName + " are friends ;) ");
        } else{
            System.out.println("Found some problem.");
        }
    }

    public void BFS(){

        List<Friend> visited = new ArrayList<>();
        Queue<Friend> queue = new LinkedList<>();
        Friend current;

        queue.add(this.adjListArray[0].getFirst());
        visited.add(this.adjListArray[0].getFirst());

        while(!queue.isEmpty()){

            current = queue.remove();
            System.out.println(current.firstName);

            for(int i = 0; i < this.adjListArray.length; i++){
                LinkedList<Friend> list = this.adjListArray[i];
                for(int z = 0; z < list.size(); z++){
                    Friend friend = list.get(z);
                    if(!visited.contains(friend)){
                        queue.add(friend);
                        visited.add(friend);
                    }
                }
            }
        }
    }

    public void DFS(int position){

        List<Friend> visited = new ArrayList<>();
        Stack<Friend> stack = new Stack<>();
        LinkedList<Friend> list = null;

        stack.push(this.adjListArray[position].getFirst());
        visited.add(this.adjListArray[position].getFirst());

        while(!stack.empty()){

            Friend current = stack.peek();

            for(LinkedList<Friend> friendships : this.adjListArray){
                if(friendships.getFirst().equals(current)){
                    list = friendships;
                    break;
                }
            }

            for(int i = 0; i < list.size(); i++){
                Friend friend = list.get(i);
                if(!visited.contains(friend)){
                    stack.push(friend);
                    visited.add(friend);
                    break;
                }
                if(i == list.size() - 1){
                    Friend removedFriend = stack.pop();
                    System.out.println(removedFriend.firstName);
                }
            }
        }
    }
}
