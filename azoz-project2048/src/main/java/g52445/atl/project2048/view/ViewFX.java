package g52445.atl.project2048.view;

import g52445.atl.project2048.handler.ArrowsHandler;
import g52445.atl.project2048.controller.ControllerFX;
import g52445.atl.project2048.handler.ButtonHandler;
import g52445.atl.project2048.model.FacadeModel;
import g52445.atl.project2048.util.Observable;
import g52445.atl.project2048.util.Observer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class ViewFX represent the shape of game.
 * @author soliman
 */
public class ViewFX extends AnchorPane implements Observer {

    /**
     * The attributs
     */
    private final VBox leftPart;
    private final HBox rightPart;
    private final GridPane gp;
    private final TileFX[][] tils;
    private final Button clearBut;
    private final ListNotification listN;
    public Scene scene;

    /**
     * The constructor
     * @param stage 
     */
    public ViewFX(Stage stage) {

        this.clearBut = new Button("RECOMMENCER");
        this.clearBut.setPrefWidth(300);
        this.listN = new ListNotification();
        this.gp = new GridPane();
        this.tils = new TileFX[4][4];

        this.listN.addToList("Bienvenu au jeu 2048");
        this.listN.addToList("Move the arrows to play");

        this.leftPart = new VBox(4);
        this.rightPart = new HBox(4);

        this.leftPart.getChildren().addAll(gp, this.clearBut);
        this.leftPart.setMargin(this.clearBut, new Insets(20, 10, 10, 50));
        this.rightPart.getChildren().add(this.listN);

        gp.setVgap(5.);
        gp.setHgap(5.);
        setTopAnchor(this.leftPart, 10.0);
        setTopAnchor(this.rightPart, 10.0);
        setLeftAnchor(this.leftPart, 10.0);
        setRightAnchor(this.rightPart, 10.0);
        getChildren().addAll(this.leftPart, this.rightPart);
        scene = new Scene(this, 700, 500);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Itisialize the button rest in the game.
     * @param controller take order from controller
     */
    public void initializeButtonRest(ControllerFX controller) {
        clearBut.addEventHandler(ActionEvent.ACTION, new ButtonHandler(controller));
    }

    /**
     * Initialize the movement.
     * @param controller take order from the controller.
     */
    public void initMovement(ControllerFX controller) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new ArrowsHandler(controller));
    }

    /**
     * Transforming an array of int to board game containe the tiles with thiers colors.
     * 
     * @param arr the board in integer 
     */
    public void showBoard(int[][] arr) {
        System.out.println("print one move here ..!");
        TileColor tColor = TileColor.NOCOLOR;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                this.tils[i][j] = new TileFX(arr[i][j],
                        tColor.suitableColor(arr[i][j]));
                gp.add(this.tils[i][j].getTile(), j, i);
            }
        }
    }

    /**
     * Observing any changing from class Game and update this observation on view. 
     * @param ob game.
     * @param object object.
     */
    @Override
    public void update(Observable ob, Object object) {
        FacadeModel game = (FacadeModel) ob;
        String notify = (String) object;
        if (notify.equals("recommencer")) {
            this.listN.addToList("Partie recommencer.");
        }
        if (notify.equals("gameOver")) {
            this.listN.addToList("Partie terminée.");
            this.listN.addToList("Vous avez perdu.");
        }

    }

}
