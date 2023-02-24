import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int overlap = 0;
        int totalOverlap = 0;
        Scanner scanner = new Scanner(new File("input"));
        while (scanner.hasNext()) {
            String[] elfPair = scanner.nextLine().split(",");
            int[] firstElf = {Integer.parseInt(elfPair[0].split("-")[0]), Integer.parseInt(elfPair[0].split("-")[1])};
            int[] secondElf = {Integer.parseInt(elfPair[1].split("-")[0]), Integer.parseInt(elfPair[1].split("-")[1])};
            if (checkOverlap(firstElf, secondElf)) { overlap++; }
            if (checkAllOverlap(firstElf, secondElf)) { totalOverlap++; }
        }
        System.out.println(overlap);
        System.out.println(totalOverlap);
    }

    static boolean checkOverlap(int[] firstElf, int[] secondElf) {
        return (firstElf[0] <= secondElf[0] && firstElf[1] >= secondElf[1]) || (firstElf[0] >= secondElf[0] && firstElf[1] <= secondElf[1]);
    }

    static boolean checkAllOverlap(int[] firstElf, int[] secondElf) {
        return ((firstElf[0] <= secondElf[1] && firstElf[0] >= secondElf[0]) ||
                (firstElf[1] <= secondElf[1] && firstElf[1] >= secondElf[0]) || checkOverlap(firstElf, secondElf));


    }

}