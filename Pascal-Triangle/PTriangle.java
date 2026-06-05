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
            System.out.println("How many rows (1-10) would you like  to display?");
            int numRow = Integer.parseInt(scanner.nextLine());
             triangle.setRows(numRow);

            if (numRow < 1 || numRow > 10) {
                System.out.println("Please enter a number between 1 and 10.");
            }
            triangle.displayTriangle();
        }

        else if (choice.equals("v")) {
            System.out.println("Enter the row and column to find the value (starts at row 0).");
            System.out.print("row: ");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.print("col: ");
            int col = Integer.parseInt(scanner.nextLine());
            triangle.setRows(row);
            System.out.println("Value at (" + row + ", " + col + "): " + triangle.getValue(row-1, col));
        }

        else if (choice.equals("c")) {
            System.out.println("Enter n and r for nCr:");
            System.out.print("n: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.print("r: ");
            int r = Integer.parseInt(scanner.nextLine());
            nChooseR(n, r);
            System.out.println("nCr: " + nChooseR(n, r));
        }

        else {
            System.out.println("Please enter p, v, or c.");
        }
    }

    public void play() {
        System.out.println("Would you like to run the program? (y/n)");
        String ans = scanner.nextLine();
        while (ans.equals("y")) {
            runLayout();
            System.out.println("Would you like to run the program again? (y/n)");
            ans = scanner.nextLine();

        }
        System.out.println("Come again next time!");

    }
}