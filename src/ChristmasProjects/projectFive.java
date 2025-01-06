package ChristmasProjects;

import java.util.Scanner;

public class projectFive {
    private static final int ROWS = 30;
    private static final int COLUMNS = 12;
    private static boolean[][] seats = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selection;

        while (true) {
            System.out.print("Select : book/cancel/exit: ");
            selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Please select your seat (e.g. C2): ");
            String seatInput = scanner.nextLine();
            char column = seatInput.charAt(0);
            int row = Integer.parseInt(seatInput.substring(1)) - 1;

            if (selection.equalsIgnoreCase("book")) {
                book(column, row);
            } else if (selection.equalsIgnoreCase("cancel")) {
                cancel(column, row);
            } else {
                System.out.println("Please select:  'book', 'cancel', or 'exit'.");
            }
        }
    }

    private static void cancel(char column, int row) {
            int colIndex = column - 'A';

            if (row < 0 || row >= ROWS || colIndex < 0 || colIndex >= COLUMNS) {
                System.out.println("Invalid seat.");
                return;
            } else System.out.println("Seat Canceled Successfully.");
    }

    public static void book(char column, int row) {
        int colIndex = column - 'A';

        if (row < 0 || row >= ROWS || colIndex < 0 || colIndex >= COLUMNS) {
            System.out.println("Not valid seat.");
            return;
        }

        if (!seats[row][colIndex]) {
            seats[row][colIndex] = true; // Κλείσιμο θέσης
            System.out.println("Seat" + column + (row + 1) + " successfully booked.");
        } else {
            System.out.println("Seat" + column + (row + 1) + " not available.");
        }
    }
}