import java.util.Scanner;

public class NumberOfDay {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] monthAbbreviations = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.",
                "Nov.", "Dec." };
        String[] monthAbbreviations2 = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec" };
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Get input for month and year
        
        int month = 0;
        int year = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the month: ");
            String monthInput = keyboard.nextLine().trim();
            System.out.print("Enter the year: ");
            String yearInput = keyboard.nextLine().trim();

            // Validate month input
            for (int i = 0; i < monthNames.length; i++) {
                if (monthInput.equalsIgnoreCase(monthNames[i]) || monthInput.equalsIgnoreCase(monthAbbreviations[i])
                        || monthInput.equalsIgnoreCase(monthAbbreviations2[i])
                        || monthInput.equals(String.valueOf(i + 1))) {
                    month = i + 1;
                    validInput = true;
                    break;
                }
            }

            // Validate year input
            try {
                year = Integer.parseInt(yearInput);
                validInput = validInput && year > 0;
            } catch (NumberFormatException e) {
                validInput = false;
            }

            if (!validInput) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        keyboard.close();

        // Check for leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Display number of days in the month
        if (month == 2 && isLeapYear) {
            System.out.println("February " + year + " has 29 days.");
        } else {
            System.out.println(monthNames[month - 1] + " " + year + " has " + monthDays[month - 1] + " days.");
        }
    }
}
