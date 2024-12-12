import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        }

    private static void quit(String prompt) {
        boolean quit = false;
        quit = InputHelper.getYNConfirm(scan, "Do you want to quit?");
        if (quit) {
            System.exit(0);
        } else {

        }
    }
    }
