import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriathlonResults {

    // Private attributes for encapsulation
    private String name;
    private int swimmingTime;
    private int cyclingTime;
    private int runningTime;

    // Constructor
    public TriathlonResults(String name, int swimmingTime, int cyclingTime, int runningTime) {
        this.name = name;
        setSwimmingTime(swimmingTime);
        setCyclingTime(cyclingTime);
        setRunningTime(runningTime);
    }

    // Public getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    // Public getter and setter for swimmingTime
    public int getSwimmingTime() {
        return swimmingTime;
    }

    public void setSwimmingTime(int swimmingTime) {
        if (swimmingTime < 0) {
            throw new IllegalArgumentException("Swimming time cannot be negative.");
        }
        this.swimmingTime = swimmingTime;
    }

    // Public getter and setter for cyclingTime
    public int getCyclingTime() {
        return cyclingTime;
    }

    public void setCyclingTime(int cyclingTime) {
        if (cyclingTime < 0) {
            throw new IllegalArgumentException("Cycling time cannot be negative.");
        }
        this.cyclingTime = cyclingTime;
    }

    // Public getter and setter for runningTime
    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        if (runningTime < 0) {
            throw new IllegalArgumentException("Running time cannot be negative.");
        }
        this.runningTime = runningTime;
    }

    // Method to calculate total time
    public int calculateTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

    // Method to display participant details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Total Time: " + calculateTotalTime() + " minutes");
    }

    // Method to find and print the fastest and second-fastest participants, handling ties
    public static void findFastestParticipants(ArrayList<TriathlonResults> participants) {
        if (participants.size() < 2) {
            System.out.println("Not enough participants to determine the fastest and second-fastest.");
            return;
        }

        // Sort participants by total time
        participants.sort(Comparator.comparingInt(TriathlonResults::calculateTotalTime));

        // Identify the fastest total time
        int fastestTime = participants.get(0).calculateTotalTime();
        System.out.println("Fastest Participants:");
        for (TriathlonResults participant : participants) {
            if (participant.calculateTotalTime() == fastestTime) {
                System.out.println("- Name: " + participant.getName() + ", Total Time: " + fastestTime + " minutes");
            }
        }

        // Identify the second fastest total time
        int secondFastestTime = -1;
        for (TriathlonResults participant : participants) {
            if (participant.calculateTotalTime() > fastestTime) {
                secondFastestTime = participant.calculateTotalTime();
                break;
            }
        }

        if (secondFastestTime != -1) {
            System.out.println("\nSecond Fastest Participants:");
            for (TriathlonResults participant : participants) {
                if (participant.calculateTotalTime() == secondFastestTime) {
                    System.out.println("- Name: " + participant.getName() + ", Total Time: " + secondFastestTime + " minutes");
                }
            }
        } else {
            System.out.println("\nNo second fastest participant.");
        }

        // Print sorted results
        System.out.println("\nSorted Results by Total Time:");
        for (int i = 0; i < participants.size(); i++) {
            TriathlonResults participant = participants.get(i);
            System.out.println((i + 1) + ". Name: " + participant.getName() + ", Total Time: " + participant.calculateTotalTime() + " minutes");
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Creating participant objects
        ArrayList<TriathlonResults> participants = new ArrayList<>();
        participants.add(new TriathlonResults("Alice", 25, 40, 20));
        participants.add(new TriathlonResults("Bob", 20, 35, 25));
        participants.add(new TriathlonResults("Charlie", 30, 50, 30));
        participants.add(new TriathlonResults("Diana", 28, 42, 18));
        participants.add(new TriathlonResults("Eve", 25, 40, 20)); // Same time as Alice

        // Displaying details of each participant
        for (TriathlonResults participant : participants) {
            participant.displayDetails();
            System.out.println();
        }

        // Finding and printing the fastest participants
        findFastestParticipants(participants);
    }
}

class EliteParticipant extends TriathlonResults {
    // New attribute for sponsor name
    private String sponsorName;

    // Constructor
    public EliteParticipant(String name, int swimmingTime, int cyclingTime, int runningTime, String sponsorName) {
        super(name, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

    // Getter and setter for sponsorName
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        if (sponsorName == null || sponsorName.isEmpty()) {
            throw new IllegalArgumentException("Sponsor name cannot be null or empty.");
        }
        this.sponsorName = sponsorName;
    }

    // Overriding displayDetails method to include sponsor information
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sponsor Name: " + sponsorName);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        EliteParticipant eliteAlice = new EliteParticipant("Alice", 25, 40, 20, "HealthCo");
        EliteParticipant eliteBob = new EliteParticipant("Bob", 20, 35, 25, "FitCorp");

        // Displaying details of elite participants
        eliteAlice.displayDetails();
        System.out.println();
        eliteBob.displayDetails();
    }
}

class BeginnerParticipant extends TriathlonResults {
    // Constructor
    public BeginnerParticipant(String name, int swimmingTime, int cyclingTime, int runningTime) {
        super(name, swimmingTime, cyclingTime, runningTime);
    }

    // Retains the base class implementation of displayDetails
    public static void main(String[] args) {
        BeginnerParticipant beginnerCharlie = new BeginnerParticipant("Charlie", 30, 50, 30);
        BeginnerParticipant beginnerDiana = new BeginnerParticipant("Diana", 28, 42, 18);

        // Displaying details of beginner participants
        beginnerCharlie.displayDetails();
        System.out.println();
        beginnerDiana.displayDetails();
    }
}
