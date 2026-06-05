import java.util.Scanner;

public class PTriangle {

    Scanner scanner = new Scanner(System.in);
    Layout triangle = new Layout();

    public PTriangle() {
        play();
    }

    public int nChooseR(int n , int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        
        int numerator = 1;
        for (int i = n; i > n - r; i--) {
            numerator *= i;
        }
        int denominator = 1;
        for (int i = r; i > 0; i--) {
            denominator *= i;
        }
        return numerator / denominator;
    }

    public void runLayout() {

        System.out.println("Pascal's Triangle (p), specific value (v), or combination (c):");
        String choice = scanner.nextLine();

        if (choice.equals("p")) {
            System.out.println("How many rows (1-15) would you like  to display?");
            int numRow = Integer.parseInt(scanner.nextLine());
             triangle.setRow(numRow);

            if (numRow < 1 || numRow > 15) {
                System.out.println("Please enter a number between 1 and 15.");
            }
            
            triangle.triangleShape();
            triangle.fillTriangle();
            triangle.displayTriangle();
        }

        else if (choice.equals("v")) {
            System.out.println("Enter the row and column to find the value:");
            int row = Integer.parseInt(scanner.nextLine());
            int col = Integer.parseInt(scanner.nextLine());
            System.out.println("Value at (" + row + ", " + col + "): " + triangle.getValue(row, col));
        }
        else if (choice.equals("c")) {
            System.out.println("Enter n and r for nCr:");
            int n = Integer.parseInt(scanner.nextLine());
            int r = Integer.parseInt(scanner.nextLine());
            System.out.println("nCr: " + nChooseR(n, r));
        }
        else {
            System.out.println("Please enter p, v, or c.");
        }
    }

    public void play() {
        runLayout();
    }
}