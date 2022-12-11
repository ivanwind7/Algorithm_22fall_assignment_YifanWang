package midTerm.Question5.untitled.src;

public class Main {
    public static void main(String[] args) {
        // O(n)
        int[] arr = new int[]{0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = new int[]{1,4,5,10};
        int[] res = getStartOfEachValues(arr, values);
        for(int i: res){
            System.out.print(i + " ");
        }
    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 11, 16]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        for(int i = 0, index = 0; index < values.length;){
            if(arr[i] > values[index]){
                indexes[index++] = -1;
            }
            if(arr[i] == values[index]){
                indexes[index++] = i;
                while(i + 1 < arr.length && arr[i] == arr[i + 1]){
                    i++;
                }
                i++;
            }
            else i++;
        }

        return indexes;
    }
}