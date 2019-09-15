import java.util.ArrayList;
import java.util.Collections;

//Deck class has methods to create a full deck and shuffle the deck.
class Deck
{
    private ArrayList<Card> cards;

    //Constructor for class Deck
    public Deck() {
        cards = new ArrayList<Card>();
    }

    //Creates a new deck of cards
    public void createFullDeck() {
        //values() returns all values present inside enum.
        for(Suit cardSuit : Suit.values()) {                    //Returns the four suits inside enum Suit.
            for(FaceName cardFaceName : FaceName.values()) {    //Returns 13 faceNames inside enum FaceName.
                cards.add(new Card(cardSuit, cardFaceName));    //Adds new card to the deck using add() of ArrayList.
            }
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public Card dealCard() {
        return cards.remove(0);
    }

    public String toString() {
        String cardList = " ";
        int i=0;
        for(Card aCard : cards) {
            cardList += "\n" + i + "-" + aCard.toString();
            i++;
        }
        return cardList;
    }

    public void shuffle() {
        Collections.shuffle(cards); //Randomly permutes the specified list using a default source of randomness.
    }
}

