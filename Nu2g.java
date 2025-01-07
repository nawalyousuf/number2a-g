import java.util.Scanner;

public class TimeValidator {

    // Method to validate time input
    public static double validateTimeInput(String time) {
        try {
            // Try converting the input to a double
            double parsedTime = Double.parseDouble(time);
            
            // Check if the time is negative
            if (parsedTime < 0) {
                throw new IllegalArgumentException("Time cannot be negative.");
            }
            return parsedTime;
        } catch (NumberFormatException | IllegalArgumentException e) {
            // Handle invalid input and print a meaningful error message
            System.out.println("Error: " + e.getMessage());
            return -1;  // Return -1 to indicate invalid input
        }
    }

    public static void processTimes(String startTime, String endTime) {
        // Validate the times
        double start = validateTimeInput(startTime);
        double end = validateTimeInput(endTime);

        // Check if the times are valid
        if (start == -1 || end == -1) {
            System.out.println("Error: Invalid time input. Please ensure both start and end times are valid.");
            return;
        }

        // Check if start time is before end time
        if (start >= end) {
            System.out.println("Error: Start time must be earlier than end time.");
            return;
        }

        // Calculate and display the duration
        double duration = end - start;
        System.out.println("Duration: " + duration + " hours");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for start and end time
        System.out.print("Enter start time: ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time: ");
        String endTime = scanner.nextLine();

        // Process the times
        processTimes(startTime, endTime);

        scanner.close();
    }
}
