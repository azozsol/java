package g52445.atl.blackjack.view;

import g52445.atl.blackjack.model.Card;
import java.util.List;

/**
 *
 * @author solimanazoz
 */
public interface InterfaceView {

    void displayCard(List<Card> card, int begin);

    void displayMessage(String message);
    
    String displayTitle(String message);

    void displayError(String message);
    
    String askCard(String message);

}
