package assignment3;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int all = list.size();
            for(int j = 0; j < all; j++){
                List<Integer> tempList = new ArrayList<>(list.get(j));
                tempList.add(nums[i]);
                list.add(tempList);
            }
        }
        return list;
    }
}
