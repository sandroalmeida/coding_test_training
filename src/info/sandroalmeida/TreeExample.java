package info.sandroalmeida;// Java program to insert element in binary tree
import java.util.LinkedList;
import java.util.Queue; 
public class TreeExample {
	
	/* A binary tree node has key, pointer to 
	left child and a pointer to right child */
	static class Node { 
		int key; 
		Node left, right; 
		
		// constructor 
		Node(int key){ 
			this.key = key; 
			left = null; 
			right = null; 
		} 
	} 
	static Node root;
	
	/*function to insert element in binary tree */
	static void insert(Node temp, int key) 
	{ 
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(temp); 
	
		// Do level order traversal until we find 
		// an empty place. 
		while (!q.isEmpty()) { 
			temp = q.peek(); 
			q.remove(); 
	
			if (temp.left == null) { 
				temp.left = new Node(key); 
				break; 
			} else
				q.add(temp.left); 
	
			if (temp.right == null) { 
				temp.right = new Node(key); 
				break; 
			} else
				q.add(temp.right); 
		} 
	}

	public static void levelOrder(Node initial){

		Queue<Node> queue = new LinkedList<>();
		queue.add(initial);

		while(!queue.isEmpty()){

			Node temp = queue.poll();
			System.out.print(temp.key + " ");

			if(temp.left != null) queue.add(temp.left);
			if(temp.right != null) queue.add(temp.right);

		}
	}

	public static void preorder(Node node){

		//<Root><Left><Right>
		if(node == null)
			return;
		System.out.print(node.key + " ");

		preorder(node.left);
		preorder(node.right);
	}

	public static void inorder(Node node)
	{
		//<Left><Root><Right>
		if(node == null)
			return;

		inorder(node.left);
		System.out.print(node.key+" ");
		inorder(node.right);
	}

	public static void postorder(Node node)
	{
		//<Left><Right><Root>
		if(node == null)
			return;

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key+" ");
	}

} 

