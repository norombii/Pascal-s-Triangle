import java.util.ArrayList;
import java.util.Arrays;

public class Layout {

    public int totalRows;
    private int[][] triangle = new int[totalRows][]; 


    public Layout() {
        fillTriangle();
    }

    public int[][] triangleShape() {
        for (int r = 0; r < totalRows; r++) {
            triangle[r] = new int [r+1];
        }
        return triangle;
    }

     public int[][] fillTriangle() {
        for (int r = 0; r < totalRows; r++) {
            int currVal = 1;
            for (int c = 0; c < r + 1; c++) {
                triangle [r][c] = currVal;
            }
            currVal = (currVal * (r-c)/(c+1));
        }
        return triangle;
    }

    public void displayTriangle() {
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < r + 1; c++) {
                System.out.print(triangle[r][c] + " ");
            }
            System.out.println();
        }
    }

    public void setRow(int r) {
        totalRows = r;
    }


    

