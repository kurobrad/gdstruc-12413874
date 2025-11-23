public class PlayerLinkedList
{
    private PlayerNode head;
    // in-place size counter variable
    private int size;

    public PlayerLinkedList() {
        this.head = null;
        this.size = 0; // this initializes the size
    }

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++; // increment when adds something new
    }

    // remover of element
    public Player removeFirst() {
        if (head == null) {
            return null;
        }

        Player playerToRemove = head.getPlayer();
        head = head.getNextPlayer();
        size--; // decrement size when removing

        return playerToRemove;
    }

    // shows the size of the variables
    public int size() {
        return size;
    }

    // contains function
    public boolean contains(Player player) {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    // contains indexOF function
    public int indexOF(Player player) {
        int index = 0;
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }
        return -1;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getPlayer().getName() + " -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }
}
