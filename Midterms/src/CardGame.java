import java.util.*;

public class CardGame {
    private CardStack playerDeck;
    private CardStack discardPile;
    private List<Card> playerHand;
    private Random random;
    private Scanner scanner;

    private static final String[] CARD_NAMES = {
            "Ace of Hearts", "King of Spades", "Queen of Diamonds", "Jack of Clubs",
            "Yearn", "Teleport", "Health Potion", "Teleport",
            "Teleport", "Dagger", "Dagger", "Magic Scroll",
            "Yearn", "Mana Potion", "Scratch", "Joker",
            "Fire Elemental", "Battle Horn", "Earth Golem", "Dagger",
            "Healing Potion", "Magic Scroll", "Scratch", "Crystal Shard",
            "Sleep", "Phoenix Feather", "Battle Horn", "Scratch",
            "Elven Bow", "Axe"
    };

    public CardGame() {
        random = new Random();
        scanner = new Scanner(System.in);
        playerHand = new ArrayList<>();
        discardPile = new CardStack();

        initializeDeck();
    }

    private void initializeDeck() {
        List<Card> initialCards = new ArrayList<>();

        // create 30 cards with random names
        for (int i = 0; i < 30; i++) {
            String cardName = CARD_NAMES[random.nextInt(CARD_NAMES.length)];
            initialCards.add(new Card(cardName));
        }

        // shuffles the cards
        Collections.shuffle(initialCards, random);
        playerDeck = new CardStack(initialCards);
    }

    private void displayGameState() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CURRENT GAME STATE:");
        System.out.println("=".repeat(50));

        // display player's hand
        System.out.println("\nPlayer's Hand (" + playerHand.size() + " cards):");
        if (playerHand.isEmpty()) {
            System.out.println("  (Empty hand)");
        } else {
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + playerHand.get(i).getName());
            }
        }

        // display deck and discard pile info
        System.out.println("\nRemaining cards in deck: " + playerDeck.size());
        System.out.println("Cards in discard pile: " + discardPile.size());  // Changed from discardFile
        System.out.println("=".repeat(50));
    }

    private void drawCards(int numberOfCards) {
        System.out.println("\n>>> Command: Draw " + numberOfCards + " card(s)");

        for (int i = 0; i < numberOfCards; i++) {
            if (playerDeck.isEmpty()) {
                System.out.println("Cannot draw more cards - deck is empty!");
                break;
            }
            Card drawnCard = playerDeck.pop();
            playerHand.add(drawnCard);
            System.out.println("  Drew: " + drawnCard.getName());
        }
    }

    private void discardCards(int numberOfCards) {
        System.out.println("\n>>> Command: Discard " + numberOfCards + " card(s)");

        if (playerHand.isEmpty()) {
            System.out.println("Cannot discard - hand is empty!");
            return;
        }

        int cardsToDiscard = Math.min(numberOfCards, playerHand.size());
        Random rand = new Random();

        for (int i = 0; i < cardsToDiscard; i++) {
            if (playerHand.isEmpty()) break;

            int randomIndex = rand.nextInt(playerHand.size());
            Card discardedCard = playerHand.remove(randomIndex);
            discardPile.push(discardedCard);  // Changed from discardFile
            System.out.println("  Discarded: " + discardedCard.getName());
        }
    }

    private void getCardsFromDiscard(int numberOfCards) {
        System.out.println("\n>>> Command: Get " + numberOfCards + " card(s) from discard pile");

        if (discardPile.isEmpty()) {  // Changed from discardFile
            System.out.println("Cannot get cards - discard pile is empty!");
            return;
        }

        int cardsToGet = Math.min(numberOfCards, discardPile.size());  // Changed from discardFile

        for (int i = 0; i < cardsToGet; i++) {
            Card card = discardPile.pop();  // Changed from discardFile
            if (card != null) {
                playerHand.add(card);
                System.out.println("  Retrieved from discard: " + card.getName());
            }
        }
    }

    private void executeRandomCommand() {
        int commandType = random.nextInt(3);
        int randomValue = random.nextInt(5) + 1; // 1 to 5

        switch (commandType) {
            case 0:
                drawCards(randomValue);
                break;
            case 1:
                discardCards(randomValue);
                break;
            case 2:
                getCardsFromDiscard(randomValue);
                break;
        }
    }

    public void playGame() {
        System.out.println("==================CARD GAME - DECK SIMULATOR================");
        System.out.println("\nStarting game with 30 cards in deck...");
        System.out.println("The game ends when the deck is empty!");
        System.out.println("\nPress Enter after each turn to continue...");

        int turnCount = 0;

        while (!playerDeck.isEmpty()) {
            turnCount++;
            scanner.nextLine(); // Wait for user to press Enter

            System.out.println("\n" + "═".repeat(50));
            System.out.println("TURN " + turnCount);
            System.out.println("═".repeat(50));

            // Execute a random command
            executeRandomCommand();

            // Display game state
            displayGameState();
        }

        // Game over
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GAME OVER!");
        System.out.println("The deck has been emptied after " + turnCount + " turns.");
        System.out.println("Final Results:");
        System.out.println("  Cards in hand: " + playerHand.size());
        System.out.println("  Cards in discard pile: " + discardPile.size());
        System.out.println("=".repeat(50));

        scanner.close();
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.playGame();
    }
}
