package g52445.atl.blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author solimanazoz
 */
public class CardTest {

    private Card cards;

    public CardTest() {
    }

    /**
     * Test of getColors method, of class Card.
     */
    @Test
    public void testGetColors() {
        System.out.println("test cards color:");
        cards = new Card(Value.ACE, Color.CLUB);
        Color expResult = Color.CLUB;
        Color result = cards.getColors();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValues method, of class Card.
     */
    @Test
    public void testGetValues() {
        System.out.println("test cards value:");
        cards = new Card(Value.ACE, Color.CLUB);
        Value expResult = Value.ACE;
        Value result = cards.getValues();
        assertEquals(expResult, result);

    }

    @Test
    public void testNotNullColors() {
        System.out.println("Test for no colors: ");
        cards = new Card(Value.ACE, Color.CLUB);
        Color result = cards.getColors();
        assertNotNull(result);
    }

    @Test
    public void testNotNullValue() {
        System.out.println("Test for no colors: ");
        cards = new Card(Value.ACE, Color.CLUB);
        Value result = cards.getValues();
        assertNotNull(result);
    }
}
