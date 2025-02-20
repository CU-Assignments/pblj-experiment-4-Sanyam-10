import java.util.*;

class Card {
  String symbol;
  String name;

  Card(String symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Card: " + name + ", Symbol: " + symbol;
  }
}

public class CardCollection {
  static Map<String, List<Card>> cardMap = new HashMap<>();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n1. Add Card\n2. Search Cards by Symbol\n3. Display All Cards\n4. Exit");
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> addCard();
        case 2 -> searchBySymbol();
        case 3 -> displayCards();
        case 4 -> {
          System.out.println("Exiting...");
          return;
        }
        default -> System.out.println("Invalid choice!");
      }
    }
  }

  static void addCard() {
    scanner.nextLine();
    System.out.print("Enter Symbol: ");
    String symbol = scanner.nextLine();
    System.out.print("Enter Card Name: ");
    String name = scanner.nextLine();

    cardMap.putIfAbsent(symbol, new ArrayList<>());
    cardMap.get(symbol).add(new Card(symbol, name));
    System.out.println("Card added successfully!");
  }

  static void searchBySymbol() {
    scanner.nextLine();
    System.out.print("Enter Symbol to search: ");
    String symbol = scanner.nextLine();
    List<Card> cards = cardMap.get(symbol);

    if (cards != null) {
      for (Card card : cards) {
        System.out.println(card);
      }
    } else {
      System.out.println("No cards found for this symbol!");
    }
  }

  static void displayCards() {
    if (cardMap.isEmpty()) {
      System.out.println("No cards to display.");
    } else {
      for (List<Card> cards : cardMap.values()) {
        for (Card card : cards) {
          System.out.println(card);
        }
      }
    }
  }
}
