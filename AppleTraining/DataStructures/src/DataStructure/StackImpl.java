package DataStructure;

import java.util.*;

public class StackImpl {
	static void stack_push(Stack<Integer> s)
	{
		for(int i=0; i<5; i++)
			s.push(i);
	}
	
	static void stack_pop(Stack<Integer> s)
	{
		for(int i=0; i<5; i++) 
		{
			Integer y= (Integer) s.pop();
			System.out.println(y);
		}
	}
	
	static void stack_peek(Stack<Integer> s)
	{
		Integer y = (Integer) s.peek();
	}
	
	static void stack_search(Stack<Integer> s, int element)
	{
		Integer pos= (Integer) s.search(element);
		
		if(pos==-1)
			System.out.println("Element not found");
		
		else
			System.out.println("Element found at position: " + pos);
		for(int i=0; i<5; i++)
			s.push(i);
	}
	
	public static void main(String args[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack_push(stack);
		stack_pop(stack);
		stack_push(stack);
		stack_peek(stack);
		stack_search(stack,2);
		stack_search(stack,11);
	}
}
