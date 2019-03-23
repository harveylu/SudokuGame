package SudokuPackage;

import static org.junit.Assert.*;

public class SudokuTest {

    Sudoku obj = new Sudoku();

    @org.junit.Test
    public void SudokuTrue() {
        int[][] test = {{2,5,6,1,4,7,8,3,9},{3,1,8,2,5,9,4,7,6},{4,7,9,3,6,8,1,5,2},{1,6,2,4,3,5,9,8,7},{5,8,3,9,7,1,2,6,4},
                {7,9,4,6,8,2,3,1,5},{8,2,7,5,9,3,6,4,1},{6,3,1,7,2,4,5,9,8},{9,4,5,8,1,6,7,2,3}};
        int[][] test1 = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
        int[][] test2 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,6,2,3},
                {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
        assertEquals(true, obj.checkValid(test));
        assertEquals(true, obj.checkValid(test1));
        assertEquals(true, obj.checkValid(test2));
    }

    @org.junit.Test
    public void SudokuFalse(){
        int[][] test3 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {0,4,1,7,9,5,6,2,3},
                {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
        int[][] test4 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,4,1,7,9,5,10,2,3},
                {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,7,9,4,1,3,8,5}};
        int[][] test5 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,4}, {8,-1,1,7,9,5,6,2,3},
                {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,5,9,4,1,3,8,7}};
        int[][] test6 = {{4,2,9,8,1,3,5,6,7}, {5,1,6,4,7,2,9,3,8}, {7,8,3,6,5,9,2,4,1},
                {6,7,2,1,3,4,8,5,9}, {3,9,5,2,8,6,1,7,9}, {8,4,1,7,9,5,6,2,3},
                {1,5,8,3,6,7,4,9,2}, {9,3,4,5,2,8,7,1,6}, {2,6,5,9,4,1,3,8,7}};
        assertEquals(false, obj.checkValid(test3));
        assertEquals(false, obj.checkValid(test4));
        assertEquals(false, obj.checkValid(test5));
        assertEquals(false, obj.checkValid(test6));
    }

    @org.junit.Test
    public void SudokuTrueRandomGenerator(){
        int[][] test;
        int i = 100;
        while(i > 0){
            test = SudokuGenerator.generator(true);
            assertEquals(true, obj.checkValid(test));
            i--;
        }
    }

    @org.junit.Test
    public void SudokuFalseRandomGenerator(){
        int[][] test;
        int i = 100;
        while(i > 0){
            test = SudokuGenerator.generator(false);
            assertEquals(false, obj.checkValid(test));
            i--;
        }
    }
}