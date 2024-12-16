import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> list = new ArrayList<String>();
    private static Scanner scan = new Scanner(System.in);



    public static void main(String[] args) {
        list.addAll(Arrays.asList("Ethan", "Emory", "Tree"));
        boolean infinity = true;
        display();
        do {
            System.out.println("Please select an option:" + "\nD - Delete" + "\nA - Add" + "\nP - Print list" + "\nQ - Quit program");

            String userInput = InputHelper.getRedExString(scan, "", "[AaDdPpQq]");
            if (userInput.equalsIgnoreCase("a")) {
                add();
                display();
            } else if (userInput.equalsIgnoreCase("q")) {
                quit();
            } else if (userInput.equalsIgnoreCase("p")) {
                display();
            } else if (userInput.equalsIgnoreCase("d")) {
                delete();
            }
        }while(infinity);

    }

    private static void quit() {
        boolean quit = false;
        quit = InputHelper.getYNConfirm(scan, "Do you want to quit?");
        if (quit) {
            System.exit(0);
        }
    }

    private static void add() {
        String addition = InputHelper.getNonZeroLenString(scan, "Please type what you would like to add:");
        int position = InputHelper.getRangedInt(scan, "Where do you want to insert it? [1-" + (list.size() + 1) + "]", 1, list.size() + 1);
        if (position > list.size()){
            list.add(addition);
        } else {
            list.add(position - 1,addition);
        }
    }
    private static void display() {
        for (int i = 1; i < list.size() + 1; i++){
            System.out.printf("%d %s %5s", i, ".", list.get(i - 1));
            System.out.println();
        }
        System.out.println();
    }
    private static void delete() {
        System.out.println("where do you want to remove an item?");
        int position = InputHelper.getRangedInt(scan, "where do you want to remove an item?", 1, list.size());
        list.remove(position - 1);
    }


}
