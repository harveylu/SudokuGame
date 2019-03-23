package SudokuPackage;

import java.util.*;

public class SudokuGenerator {
    public static int[][] generator(boolean valid){
        int [][] defaultMatrix = {{1,5,9,2,3,8,4,6,7},{2,6,4,1,7,9,3,5,8},{3,8,7,4,5,6,9,1,2},{4,1,3,6,8,2,5,7,9},
                {7,2,6,5,9,4,1,8,3},{5,9,8,3,1,7,2,4,6},{6,3,1,7,2,5,8,9,4},{8,4,2,9,6,1,7,3,5},{9,7,5,8,4,3,6,2,1}};
        int[][] matrix = new int[9][9];
        Random random = new Random();
        List<Integer> inOrder = new ArrayList<>();
        for(int i = 1; i <= 9; i++ ){
            inOrder.add(i);
        }
        Collections.shuffle(inOrder);
        for(int i = 0; i < 5; i++)
            matrix[random.nextInt(8) + 1][random.nextInt(8) + 1] = inOrder.get(i);
        if(!solve(0,0, matrix)){
            if(valid) return defaultMatrix;
            else return new int[9][9];// solves in place
        }
        if(valid) return matrix;
        else{
            matrix[random.nextInt(8) + 1][random.nextInt(8) + 1] =
                    (matrix[random.nextInt(8) + 1][random.nextInt(8) + 1] + 1)%9;
            matrix[random.nextInt(8) + 1][random.nextInt(8) + 1] =
                    (matrix[random.nextInt(8) + 1][random.nextInt(8) + 1] + 8)%9;
            return matrix;
        }
    }

    static boolean solve(int i, int j, int[][] cells) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }
        if (cells[i][j] != 0)  // skip filled cells
            return solve(i+1,j,cells);

        for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val,cells)) {
                cells[i][j] = val;
                if (solve(i+1,j,cells))
                    return true;
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return false;
    }

    static boolean legal(int i, int j, int val, int[][] cells) {
        for (int k = 0; k < 9; ++k)  // row
            if (val == cells[k][j])
                return false;

        for (int k = 0; k < 9; ++k) // col
            if (val == cells[i][k])
                return false;

        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m)
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true; // no violations, so it's legal
    }

    static void writeMatrix(int[][] solution) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(solution[i][j] == 0
                        ? " "
                        : Integer.toString(solution[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public static void main(String[] args){
        int i = 100;
        while(i > 0){
            int[][] matrix = generator(true);
            i --;
            writeMatrix(matrix);
        }
//        int[][] matrix = generator(true);
//        writeMatrix(matrix);
    }
}
