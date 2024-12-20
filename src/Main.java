import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> list = new ArrayList<String>();
    private static String fileName = null;
    private static Scanner scan = new Scanner(System.in);
    private static boolean saved = true;



    public static void main(String[] args) throws IOException {
        boolean infinity = true;
        display();
        do {
            System.out.println("Please select an option:" + "\nO - Open File \nD - Delete" + "\nA - Add" + "\nV - View list" + "\nQ - Quit program");

            String userInput = InputHelper.getRedExString(scan, "", "[AaDdPpQqOoSsCcVv]");
            if (userInput.equalsIgnoreCase("a")) {
                add();
                display();
            } else if (userInput.equalsIgnoreCase("q")) {
                quit();
            } else if (userInput.equalsIgnoreCase("v")) {
                display();
            } else if (userInput.equalsIgnoreCase("d")) {
                delete();
            } else if (userInput.equalsIgnoreCase("o")) {
                open();
            } else if (userInput.equalsIgnoreCase("c")) {
                clear();
            } else if (userInput.equalsIgnoreCase("s")) {
                save();
            }
        }while(infinity);

    }

    private static void quit() throws IOException {
        if (!saved){
            boolean saveWant = InputHelper.getYNConfirm(scan, "Do you want to save what you have?");
            if (saveWant) {
                save();
            }
        }
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
        saved = false;
    }
    private static void display() {
        for (int i = 1; i < list.size() + 1; i++){
            System.out.printf("%d %s %5s", i, ".", list.get(i - 1));
            System.out.println();
        }
        System.out.println();
    }
    private static void delete() {
        if (list.size() == 0) {
            System.out.println("There is nothing to delete");
            return;
        }
        System.out.println("where do you want to remove an item?");
        int position = InputHelper.getRangedInt(scan, "where do you want to remove an item?", 1, list.size());
        list.remove(position - 1);
    }
    private static void clear() {
        list = new ArrayList<>();
    }
    private static void save() throws IOException {
        if (fileName == null) {
            fileName = InputHelper.getNonZeroLenString(scan, "What would you like to name this file?");
        }
        //IOHelper.writeFile(clearList, fileName);
        IOHelper.writeFile(list, fileName);
    }
    private static void open() throws IOException {
        list = new ArrayList<>();
        if (!saved){
            boolean saveWant = InputHelper.getYNConfirm(scan, "Do you want to save what you have?");
            if (saveWant) {
                save();
            }
        }
        try {
            fileName = IOHelper.openFile(list);
            saved = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
