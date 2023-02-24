import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        HashMap<String, Integer> responseScoring = new HashMap<>();
        responseScoring.put("X", 1); // Rock
        responseScoring.put("Y", 2); // Paper
        responseScoring.put("Z", 3); // Scissor

        try {
            Scanner scanner = new Scanner(new File("input"));
            while (scanner.hasNext()) {
                char[] round = scanner.nextLine().toCharArray();
                char challenge = round[0];
                char response = round[2];
                response = secretStrategy(challenge, response);
                score += responseScoring.get(Character.toString(response));
                score += challengeResponse(challenge, response);


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(score);

    }

    static char secretStrategy(char challenge, char response) {
        HashMap<String, String> draw = new HashMap<String, String>();
        draw.put("A", "X"); // Rock
        draw.put("B", "Y"); // Paper
        draw.put("C", "Z"); // Scissor
        HashMap<String, String> lose = new HashMap<String, String>();
        lose.put("A", "Z"); // Rock
        lose.put("B", "X"); // Paper
        lose.put("C", "Y"); // Scissor
        HashMap<String, String> win = new HashMap<String, String>();
        win.put("A", "Y"); // Rock
        win.put("B", "Z"); // Paper
        win.put("C", "X"); // Scissor
        if (response == 'Y') {
            return draw.get(Character.toString(challenge)).toCharArray()[0];
        }
        // Needs to lose.
        if (response == 'X') {

            return lose.get(Character.toString(challenge)).toCharArray()[0];
        }

        // needs to win
        if (response == 'Z') {
            return win.get(Character.toString(challenge)).toCharArray()[0];

        }
        return 'A';
    }

    static int challengeResponse(char challenge, char response) {
        if (challenge == 'A') {
            return response == 'X' ? 3 : response == 'Y' ? 6 : 0;
        }
        if (challenge == 'B') {
            return response == 'Y' ? 3 : response == 'Z' ? 6 : 0;
        }
        if (challenge == 'C') {
            return response == 'Z' ? 3 : response == 'X' ? 6 : 0;
        }
        return 0;

    }
}