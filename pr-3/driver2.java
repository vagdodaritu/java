
class driver2 {
    public static void main(String[] args) {

        Card[] cards = new Card[5];

        Card[] newCards = {
            new Card("Ace", "Spades"),
            new Card("Queen", "Hearts"),
            new Card("King", "Clubs"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Diamonds")
        };

        int count = 0;
        boolean duplicatePrinted = false;

        for (Card card : newCards) {

            boolean duplicate = false;

            // Check against earlier cards
            for (int i = 0; i < count; i++) {
                if (card.equals(cards[i])) {
                    duplicate = true;

                    if (!duplicatePrinted) {
                        System.out.println("Duplicate found: " + card);
                        duplicatePrinted = true;
                    }

                    break;
                }
            }

            // Add card to the array
            cards[count] = card;
            count++;
        }
    }
}

