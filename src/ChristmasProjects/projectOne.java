package ChristmasProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class projectOne {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sarah\\IdeaProjects\\Projects\\project1.txt";
        int[] numbers = readNumbersFromFile(filePath);
        sortNumbers(numbers);
        printNumbers(numbers);
    }

    public static int[] readNumbersFromFile(String filePath) {
        int[] numbers = new int[49];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+"); // αυτό δεν θυμάμαι να το βλέπουμε παρέα ,
                                                               // κατλαβαίνω πώς λειτουργεί
                                                              // απλά επειδή το βρήκα στο chat θα ήθελα να το μάθω σωστά, να μου το εξηγήσετε και εσείς λίγο αν είναι εύκολο.
                    for (String part : parts) {
                        if (count < numbers.length) {
                            numbers[count++] = Integer.parseInt(part);
                        } else {
                            System.out.println("Number not included.");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found." + e.getMessage());
        }
        return Arrays.copyOf(numbers, count);
    }

    public static void sortNumbers(int[] numbers) {
        Arrays.sort(numbers);
    }

    public static void printNumbers(int[] numbers) {
        System.out.print("Sorted numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
// Για τους συνδυασμούς, θα πρέπει να γράψω μία for, όπου οι αριθμοί μου θα διαιρούνται με το 2 και θα δίνουν 0,
// θα διαιρούνται με το 2 και θα δίνουν 1.
// Θα πάρω το αριστερό και το δεξί μέρος ξεχωριστά με το % και το /, για να βρω τη δεκάδα και την κατάληξη.