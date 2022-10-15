package assignment3;

import java.util.*;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int wordIndex = 0;
        List<List<Integer>> startPosition = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(wordIndex)){
                    List<Integer> tempList = new ArrayList<>(Arrays.asList(i, j));
                    startPosition.add(tempList);
                }
            }
        }

        for(int i = 0; i < startPosition.size(); i++){
            HashSet<List<Integer>> set = new HashSet<>();
            if(helper(board, word, wordIndex, set, startPosition.get(i))){
                return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int wordIndex, HashSet<List<Integer>> set, List<Integer> positionNow){
        if(wordIndex == word.length()){
            return true;
        }
        if(positionNow.get(0) < 0 || positionNow.get(0) >= board.length || positionNow.get(1) < 0 || positionNow.get(1) >= board[0].length){
            return false;
        }

        if(board[positionNow.get(0)][positionNow.get(1)] == word.charAt(wordIndex) && !set.contains(positionNow)){
            set.add(positionNow);
            wordIndex++;
            if(helper(board, word, wordIndex, set, new ArrayList<>(Arrays.asList(positionNow.get(0) - 1, positionNow.get(1)))) ||
                    helper(board, word, wordIndex, set, new ArrayList<>(Arrays.asList(positionNow.get(0) + 1, positionNow.get(1)))) ||
                    helper(board, word, wordIndex, set, new ArrayList<>(Arrays.asList(positionNow.get(0), positionNow.get(1) - 1))) ||
                    helper(board, word, wordIndex, set, new ArrayList<>(Arrays.asList(positionNow.get(0), positionNow.get(1) + 1)))){
                return true;
            }else{
                set.remove(positionNow);
                return false;
            }
        }else{
            return false;
        }
    }
}
