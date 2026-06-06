import java.math.BigInteger;
import java.util.Scanner;

public class PTriangle {

    Scanner scanner = new Scanner(System.in);
    Layout triangle = new Layout();

    public PTriangle() {
        play();
    }

    public static void clearScreen() {
        // Hacky gross unicode hack to clear console - Teacher
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
        System.out.println();
    }

    public BigInteger nChooseR(int n , int r) {
        if (r == 0 || r == n) {
            return BigInteger.ONE;
        }
        // changed this code to include BigInteger for overflow errors
        // found on internet
        BigInteger numerator = BigInteger.ONE;
        for (int i = n; i > n - r; i--) {
            numerator = numerator.multiply(BigInteger.valueOf(i));
        }

        BigInteger denominator = BigInteger.ONE;
        for (int i = r; i > 0; i--) {
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        return numerator.divide(denominator);
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
            System.out.println("Enter the row and column to find the value (0-33).");
            System.out.print("row: ");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.print("col: ");
            int col = Integer.parseInt(scanner.nextLine());

            // prevent overflow
            // found on internet
            if (row > 33) { 
                System.out.println("row limit is 33!");
            }     
            else if (col < 1 || col > row + 1) {
                System.out.println("Please enter a col between 1-" + (row+1));
            }
            else {
                triangle.setRows(row+1);
                BigInteger val = nChooseR(row, col - 1); 
                System.out.println("Value at (" + row + ", " + col + "): " + val);
            }
        }

        else if (choice.equals("c")) {
            System.out.println("Enter n (1-61) and r for nCr:");
            System.out.print("n: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.print("r: ");
            int r = Integer.parseInt(scanner.nextLine());

            if (n < 0 || r < 0) {
                System.out.println("Inputs have to be positive!");
            } 
            else if (r > n) {
                 System.out.println("r have to be less than n!");
            } 
            else if (n > 61) { 
                System.out.println("n is too large! Please enter a n less than 62!");
            } 
            else {
                nChooseR(n, r);
                System.out.println("nCr: " + nChooseR(n, r));
            }
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
            clearScreen();

        }
        System.out.println("Come again next time!");

    }
}