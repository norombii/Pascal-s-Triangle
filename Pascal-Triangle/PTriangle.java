public class PTriangle {

    Scanner scanner = new Scanner(System.in);


    public void runLayout() {

        System.out.println("How many rows would you like  to display?");
            Layout.row  = Integer.parseInt(scanner.nextLine());

    }

    /** what the heck
    public int nChooseR(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return nChooseR(n - 1, r - 1) + nChooseR(n - 1, r);
    }
    */

    public void play() {
        runLayout();
    }
}