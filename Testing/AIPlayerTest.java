import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {
    AIPlayer player;
    ArrayList<Card> hand;
    Card card1, card2, card3;

    @BeforeEach
    void init(){
        player = new AIPlayer();
        hand = new ArrayList<>();
        card1 = new Card(Suit.HEART, FaceName.JACK);
        card2 = new Card(Suit.DIAMOND, FaceName.THREE);
        card3 = new Card(Suit.DIAMOND, FaceName.ACE);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        player.setHand(hand);
    }

    @Test
    void testCardObjectNotNull() {
        assertNotNull(player, "Object was not instantiated.");
    }

    @Test
    void testTrump() {
        assertEquals(Suit.DIAMOND, player.trump());
    }

    @Test
    void testBid() {
        Suit trump = player.trump();
        assertEquals(2, player.Bid(trump));
    }

    @Test
    void testGetHand() {
        assertEquals(hand, player.getHand());
    }

    @Test
    void testGetCard() {
        assertEquals("DIAMOND\nTHREE", player.getCard(1) );
    }

    @Test
    void testIsLowCard() {
        assertFalse(player.isLowCard(card1));
        assertTrue(player.isLowCard(card2));
    }

}