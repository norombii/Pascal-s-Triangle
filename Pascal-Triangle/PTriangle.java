public class PTriangle {

    Scanner scanner = new Scanner(System.in);


    public void runLayout() {

        System.out.println("How many rows would you like  to display?");
            Layout.row  = Integer.parseInt(scanner.nextLine());

    }

    public void play() {
        runLayout();
    }
}