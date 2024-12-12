import java.util.Scanner;

public class InputHelper {

    /*
     * Loops through until the user enters a valid int value
     * Displays error message and asks user to try again until valid input received
     */
    public static int getInt(Scanner scan, String prompt) {
        int num = 0; //eventually returned to user after validated
        boolean done = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                done = true;
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();

        } while (!done);
        return num;
    }

    /*
     * Loops through until the user enters a valid int value
     * Displays error message and asks user to try again until valid input received
     */
    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        int num = 0; //eventually returned to user after validated
        boolean done = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0) {
                    done = true;
                }
            } else {
                System.out.println("Invalid input. Please try again");

            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    /*
     * Loops through until the user enters a valid int value in the range
     */
    public static int getRangedInt(Scanner scan, String prompt, int minimum, int maximum) {
        int num = 0; //eventually returned to user after validated
        boolean done = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= minimum && num <= maximum) {
                    done = true;
                }
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while (!done);
        return num;
        /*
         * Loops through until the user enters a valid int value
         * Displays error message and asks user to try again until valid input received
         */
    }

    public static String getRedExString(Scanner scan, String prompt, String regExPattern) {
        String input; //Stores string from user
        boolean done = false;
        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.matches(regExPattern)) {
                done = true;
            } else {
                System.out.println("please match the required pattern");
            }
        } while (!done);
        return input;
    }

    /*
     * Loops through until the user enters a valid double value
     * Displays error message and asks user to try again until valid input received
     */
    public static double getDouble(Scanner scan, String prompt) {
        double num = 0; //eventually returned to user after validated
        boolean done = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                done = true;
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();

        } while (!done);
        return num;
    }

    /*
     * Loops through until the user enters a valid Double value within the given range
     * Displays error message and asks user to try again until valid input received
     */
    public static double getRangedDouble(Scanner scan, String prompt, double minimum, double maximum) {
        double num = 0; //eventually returned to user after validated
        boolean done = false;
        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                if (num >= minimum && num <= maximum) {
                    done = true;
                }
            } else {
                System.out.println("Invalid input. Please try again");
            }
            scan.nextLine();
        } while (!done);
        return num;

    }

    /*
     * Loops through until the user enters Y or N
     * Displays error message and asks user to try again until valid input received
     * Outputs a boolean
     */
    public static boolean getYNConfirm(Scanner scan, String prompt) {
        String input;
        boolean done = false;
        boolean trueFalse = false;
        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                done = true;
                trueFalse = true;
            } else if (input.equalsIgnoreCase("n")) {
                done = true;
            } else {
                System.out.println("Please input Y/N");
            }
        } while (!done);
        return trueFalse;
    }

    public static String getNonZeroLenString(Scanner scan, String prompt) {
        String input;
        boolean done = false;
        System.out.println(prompt);
        input = scan.nextLine();
        do {
            if (input.length() > 0) {
                done = true;
            } else {
                System.out.println("Please input a string above 0");
                scan.nextLine();
            }
        } while (!done);
        return input;
    }
}