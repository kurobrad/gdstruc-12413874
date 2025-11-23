import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player chia = new Player(1, "Chia", 550);
        Player brad = new Player(2, "Brad", 2000);
        Player alex = new Player(3, "Alex", 1500);
        Player tsuki = new Player(4, "Tsuki", 550);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(chia);
        playerLinkedList.addToFront(brad);
        playerLinkedList.addToFront(alex);

        System.out.println("*Original Link List*");
        playerLinkedList.printList();

        System.out.println("\n*testing Search and Size Check*");
        System.out.println("current Size: " + playerLinkedList.size());
        System.out.println("does the list contain Player 'Brad'? = " + playerLinkedList.contains(brad));
        System.out.println("index of 'Alex': " + playerLinkedList.indexOF(alex));
        System.out.println("index of 'Chia': " + playerLinkedList.indexOF(chia));
        System.out.println("index of 'Tsuki': " + playerLinkedList.indexOF(tsuki));

        System.out.println("\n*test for removing elements*");

        Player removed1 = playerLinkedList.removeFirst();
        System.out.println("removed 1st element: " + removed1.getName());

        Player removed2 = playerLinkedList.removeFirst();
        System.out.println("removed 2nd element: " + removed2.getName());

        System.out.println("\n*the results after removing 2 elements*");
        playerLinkedList.printList();
    }
}