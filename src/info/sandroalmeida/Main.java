package info.sandroalmeida;

import java.util.Arrays;

public class Main {

    enum Exercise{
        BINARY_GAP,UNPAREID_ELEMENT, ROTATION_ARRAY, FROG_JUMP, MISSING_ELEMENT, TAPE_EQUILIBRIUM, PERMUTATION,
        FROG_RIVER, SMALL_MISSING_ELEMENT, MAX_COUNTERS, MAX_BINARY_SLICE, MIN_AVERAGE_SLICE, COUNT_DIV,
        UNIQUE_CHARS, REVERSE_STRING, REMOVE_DUPLICATES_CHARS, REPLACE_SPACES, ROTATE_MATRIX, LINKED_LIST,
        REMOVE_DUPLICATES_LINKEDLIST, MERGE_LINKEDLIST, MIDDLE_NODE, REVERSE_LINKED_LIST, CUSTOM_STACK,
        TOWER_OF_HANOI, EXAMPLE_TREE, TREE_ARRAY, HEAP_TEST, PRINT_TREE_VERTICAL, GRAPH_TEST, BUBBLE_SORT,
        MERGE_SORT, QUICK_SORT
    }

    public static void main(String[] args) {

        Exercise exercise = Exercise.BINARY_GAP;

        if(exercise == Exercise.BINARY_GAP) binaryGap();
        if(exercise == Exercise.UNPAREID_ELEMENT) unpareidElement();
        if(exercise == Exercise.ROTATION_ARRAY) rotationArray();
        if(exercise == Exercise.FROG_JUMP) frogJump(FrogJump.calculate(10, 80, 30));
        if(exercise == Exercise.MISSING_ELEMENT) missingElement();
        if(exercise == Exercise.TAPE_EQUILIBRIUM) tapeEquilibrium();
        if(exercise == Exercise.PERMUTATION) permutation();
        if(exercise == Exercise.FROG_RIVER) frogRiver();
        if(exercise == Exercise.SMALL_MISSING_ELEMENT) smallMissingElement();
        if(exercise == Exercise.MAX_COUNTERS) maxCounters();
        if(exercise == Exercise.MAX_BINARY_SLICE) maxBinarySlice();
        if(exercise == Exercise.MIN_AVERAGE_SLICE) minAverageSlice();
        if(exercise == Exercise.COUNT_DIV) countDiv();
        if(exercise == Exercise.UNIQUE_CHARS) uniqueChars();
        if(exercise == Exercise.REVERSE_STRING) reverseString();
        if(exercise == Exercise.REMOVE_DUPLICATES_CHARS) removeDuplicatesChars();
        if(exercise == Exercise.REPLACE_SPACES) replaceSpaces();
        if(exercise == Exercise.ROTATE_MATRIX) rotateMatrix();
        if(exercise == Exercise.LINKED_LIST) linkedList();
        if(exercise == Exercise.REMOVE_DUPLICATES_LINKEDLIST) removeDuplicatesLinkedlist();
        if(exercise == Exercise.MERGE_LINKEDLIST) mergeLinkedlist();
        if(exercise == Exercise.MIDDLE_NODE) middleNode();
        if(exercise == Exercise.REVERSE_LINKED_LIST) reverseLinkedList();
        if(exercise == Exercise.CUSTOM_STACK) customStack();
        if(exercise == Exercise.TOWER_OF_HANOI) towerOfHanoi();
        if(exercise == Exercise.EXAMPLE_TREE) exampleTree();
        if(exercise == Exercise.TREE_ARRAY) treeArray();
        if(exercise == Exercise.HEAP_TEST) heapTest();
        if(exercise == Exercise.PRINT_TREE_VERTICAL) printTreeVertical();
        if(exercise == Exercise.GRAPH_TEST) graphTest();
        if(exercise == Exercise.BUBBLE_SORT) bubbleSort();
        if(exercise == Exercise.MERGE_SORT) mergeSort();
        if(exercise == Exercise.QUICK_SORT) quickSort();


    }

    private static void quickSort() {
        QuickSort quickSort = new QuickSort(100);
        System.out.println(Arrays.toString(quickSort.getUnorderedArray()));
        System.out.println(Arrays.toString(quickSort.getOrderedArray()));
        quickSort.quickSort(0, quickSort.getOrderedArray().length - 1);
        System.out.println(Arrays.toString(quickSort.getOrderedArray()));
    }

