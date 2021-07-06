//package matrixCode;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Solution_exist {
//    public boolean exist(char[][] board, String word) {
//        boolean flag = true;
//        if(word.length() == 0) return false;
//        int row = board.length;
//        int col = board[0].length;
//        int count = 0;
//        ArrayList<int[]> site = new ArrayList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(board[i][j] == word.charAt(0)){
//                    int[] arr = {i,j};
//                    site.add(arr);
//                }
//            }
//        }
//        if(site.size() == 0) return false;
//        while(site.size() != 0){
//            int start_row = site.get(0)[0];
//            int start_col = site.get(0)[1];
//            judge(start_row,start_col,flag);
//            if(flag){
//                break;
//            }
//            site.remove(0);
//        }
//        return flag;
//    }
//    static void judge(int start_row, int start_col,boolean flag){
//        List<Integer> point = new ArrayList<>();
//
//        if(start_row ==0{
//            if(start_col == 0){
//                int[] points = {start_row,start_col+1,start_row+1,start_col};
//                point = Arrays.stream(points).boxed().collect(Collectors.toList());
//            }else if(){
//                int[] points = {start_row,start_col+1,start_row+1,start_col,start_row,start_col-1};
//                point = Arrays.stream(points).boxed().collect(Collectors.toList());
//            }
//        }
//    }
//}
