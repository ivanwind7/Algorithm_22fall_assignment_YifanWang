package assignment3;

import java.util.*;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            helper(list, n, k, i, 1);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    private void helper(List<Integer> list, int n, int k, int num, int digit){
        if(digit == n){
            list.add(num);
            return;
        }
        if(num % 10 + k > 9 && num % 10 - k < 0){
            return;
        }
        if(k != 0){
            if(num % 10 + k < 10){
                helper(list, n, k, num * 10 + num % 10 + k, digit + 1);
            }
            if(num % 10 - k >= 0){
                helper(list, n, k, num * 10 + num % 10 - k, digit + 1);
            }
        }else{
            helper(list, n, k, num * 10 + num % 10, digit + 1);
        }

    }
}