    private static void mergeSort() {
        MergeSort mergeSort = new MergeSort(100);
        System.out.println(Arrays.toString(mergeSort.getUnorderedArray()));
        System.out.println(Arrays.toString(mergeSort.getOrderedArray()));
        mergeSort.recursiveCall(0, mergeSort.getOrderedArray().length-1);
        System.out.println(Arrays.toString(mergeSort.getOrderedArray()));
    }

    private static void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort(100);
        System.out.println(Arrays.toString(bubbleSort.getUnorderedArray()));
        bubbleSort.sortArray();
        System.out.println(Arrays.toString(bubbleSort.getOrderedArray()));
        bubbleSort.sortArrayGFG();
        System.out.println(Arrays.toString(bubbleSort.getOrderedArray()));
    }

    private static void graphTest() {
        GraphImpl socialnetwork = new GraphImpl(7);
        Friend tony = new Friend("Tony", "Stark", 42, 'M');
        Friend peter = new Friend("Peter", "Parker", 36, 'F');
        Friend steve = new Friend("Steve", "Rogers", 28, 'M');
        Friend bruce = new Friend("Bruce", "Banner", 38, 'M');
        Friend stephen = new Friend("Stephen", "Strange", 37, 'F');
        Friend natasha = new Friend("Natasha", "Romanoff", 45, 'M');
        Friend scott = new Friend("Scott", "Lang", 42, 'F');
        socialnetwork.addFriend(tony);
        socialnetwork.addFriend(peter);
        socialnetwork.addFriend(steve);
        socialnetwork.addFriend(bruce);
        socialnetwork.addFriend(stephen);
        socialnetwork.addFriend(natasha);
        socialnetwork.addFriend(scott);
        socialnetwork.addFriendship(tony, peter);
        socialnetwork.addFriendship(tony, steve);
        socialnetwork.addFriendship(tony, bruce);
        socialnetwork.addFriendship(tony, stephen);
        socialnetwork.addFriendship(bruce, peter);
        socialnetwork.addFriendship(bruce, stephen);
        socialnetwork.addFriendship(steve, peter);
        socialnetwork.addFriendship(peter, stephen);
        socialnetwork.addFriendship(bruce, natasha);
        socialnetwork.addFriendship(bruce, scott);
        socialnetwork.addFriendship(natasha, scott);
        System.out.println("----------BFS----------");
        socialnetwork.BFS();
        System.out.println("----------DFS----------");
        socialnetwork.DFS(0);
    }

    private static void printTreeVertical() {
        TreeVerticalPrint tvp = new TreeVerticalPrint(0,13);
        tvp.normalPrint();
        tvp.verticalPrint();
    }

    private static void heapTest() {
        HeapTest heap = new HeapTest(50);
        heap.addArray(new int[]{10,16,21,5,7,9,3,1,0,23,27,31,44,12,6,8,4});
        heap.addElementNode(16,8);
        heap.addElementNode(17,8);
        heap.setLeft(22,4);
        heap.setRight(24,4);
        heap.printHeap();
        System.out.println(heap.lastElement());
        heap.heapSort();
        heap.printHeap();


        // Geekforgeeks example
        int arr[] = {10,16,21,5,7,9,3,1,0,23,27,31,44,12,6,8,4};

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        ob.printArray(arr);
    }

    private static void treeArray() {
        TreeArrayImpl treeArray = new TreeArrayImpl(50);
        treeArray.Root("A");
        treeArray.set_Left("B", 0);
        treeArray.set_Right("C", 0);
        treeArray.set_Left("D", 1);
        treeArray.set_Right("E", 1);
        treeArray.set_Left("F", 2);
        treeArray.print_Tree();
    }

    private static void exampleTree() {
        TreeExample.root = new TreeExample.Node(10);
        TreeExample.root.left = new TreeExample.Node(11);
        TreeExample.root.left.left = new TreeExample.Node(7);
        TreeExample.root.right = new TreeExample.Node(9);
        TreeExample.root.right.left = new TreeExample.Node(15);
        TreeExample.root.right.right = new TreeExample.Node(8);

        // Testing Insert method
        int key = 12;
        TreeExample.insert(TreeExample.root, key);

        // Testing Level Order
        System.out.println("Level Order or BFS:");
        TreeExample.levelOrder(TreeExample.root);
        System.out.println("");

        // Testing Preorder
        System.out.println("Preorder traversal:");
        TreeExample.preorder(TreeExample.root);
        System.out.println("");

        // Testing Inorder
        System.out.println("Inorder traversal:");
        TreeExample.inorder(TreeExample.root);
        System.out.println("");

        // Testing Postorder
        System.out.println("Postorder traversal:");
        TreeExample.postorder(TreeExample.root);
        System.out.println("");
    }

    private static void towerOfHanoi() {
        TowerOfHanoi tower = new TowerOfHanoi(5);
        tower.showStacks();
        System.out.println(tower.rod1.peek());
        //NOT FINISHED
    }

    private static void customStack() {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s);
        s.push(1);
        System.out.println(s);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s);
        s.pop();
        System.out.println(s);
        System.out.println(s.getMin());
    }

    private static void reverseLinkedList() {
        CustomLinkedList listA = new CustomLinkedList(new int[]{1,2,3,4,5});
        CustomLinkedList reversedList = CustomLinkedList.reverseLinkedList(listA);
        CustomLinkedList.printList(reversedList);
    }

    private static void middleNode() {
        CustomLinkedList listA = new CustomLinkedList(new int[]{1,2,3,4,5});
        System.out.println(CustomLinkedList.findMiddle(listA));
    }

    private static void mergeLinkedlist() {
        CustomLinkedList listA = new CustomLinkedList(new int[]{1,2,3,4});
        CustomLinkedList listB = new CustomLinkedList(new int[]{6,7,8,9,0,0,0,0});
        CustomLinkedList.printList(CustomLinkedList.mergeLinkedLists(listA, listB));
    }

    private static void removeDuplicatesLinkedlist() {
        CustomLinkedList list = new CustomLinkedList(new int[]{1,2,3,4,1,5,6,7,8,9});
        list.printList(list);
        list.deleteDupNotBuffer(list);
        list.printList(list);
        list = list.insert(list, 5);
        list.printList(list);
        list.deleteDupWithBuffer(list);
        list.printList(list);
        System.out.println("-------------------------");
        System.out.println(list.nthToLast(list,1).data);
    }

    private static void linkedList() {
        CustomLinkedList list = new CustomLinkedList();

        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 3);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 8);

        // Print the CustomLinkedList
        list.printList(list);

        // Delete by key
        list.deleteByKey(list, 1);
        list.deleteByKey(list, 4);
        list.deleteByKey(list, 10);
        list.printList(list);

        // Delete by the position
        list.deleteAtPosition(list, 0);
        list.deleteAtPosition(list, 2);
        list.deleteAtPosition(list, 10);
        list.printList(list);
    }

    private static void rotateMatrix() {
        String str =    "┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌█████┌┘█████┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌██████████████┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌████┘┌████┘┌┘███┘┌┘┌┘┌┘┌┘┌┘███████┘┌┘" + '\n' +
                        "┘┌┘███┘┌┘┌██┘┌┘┌┘██┌┘┌┘┌┘┌┘┌┘████████┌┘┌" + '\n' +
                        "┌┘┌██┘┌┘┌┘┌┘┌┘┌┘┌███┌┘┌┘┌┘┌┘┌┘┌┘█████┘┌┘" + '\n' +
                        "┘┌┘██┌┘┌┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘┌┘┌┘███┘██┌┘┌" + '\n' +
                        "┌┘┌██┘┌┘┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌┘┌┘┌┘███┘┌██┘┌┘" + '\n' +
                        "┘┌┘██┌┘┌┘┌┘┌┘┌┘┌┘███┘┌┘┌┘┌┘┌┘███┘┌┘┘┌┌┘┌" + '\n' +
                        "┌┘┌███┌┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘┌┘███┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌██┘┌┘┌┘┌┘┌┘┌███┌███┌┘┌┘███┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘███┘┌┘┌┘┌┘┌███┘█████┌┘█████┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘███┘┌┘┌┘┌███┌███┌█████┌┘███┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘███┘┌┘┌███┌██┘┌┘┌███┌┘┌┘██┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘███┘┌███┌┘██┌┘┌┘┌█┌┘┌┘┌███┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘██████┌┘██┌┘┌┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌███┌┘┌██┘┌┘┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘┌┘██┌┘┌┘██┌┘┌┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘██┌┘┌┘┌┘┌┘┌┘┌███┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌██┘┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌██┘┌┘┌┘┌┘┌┘███┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘██████████┌┘███┘┌┘┌┘┌┘███┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌██████████┘┌┘███┘┌┘┌┘███┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌┘┌┘███┘┌┘███┘┌┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘┌┘███┘███┘┌┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘┌┘██┌┘┌┘┌┘┌┘┌┘█████┘┌┘┌┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌██┘┌┘┌┘┌┘┌┘┌┘███┘┌┘┌┘┌┘┌┘┌┘┌┘┌" + '\n' +
                        "┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘" + '\n' +
                        "┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌┘┌";

        char[][] matrix = RotateMatrix.createMatrix(str);
        System.out.println(RotateMatrix.showMatrix(matrix));
        char[][] rotateMatrix = RotateMatrix.solution(matrix);
        System.out.println(RotateMatrix.showMatrix(rotateMatrix));
    }

    private static void replaceSpaces() {
        replaceSpaces(ReplaceSpacesString.ReplaceFun('\20', "Sandro Almeida"));
    }

    private static void replaceSpaces(String sandro_almeida) {
        System.out.println(sandro_almeida);
    }

    private static void removeDuplicatesChars() {
        System.out.println(RemoveDuplicateCharacters.solution("SSSaannddddrrrroooo"));
    }

    private static void reverseString() {
        System.out.println(ReverseCStyleString.reverse("Sandro" + "\n" + "Almeida"));
    }

    private static void uniqueChars() {
        System.out.println(StringAllUnique.solution("sandros"));
        System.out.println(StringAllUnique.isUniqueChars("sandros"));
    }

    private static void countDiv() {
        System.out.println(CountDiv.solution(5,13,2));
        System.out.println(CountDiv.solution2(5,13,2));
    }

    private static void minAverageSlice() {
        int[] A = {4,2,2,5,1,5,8};
        int[] B = {10, 10, -1, 2, 4, -1, 2, -1};
        System.out.println(MinAverageSlice.solution2(A));
    }

    private static void maxBinarySlice() {
        int[] A = {1,1,0,1,0,0,1,1};
        System.out.println(TrekSwin.solution(A));
    }

    private static void maxCounters() {
        int[] A = {3,4,4,3,3,6,1,4,4};
        System.out.println(Arrays.toString(MaxCounters.solution(5, A)));
    }

    private static void smallMissingElement() {
        int[] A = {1,3,6,4,1,2};
        int[] B = {1,2,3};
        int[] C = {-1,-3};
        System.out.println(SmallMissingElement.solution1(A));
    }

    private static void frogRiver() {
        int[] A = {1,3,1,4,2,3,5,4};
        System.out.println(FrogRiver.calc(5, A));
    }

    private static void permutation() {
        int[] A = {2,1,3,5,4};
        System.out.println(Permutation.isPermutation(A));
    }

    private static void tapeEquilibrium() {
        int[] A = {3,1,2,4,3};
        System.out.println(TapeEquilibrium.calculate(A));
    }

    private static void missingElement() {
        int[] A = {1};
        System.out.println(MissingElement.solution3(A));
    }

    private static void frogJump(int calculate) {
        System.out.println(calculate);
    }

    private static void rotationArray() {
        int[] A = new int[0];
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(RotationArray.rotate(A, 3)));
    }

    private static void unpareidElement() {
        int[] A = {1,4,7,4,7,2,2};
        int[] B = {3, 3, 7, 9, 9, 9, 9};
        int[] C = {1};
        int[] D = {1,1,2,2,3};

        // SCORE 66
        System.out.println(UnpareidElement.searchElementList(A));
        // SCORE 100
        System.out.println(UnpareidElement.searchElementArraysSort(A));
    }

    private static void binaryGap() {
        System.out.println(BinaryGap.binaryGap(529));
    }
}
