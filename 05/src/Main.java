import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input"));
        ArrayList<LinkedList<Character>> stacks;
        LinkedList<String> stackSetup = new LinkedList<>();
        boolean init = false;
        boolean upgraded = true;
        while (!init) {
            while (scanner.hasNext()) {
                String currentString = scanner.nextLine();
                if (currentString.isBlank()) {
                    init = true;
                    break;
                }
                stackSetup.add(currentString);
            }
        }
        int amountOfStacks = (stackSetup.getLast().length()+1)/4;

        stacks = new ArrayList<>(amountOfStacks);
        for (int i = 0; i<amountOfStacks;i++){
            stacks.add(new LinkedList<Character>());
        }

        stackSetup.removeLast();
        while (!stackSetup.isEmpty()) {
            for (int i = 0; i < amountOfStacks; i++) {
                if (Character.isAlphabetic(stackSetup.getLast().toCharArray()[i*4+1])) {
                    stacks.get(i).add(stackSetup.getLast().toCharArray()[i*4+1]);
                }
            }
            stackSetup.removeLast();
        }
        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");

            int amountToMove = Integer.parseInt(line[1]);
            int from = Integer.parseInt(line[3]) - 1;
            int to = Integer.parseInt(line[5]) - 1;
            if(upgraded) {
                for (int i = amountToMove; i > 0; i--) {
                    stacks.get(to).addLast(stacks.get(from).get(stacks.get(from).size() - i));
                    stacks.get(from).remove(stacks.get(from).size() - i);
                }
            } else {
                for (int i = amountToMove; i > 0; i--) {
                    stacks.get(to).addLast(stacks.get(from).getLast());
                    stacks.get(from).removeLast();
                }
            }
        }
        String result = "";
        for (LinkedList l : stacks) {
            result = result.concat(Character.toString((Character) l.getLast()));
        }
        System.out.println(result);
        }
    }