import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardStack {
    private List<Card> cards;
    private int top;

    public CardStack() {
        cards = new ArrayList<>();
        top = -1;
    }

    public CardStack(List<Card> initialCards) {
        cards = new ArrayList<>(initialCards);
        top = cards.size() - 1;
    }

    // Push a card onto the stack
    public void push(Card card) {
        cards.add(card);
        top++;
    }

    // Pop a card from the stack
    public Card pop() {
        if (isEmpty()) {
            return null;
        }
        Card card = cards.remove(top);
        top--;
        return card;
    }

    public Card peek() {
        if (isEmpty()) {
            return null;
        }
        return cards.get(top);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top < 0;
    }

    // Get size of stack
    public int size() {
        return top + 1;
    }

    // Get all cards in stack
    public List<Card> getAllCards() {
        return new ArrayList<>(cards);
    }

    // Get random cards from the stack
    public List<Card> getRandomCards(int count) {
        List<Card> randomCards = new ArrayList<>();
        Random rand = new Random();

        if (count > size()) {
            count = size();
        }

        for (int i = 0; i < count; i++) {
            if (!isEmpty()) {
                int randomIndex = rand.nextInt(size());
                Card card = cards.remove(randomIndex);
                randomCards.add(card);
                top--;
            }
        }
        return randomCards;
    }

    // Clear the stack - FIXED: Was calling cardStack.clear() instead of cards.clear()
    public void clear() {
        cards.clear();  // Fixed this line
        top = -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(cards.get(i).getName());
            if (i < top) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}