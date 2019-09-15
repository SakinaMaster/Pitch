import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    ArrayList<Card> hand;
    Card card1, card2;

    @BeforeEach
    void init() {
        player = new Player();
        hand = new ArrayList<>();
        card1 = new Card(Suit.HEART, FaceName.ACE);
        card2 = new Card(Suit.DIAMOND, FaceName.THREE);
        hand.add(card1);
        hand.add(card2);
        player.setHand(hand);
    }


    @Test
    void testCardObjectNotNull() {
        assertNotNull(player, "Object was not instantiated.");
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