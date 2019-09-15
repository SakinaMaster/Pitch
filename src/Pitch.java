import java.util.ArrayList;

//This class does all the work.
class Pitch implements DealerType{
    ArrayList<AIPlayer> playerList;
    private int numOfPlayers;

    Pitch(int numPlayers) {
        this.numOfPlayers = numPlayers;
        Dealer dealer = createDealer();
        System.out.println(numPlayers);
        playerList = new ArrayList<AIPlayer>();
        for(int i=0; i<numOfPlayers; i++) {
            playerList.add(new AIPlayer());
        }
        for (AIPlayer p1 : playerList) {
            p1.setHand(dealer.dealHand());
        }
        for(AIPlayer display: playerList) {
            System.out.println("\n\nHand:");
            display.printHand();
        }

        for(int i=0; i<playerList.size(); i++) {
            AIPlayer fgh = playerList.get(i);
            Suit trump = fgh.trump();
            int bid = fgh.Bid(trump);
            System.out.println("\nTrump is " + trump.toString() + " " + "Bid is " + bid + " ");
        }
    }

    Card playFirstCard(int maxBidIndex) {
        AIPlayer bidWinner = playerList.get(maxBidIndex);
        ArrayList<Card> bidWinnerHand = new ArrayList<>();
        bidWinnerHand = bidWinner.getHand();
        Suit winningTrump = bidWinner.trump();
        Card aCard;
        for(int i=0; i<bidWinnerHand.size(); i++) {
            aCard = bidWinnerHand.get(i);
            if (aCard.getSuit().equals(winningTrump) && aCard.getFaceName().equals(FaceName.ACE)) {
                return aCard;
            }
        }
        for(int i=0; i<bidWinnerHand.size(); i++) {
            aCard = bidWinnerHand.get(i);
            if (aCard.getSuit().equals(winningTrump) && (bidWinner.isLowCard(aCard))) {
                return aCard;
            }
        }
        for(int i=0; i<bidWinnerHand.size(); i++) {
            aCard = bidWinnerHand.get(i);
            if (aCard.getSuit().equals(winningTrump) && (aCard.getFaceName().equals(FaceName.KING))) {
                return aCard;
            }
        }
        aCard = bidWinnerHand.get(5);
        return aCard;               //This never gets executed.
    }

    Card otherPlayersTurn(ArrayList<Card> trick, int playerNo, Suit trump)
    {
        AIPlayer otherPlayer = playerList.get(playerNo);
        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand = otherPlayer.getHand();
        Card card1;
        for(int i=0; i<playerHand.size(); i++) {
            card1 = playerHand.get(i);
            if (otherPlayer.isTrumpPlayed(trump, trick.get(0))) {
                if (card1.getSuit().equals(trump)) {
                    return card1;
                }
            }
        }

        for(int i=0; i<playerHand.size(); i++) {
            card1 = playerHand.get(i);
            if (otherPlayer.isLowCard(card1)){
                return card1;
            }
        }
        card1 = playerHand.get(3);
        return card1;
    }

    public Dealer createDealer()
    {
        return new PitchDealer();
    }
}

