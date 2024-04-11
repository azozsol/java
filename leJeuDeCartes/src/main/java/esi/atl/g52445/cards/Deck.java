package esi.atl.g52445.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author solimanazoz
 */
public class Deck {

    private  List<Card> packet ;

    public Deck() {
        this.packet = new ArrayList<>();
        int index = 0;
        for (Color col : Color.values()) {
            for (Value val : Value.values()) {
                this.packet.add(index,(new Card(val, col)));
                index++;
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.packet);
    }

    public boolean isEmpty() {
        return this.packet.isEmpty();
    }

    public Card hit() {
        Card firstCard = this.packet.get(0);
        this.packet.remove(0);
        return firstCard;
    }

    public int size() {
        return this.packet.size();
    }

    @Override
    public String toString() {
        String packetList = "";
        for (Card card : this.packet) {
            packetList += card + "\n";
        }
        return packetList;

    }

}
