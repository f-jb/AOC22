import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int priority = 0;

        try {
            Scanner scanner = new Scanner(new File("input"));
            while (scanner.hasNext()) {
                //String backpack = scanner.nextLine();
                String firstBackpack = scanner.nextLine();
                String secondBackpack = scanner.nextLine();
                String thirdBackpack = scanner.nextLine();
                //String firstCompartment = backpack.substring(0, (backpack.length() / 2));
                //String secondCompartment = backpack.substring((backpack.length() / 2));
                //char duplicate = checkDuplicates(firstCompartment,secondCompartment);
                //if(duplicate != '\u0000'){
                //    priority += calcPrio(duplicate);
               // }
                List<Character> duplicate = checkDuplicates(firstBackpack,secondBackpack);
                List<Character> trippelDuplicate = checkDuplicates(duplicate.toString(), thirdBackpack);

                priority += calcPrio(trippelDuplicate.get(0));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        System.out.println(priority);
    }

    static int calcPrio(char c) {
        if (Character.isLowerCase(c)) {
            return c - 96;
        } else {
            return c - 38;
        }
    }
    static List<Character> checkDuplicates(String firstCompartment, String secondCompartment){
        List<Character> charList = new ArrayList<>();


        for (char c : firstCompartment.toCharArray()) {
           for(char d: secondCompartment.toCharArray()) {
               if(c == d){
                   charList.add(c);
               }
           }
        }
        return charList;


    }
}