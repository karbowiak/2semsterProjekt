package tools;

import java.util.Scanner;

public class StringTools {
    public static void printMessage(String text){
        System.out.println(text);
    }

    public static int inputInt(String request) {
        boolean ok = false;
        int line = 0;
        while(!ok) {
            Scanner keyboard = new Scanner(System.in);
            printMessage(request);
            try {
                line = keyboard.nextInt();
                ok = true;
            }
            catch (Exception e) {
                printMessage("Input has to be a number - try again!\n");
                keyboard.nextLine();
            }
        }
        return line;
    }

    public static float inputFloat(String request) {
        boolean ok = false;
        int line = 0;
        while(!ok) {
            Scanner keyboard = new Scanner(System.in);
            printMessage(request);
            try {
                line = keyboard.nextInt();
                ok = true;
            }
            catch (Exception e) {
                printMessage("Input has to be a number - try again!\n");
                keyboard.nextLine();
            }
        }
        return line;
    }

    public static String inputString(String request) {
        boolean ok = false;
        String line = "";
        while(!ok) {
            Scanner keyboard = new Scanner(System.in);
            printMessage(request);
            try {
                line = keyboard.nextLine();
                ok = true;
            }
            catch (Exception e) {
                printMessage("Not valline input - try again!\n");
                keyboard.nextLine();
            }
        }
        return line;
    }
}
