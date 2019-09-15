import java.util.ArrayList;

class PitchDealer implements Dealer {

    Deck playingDeck = new Deck();

    PitchDealer()
    {
        //Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        //    System.out.println(playingDeck);
    }
    public ArrayList<Card> dealHand()
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < 6; i++)
        {
            hand.add(playingDeck.dealCard());
        }
        return hand;
    }
}