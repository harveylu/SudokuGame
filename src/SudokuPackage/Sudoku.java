package SudokuPackage;


public class Sudoku {
    public boolean checkValid(int[][] input){
        int[][] result = new int[27][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(input[i][j] <= 0 || input[i][j] > 9) return false;
                if(!validate(result[i], input[i][j])) return false;
                if(!validate(result[9+j], input[i][j])) return false;
                if(!validate(result[3*(i/3) + j/3 + 18], input[i][j])) return false;
            }
        }
        return true;
    }

    public boolean validate(int[] block, int num){
        if(block[num-1] == 1) return false;
        else{
            block[num-1] = 1;
            return true;
        }
    }

    public static void main(String[] args){
        int[][] test = {{1,2,3,4,5,6,7,8,9},{4,5,6,7,8,9,1,2,3},{7,8,9,1,2,3,4,5,6},{3,1,2,6,4,5,9,7,8},
                {6,4,5,9,7,8,3,1,2},{9,7,8,3,1,2,6,4,5},{2,3,1,5,6,4,8,9,7},{8,9,7,2,3,1,5,6,4},{5,6,4,8,9,7,2,3,1}};
        Sudoku obj = new Sudoku();
        System.out.println(obj.checkValid(test));
    }
}
//    public static void main(String[] args){
//        int[][] test;
//        int i = 100;
//        Sudoku obj = new Sudoku();
//        while(i > 0){
//            test = SudokuGenerator.generator(false);
//            if(obj.checkValid(test) == true) SudokuGenerator.writeMatrix(test);
//            i--;
//        }
//    }


