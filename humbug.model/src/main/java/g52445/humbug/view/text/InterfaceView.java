package g52445.humbug.view.text;

import g52445.humbug.model.Animal;
import g52445.humbug.model.Board;
import g52445.humbug.model.Direction;
import g52445.humbug.model.Position;

/**
 * An InterfaceView contains some methods with no body
 *
 * @author solimanazoz
 */
public interface InterfaceView {

    void displayBoard(Board board, Animal... animals);

    Position askPosition();

    Direction askDirection();

    void displayError(String message);

    int askLevel(String messeag);

    void displayMessage(String message);
}
