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
        int[][] test;
        Sudoku obj = new Sudoku();
        for(int i = 0; i < 500; i++){
            test = SudokuGenerator.generator(true);
            SudokuGenerator.writeMatrix(test);
            if(obj.checkValid(test) == false) System.out.println("False!");
            System.out.println(i);
        }
    }
}
