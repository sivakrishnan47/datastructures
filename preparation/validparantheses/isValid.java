package validparantheses;

import java.util.HashMap;
import java.util.Stack;

public class isValid {
	
	public static boolean isValidParantheses(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
	
	public static void main(String[] args){
		String str = "[]{}";
		boolean bool  = isValidParantheses(str);
		System.out.println("given string is valid parantheses"+ bool);
		
	}

}
