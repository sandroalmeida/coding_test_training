package info.sandroalmeida;//Java implementation of SpecialStack
// Note : here we use Stack class for Stack implementation 

import java.util.Stack; 

/* A class that supports all the stack operations and one additional 
operation getMin() that returns the minimum element from stack at 
any time. This class inherits from the stack class and uses an 
auxiliary stack that holds minimum elements */

class SpecialStack extends Stack<Integer> 
{ 
	Stack<Integer> min = new Stack<>(); 
	
	/* SpecialStack's member method to insert an element to it. This method 
	makes sure that the min stack is also updated with appropriate minimum 
	values */
	void push(int x) 
	{ 
		if(isEmpty() == true) 
		{ 
			super.push(x); 
			min.push(x); 
		} 
		else
		{ 
			super.push(x); 
			int y = min.peek();
			if(x <= y)
				min.push(x); 
//			else
//				min.push(y);
		} 
	} 

	/* SpecialStack's member method to insert an element to it. This method 
	makes sure that the min stack is also updated with appropriate minimum 
	values */
	public Integer pop() 
	{ 
		int x = super.pop(); 
		int y = min.pop();

		if(y != x)
			min.push(y);
		return x; 
	} 

	/* SpecialStack's member method to get minimum element from it. */
	int getMin() 
	{
		return min.peek();
	}

	@Override
	public synchronized String toString() {
		return super.toString() + '\n' + min.toString();
	}
}
