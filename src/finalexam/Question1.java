package finalexam;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        // Time Complexity O(sum of each word's length)
        String[] strs1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = new String[]{""};
        String[] strs3 = new String[]{"a"};
        System.out.println(anagrams(strs1));
    }

    public static List<List<String>> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] tempArr = s.toCharArray();
            String tempSortedS = "";
            Arrays.sort(tempArr);
            for(char c: tempArr) tempSortedS = tempSortedS + c;
            if(map.containsKey(tempSortedS)) map.get(tempSortedS).add(s);
            else {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                map.put(tempSortedS,tempList);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()) res.add(e.getValue());
        return res;
    }
}