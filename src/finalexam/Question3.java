package finalexam;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        // Time Complexity O(n)
        String s1 = "lee(t(c)o)de)";
        String s2 = "a)b(c)d";
        String s3 = "))((";
        System.out.println(parentheses(s1));
    }

    public static String parentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) set.add(i);
                else stack.pop();
            }
        }
        while(!stack.isEmpty()) set.add(stack.pop());
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(i)) res += s.charAt(i);
        }
        return res;
    }
}