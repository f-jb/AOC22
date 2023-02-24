import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] highestCalories = new int[3];

        int currentCalories = 0;
        try {
            Scanner scanner = new Scanner(new File("input"));
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (input.isBlank()) {
                    if (currentCalories < highestCalories[0]) {
                        currentCalories = 0;
                    } else {
                        highestCalories[0] = currentCalories;

                        for (int i=0;i<highestCalories.length-1;i++){
                           for( int j =0; j<highestCalories.length-i-1; ++j) {
                               if(highestCalories[j+1]<highestCalories[j]){
                                   int swap = highestCalories[j];
                                   highestCalories[j] = highestCalories[j+1];
                                   highestCalories[j+1] = swap;
                               }
                           }
                        }



                        // resets counter
                        currentCalories = 0;
                    }
                } else {
                    currentCalories += Integer.parseInt(input);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int sum =0;
        for (int i : highestCalories) {
           sum += i;
        }
        System.out.println(sum);
    }
}
