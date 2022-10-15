package assignment3;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0 ; i < candidates.length; i++){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(candidates[i]);
            helper(list, set, candidates, target, candidates[i], tempList);
        }
        return list;
    }

    private void helper(List<List<Integer>> list, HashSet<List<Integer>> set, int[] candidates, int target, int sum, List<Integer> tempList){
        if(sum > target){
            tempList.remove(tempList.size() - 1);
            return;
        }
        if(sum == target){
            List<Integer> newTempList = new ArrayList<>(tempList);
            Collections.sort(newTempList);
            if(!set.contains(newTempList)){
                list.add(newTempList);
                set.add(newTempList);
            }
            tempList.remove(tempList.size() - 1);
            return;
        }
        if(sum < target){
            for(int i = 0 ; i < candidates.length; i++){
                tempList.add(candidates[i]);
                helper(list, set, candidates, target, sum + candidates[i], tempList);
            }
            tempList.remove(tempList.size() - 1);
        }
    }
}
