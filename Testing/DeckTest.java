import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck1;
    private Deck deck2;

    @BeforeEach
    void init() {
        deck1 = new Deck();
        deck1.createFullDeck();
        deck2 = new Deck();
    }

    @Test
    void testDeckObjectNotNull() {
        assertNotNull(deck1, "Object was not instantiated.");
        assertNotNull(deck2, "Object was not instantiated.");
    }

}