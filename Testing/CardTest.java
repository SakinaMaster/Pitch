import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card1;
    private Card card2;

    @BeforeEach
    void init() {
        card1 = new Card(Suit.HEART, FaceName.ACE);
        card2 = new Card(Suit.DIAMOND, FaceName.JACK);
    }

    @Test
    void testCardObjectNotNull()
    {
        assertNotNull(card1, "Object was not instantiated.");
        assertNotNull(card2, "Object was not instantiated.");
    }
    @Test
    void testGetFaceName() {
        assertEquals(FaceName.ACE, card1.getFaceName(), "The faceName of the card is not right");
        assertEquals(FaceName.JACK, card2.getFaceName(), "The faceName of the card is not right");
    }

    @Test
    void testGetSuit() {
        assertEquals(Suit.HEART, card1.getSuit(), "The suit of the card is not right.");
        assertEquals(Suit.DIAMOND, card2.getSuit(), "The suit of the card is not right.");
    }

    @Test
    void testGetFaceValue() {
        assertEquals(14, card1.getFaceValue(), "The face value of the card is not right.");
        assertEquals(11, card2.getFaceValue(), "The face value of the card is not right.");
    }

    @Test
    void testString()
    {
        assertEquals("HEART\nACE", card1.toString());
        assertEquals("DIAMOND\nJACK", card2.toString());
    }
}
