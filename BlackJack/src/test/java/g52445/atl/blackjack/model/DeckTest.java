package g52445.atl.blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author solimanazoz
 */
public class DeckTest {

    Deck deck;

    public DeckTest() {
        deck = new Deck();
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("Testing if the deck shuffled or not");
        Card firstCard = new Card(Value.EIGHT, Color.DIAMOND);
        deck.shuffle();
        Card result = deck.getPacket().get(0);
        assertNotEquals(firstCard, result);

    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("Testing if the deck is empty or no: ");
        assertEquals(deck.isEmpty(), false);
    }

    /**
     * Test of hit method, of class Deck.
     */
    @Test
    public void testHit() {
        System.out.println("Testing if after hit card , the deck still have it or not");
        Card card = deck.hit();
        Card result = deck.getPacket().get(0);
        assertNotEquals(result, card);
    }

    /**
     * Test of size method, of class Deck.
     */
    @Test
    public void testSize() {
        System.out.println("Testing the size of the deck: ");
        int deckCountCard = 52;
        assertEquals(deck.size(), deckCountCard - 1);
    }

    @Test
    public void testSizeAfterHit() {
        System.out.println("Testing the size of of the deck after one hit");
        int deckCountCard = 52;
        deck.hit();
        assertNotEquals(deck.size(), deckCountCard);
    }

}
