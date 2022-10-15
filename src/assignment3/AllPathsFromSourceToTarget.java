package assignment3;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        helper(graph, 0, list, new ArrayList<>());
        return list;
    }

    private void helper(int[][] graph, int index, List<List<Integer>> list, List<Integer> tempList){
        tempList.add(index);
        if(index == graph.length - 1){
            List<Integer> newTempList = new ArrayList<>(tempList);
            list.add(newTempList);
            return;
        }
        for(int i = 0; i < graph[index].length; i++){
            helper(graph, graph[index][i], list, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
