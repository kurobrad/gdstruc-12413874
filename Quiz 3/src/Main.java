import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> playerQueue = new LinkedList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int gamesMade = 0;
        int playerIdCounter = 1;

        System.out.println("==== Matchmaking Queue ====");
        System.out.println("Press Enter to process each queue. The program ends after 10 games.\n");

        while (gamesMade < 10) {
            System.out.print("Press Enter to proceed to next turn...");
            scanner.nextLine();

            // Step 1: Random number of players queue this turn (1 to 7)
            int x = random.nextInt(7) + 1; // 1 to 7 inclusive
            System.out.println("\n--- Turn Summary ---");
            System.out.println("New players joining: " + x);

            for (int i = 0; i < x; i++)
            {
                playerQueue.offer(playerIdCounter++);
            }

            System.out.println("Current queue size: " + playerQueue.size());
            System.out.println("Queue contents: " + playerQueue);

            while (playerQueue.size() >= 5)
            {
                System.out.print("\nGame #" + (gamesMade + 1) + " starting with players: ");
                for (int i = 0; i < 5; i++)
                {
                    System.out.print(playerQueue.poll());
                    if (i < 4) {
                        System.out.print(", ");
                    }
                }
                gamesMade++;
                System.out.println();

                if (gamesMade == 10)
                {
                    System.out.println("\n10 games have been made.");
                    scanner.close();
                    return;
                }
            }

            System.out.println("Games that have been made so far: " + gamesMade + "/10\n");
        }

        scanner.close();
    }
}