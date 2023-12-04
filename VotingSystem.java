import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void vote() {
        votes++;
    }
}

class VotingSystem {
    private Map<String, Candidate> candidates;

    public VotingSystem() {
        this.candidates = new HashMap<>();
    }

    public void addCandidate(String name) {
        Candidate candidate = new Candidate(name);
        candidates.put(name, candidate);
        System.out.println("Candidate added successfully: " + name);
    }

    public void displayCandidates() {
        System.out.println("List of Candidates:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName());
        }
    }

    public void vote(String candidateName) {
        Candidate candidate = candidates.get(candidateName);
        if (candidate != null) {
            candidate.vote();
            System.out.println("Vote for " + candidateName + " recorded successfully.");
        } else {
            System.out.println("Invalid candidate name. Please choose a candidate from the list.");
        }
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding candidates
        votingSystem.addCandidate("Candidate 1");
        votingSystem.addCandidate("Candidate 2");
        votingSystem.addCandidate("Candidate 3");

        while (true) {
            System.out.println("\nVoting System Menu:");
            System.out.println("1. Display Candidates");
            System.out.println("2. Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    votingSystem.displayCandidates();
                    break;

                case 2:
                    System.out.print("Enter the name of the candidate you want to vote for: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.vote(candidateName);
                    break;

                case 3:
                    votingSystem.displayResults();
                    break;

                case 4:
                    System.out.println("Exiting Voting System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}