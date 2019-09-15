import java.util.ArrayList;
import java.util.Collections;

//This function has Bid method which does bidding for AIPlayers.
class AIPlayer extends Player
{
    private ArrayList<Card> AIHand;

    AIPlayer(){
        AIHand = new ArrayList<>();
        //AIHand = super.getHand();
    }

    void setHand(ArrayList<Card> hand1) {
        AIHand = hand1;
    }

    String getCard(int index) {
        Card aCard = AIHand.get(index);
        return aCard.toString();
    }

    Card getACard(int index) {
        Card aCard = AIHand.get(index);
        return aCard;
    }
    ArrayList<Card> getHand() {
        return AIHand;
    }

    void printHand() {
        for(int i=0; i < AIHand.size(); i++) {
            Card showCard = AIHand.get(i);
            System.out.println(showCard.toString());
        }
    }

    boolean isTrumpPlayed(Suit trump, Card aCard) {
        return aCard.getSuit().equals(trump);
    }

    //Returns suit which is found most in one's hand.
    Suit trump() {
        Suit maxSameSuit;
        Card aCard;
        ArrayList<Integer> numSuits = new ArrayList<Integer>();
        //Index 0 = HEART, 1 = SPADE, 2 = CLUB, 3 = DIAMOND
        numSuits.add(0); numSuits.add(0); numSuits.add(0); numSuits.add(0);
        for (int i = 0; i < AIHand.size(); i++) {
            aCard = AIHand.get(i);
            if(aCard.getSuit().equals(Suit.HEART)) {
                int val = numSuits.get(0);
                val = val+1;
                numSuits.set(0, val);
                System.out.println("Heart " + val);
            }
            else if(aCard.getSuit().equals(Suit.SPADE)) {
                int val = numSuits.get(1);
                val = val+1;
                numSuits.set(1, val);
                System.out.println("Spade " + val);
            }
            else if(aCard.getSuit().equals(Suit.CLUB)) {
                int val = numSuits.get(2);
                val = val+1;
                numSuits.set(2, val);
                System.out.println("Club " + val);
            }
            else if(aCard.getSuit().equals(Suit.DIAMOND)) {
                int val = numSuits.get(3);
                val = val+1;
                numSuits.set(3, val);
                System.out.println("Diamond " + val);
            }
        }

        //Find MAx
        Integer maxVal = Collections.max(numSuits);
        Integer maxIndex = numSuits.indexOf(maxVal);
        System.out.println("MaxIndex:  " + maxIndex + " " );
        if(maxIndex == 0) {
            maxSameSuit = Suit.HEART;
        }
        else if(maxIndex == 1) {
            maxSameSuit = Suit.SPADE;
        }
        else if(maxIndex == 2) {
            maxSameSuit = Suit.CLUB;
        }
        else {
            maxSameSuit = Suit.DIAMOND;
        }
        return maxSameSuit;
    }

    //Function which returns bid
    int Bid(Suit maxSameSuit) {
        int lowBid = 0;
        int highBid = 0;
        int jackBid = 0;
        int aceBid = 0;
        Card aCard;
        for (int i = 0; i < AIHand.size(); i++) {
            aCard = AIHand.get(i);
            if ((aCard.getFaceName().equals(FaceName.ACE)) && (aCard.getSuit().equals(maxSameSuit))) {
                aceBid++;
            }
            else if (((aCard.getFaceName().equals(FaceName.KING)) || (aCard.getFaceName().equals(FaceName.QUEEN))) && (aCard.getSuit().equals(maxSameSuit))) {
                highBid++;
            }
            else if (((aCard.getFaceName().equals(FaceName.TWO)) || (aCard.getFaceName().equals(FaceName.THREE))) && (aCard.getSuit().equals(maxSameSuit))) {
                lowBid++;
            }
            else if ((isLowCard(aCard)) && (aCard.getSuit().equals(maxSameSuit))) {
                lowBid++;
            }
            else if ((aCard.getFaceName().equals(FaceName.JACK)) && (aCard.getSuit().equals(maxSameSuit))) {
                jackBid++;
            }
        }
        if ((aceBid == 1) && (highBid == 2) && (jackBid == 1) && (lowBid >= 1)) {
            return 5;
        }
        if ((aceBid == 1) && (highBid >= 1) && (jackBid == 1) && (lowBid >= 1)) {
            return 4;
        }
        if (((aceBid == 1) && (highBid >= 1) && (lowBid >= 1)) || ((aceBid == 1) && (highBid >= 1) && (jackBid == 1))) {
            return 3;
        }
        if (((aceBid == 1) && (lowBid >= 1)) || ((highBid >= 1) && (lowBid >= 1)) || (highBid >= 1) && (jackBid == 1)){
            return 2;
        }
        else
            return 0;
    }

}

