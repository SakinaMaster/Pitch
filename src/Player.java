import java.util.ArrayList;

class Player
{
    private ArrayList<Card> hand;
    Player() {
        hand = new ArrayList<>();
    }

    void setHand(ArrayList<Card> hand1) {
        hand = hand1;
    }

    ArrayList<Card> getHand() {
        return hand;
    }

    String getCard(int index) {
        Card aCard = hand.get(index);
        return aCard.toString();
    }

    boolean isLowCard(Card aCard) {
        int value;
        value = aCard.getFaceValue();
        return (value >= 2) && (value <= 10);
    }


    void printHand()
    {
        //for (Card i: hand){... }
        for(int i=0; i < hand.size(); i++)
        {
            Card showCard = hand.get(i);
            System.out.println(showCard.toString());
        }
    }
}
