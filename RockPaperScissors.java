import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3); // 0,1,2
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            default: return "Scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        }
        if (userChoice.equalsIgnoreCase("Rock")) {
            return computerChoice.equalsIgnoreCase("Scissors") ? "Player" : "Computer";
        } else if (userChoice.equalsIgnoreCase("Paper")) {
            return computerChoice.equalsIgnoreCase("Rock") ? "Player" : "Computer";
        } else if (userChoice.equalsIgnoreCase("Scissors")) {
            return computerChoice.equalsIgnoreCase("Paper") ? "Player" : "Computer";
        }
        return "Invalid";
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        double playerPercent = ((double)playerWins / totalGames) * 100;
        double computerPercent = ((double)computerWins / totalGames) * 100;
        String[][] stats = new String[2][2];
        stats[0][0] = String.valueOf(playerWins);
        stats[0][1] = String.format("%.2f%%", playerPercent);
        stats[1][0] = String.valueOf(computerWins);
        stats[1][1] = String.format("%.2f%%", computerPercent);
        return stats;
    }

    public static void displayResults(String[] userChoices, String[] computerChoices, String[] winners, String[][] stats) {
        System.out.println("\nGame\tPlayer\tComputer\tWinner");
        System.out.println("------------------------------------------");
        for (int i = 0; i < userChoices.length; i++) {
            System.out.println((i+1) + "\t" + userChoices[i] + "\t" + computerChoices[i] + "\t\t" + winners[i]);
        }
        System.out.println("\nPlayer Wins: " + stats[0][0] + " (" + stats[0][1] + ")");
        System.out.println("Computer Wins: " + stats[1][0] + " (" + stats[1][1] + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] userChoices = new String[n];
        String[] computerChoices = new String[n];
        String[] winners = new String[n];

        int playerWins = 0, computerWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice for game " + (i+1) + " (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();
            String computerChoice = getComputerChoice();

            String winner = findWinner(userChoice, computerChoice);
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;

            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;
        }

        String[][] stats = calculateStats(playerWins, computerWins, n);

        displayResults(userChoices, computerChoices, winners, stats);

        sc.close();
    }
}
