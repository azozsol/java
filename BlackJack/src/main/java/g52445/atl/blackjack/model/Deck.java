package g52445.atl.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Deck indicate the game cards
 *
 * @author solimanazoz
 */
public class Deck {

    /**
     * the attribute
     */
    private List<Card> packet;

    /**
     * Simple constructor for creating the deck with 52 differents cards
     */
    public Deck() {
        this.packet = new ArrayList<>();
        int index = 0;
        for (Color col : Color.values()) {
            for (Value val : Value.values()) {
                this.packet.add(index, (new Card(val, col)));
                index++;
            }
        }
    }

    /**
     * Simple getter of attribute packet
     *
     * @return list of cards
     */
    public List<Card> getPacket() {
        return packet;
    }

    /**
     * Shuffling the cards ,so the players can't guess the cards
     */
    public void shuffle() {
        Collections.shuffle(this.packet);
    }

    /**
     * Checking if the packet is empty or not
     *
     * @return true if the packet is empty , fale if isn't.
     */
    public boolean isEmpty() {
        return this.packet.isEmpty();
    }

    /**
     * Hitting a card means taking one card from the packet (from the above ).
     *
     * @return one card of the packet.
     */
    public Card hit() {
        Card firstCard = this.packet.get(0);
        this.packet.remove(0);
        return firstCard;
    }

    /**
     * The size of the packet means the how packet have cards( at the beginning 52 cards)
     *
     * @return the total numbers of cards.
     */
    public int size() {
        return this.packet.size();
    }

    /**
     * To print card from the packet
     *
     * @return the card
     */
    @Override
    public String toString() {
        String packetList = "";
        for (Card card : this.packet) {
            packetList += card + "\n";
        }
        return packetList;
    }
}
