package assignment3;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        helper(list, s, 0, 0, n);
        return list;
    }

    private void helper(List<String> list, String s, int left, int right, int max){
        if(left == max && right == max){
            list.add(s);
            return;
        }

        if(right < left){
            helper(list, s + ")", left, right + 1, max);
        }

        if(left < max){
            helper(list, s + "(", left + 1, right, max);
        }
    }
}
