public class Layout {

    public int totalRows;
    private int[][] triangle = new int[totalRows][]; 

    public Layout() {
        fillTriangle();
    }

    public void setRows(int r) {
        this.totalRows = r;
        this.triangle = new int[totalRows][];
        fillTriangle();
    }


     public int[][] fillTriangle() {

        for (int r = 0; r < totalRows; r++) {
            triangle[r] = new int[r + 1];

            triangle[r][0] = 1;
            triangle[r][r] = 1;

            for (int c = 1; c < r; c++) {
                triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
            }
        }
        return triangle;
    }

    public void displayTriangle() {

        for (int r = 0; r < triangle.length; r++) {
            for (int i = 0; i < totalRows - r; i++) {
                System.out.print(" ");
            }
            for (int c = 0; c < triangle[r].length; c++) {
                System.out.print(triangle[r][c] + " ");
            }
            System.out.println();
        }
    }

    public int getValue(int r, int c) {
        return triangle[r][c];
    }

}


    

