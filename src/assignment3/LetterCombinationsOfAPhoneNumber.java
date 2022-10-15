package assignment3;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }

        List<String> list = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap.put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxyz");

        for(int i = 0; i < digits.length(); i++){
            list = combineTwo(list, hashMap.get(String.valueOf(digits.charAt(i))));
        }

        return list;
    }

    private List<String> combineTwo(List<String> s, String A){
        List<String> newList = new ArrayList<String>();

        if(s.size() == 0){
            for(int j = 0; j < A.length(); j++){
                newList.add(String.valueOf(A.charAt(j)));
            }
            return newList;
        }

        for(int i = 0; i < s.size(); i++){
            for(int j = 0; j < A.length(); j++){
                newList.add(s.get(i) + String.valueOf(A.charAt(j)));
            }
        }
        return newList;
    }
}
