package g52445.atl.blackjack.model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author solimanazoz
 */
public class PlayerTest {

    Player player;

    public PlayerTest() {
        player = new Player(new ArrayList<>(), "N");
        player.getCards().add(new Card(Value.ACE, Color.CLUB));
        player.getCards().add(new Card(Value.FIVE, Color.HEART));
    }

    /**
     * Test of getAskStand method, of class Player.
     */
    @Test
    public void testGetAskStandNo() {
        System.out.println("Testing if the player ask to stand or not");
        assertEquals(player.getAskStand(), "N");
    }

    /**
     * Test of getAskStand method, of class Player.
     */
    @Test
    public void testGetAskStandYesé() {
        System.out.println("Testing if the player ask to stand or not");
        player.setAskStand("Y");
        assertEquals(player.getAskStand(), "Y");
    }
    
    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("Testing the current score: ");
        int expResult = 16;
        int result = player.getScore();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScoreAfterAddCard() {
        System.out.println("Testing the current score: ");
        player.getCards().add(new Card(Value.KING, Color.CLUB));
        int expResult = 26;
        int result = player.getScore();
        assertEquals(expResult, result);
    }

}
