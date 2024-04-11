package g52445.humbug.view.text;


import g52445.humbug.model.*;
import static g52445.humbug.model.SquareType.STAR;
import java.util.Scanner;

/**
 *
 * @author solimanazoz
 */
public class View implements InterfaceView {

    public View() {
    }

    /**
     * Displays an error message in case of exception errors.
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Asking the position
     *
     * @return
     */
    @Override
    public Position askPosition() {
        System.out.println("Chose animal position");
        int row = askInt("Chose the row:");
        int column = askInt("Chose the column:");
        Position pos = new Position(row, column);
        return pos;
    }

    /**
     * Asking for integer
     *
     * @param message
     * @return nomber of type integer
     */
    public int askInt(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.print(message);
        while (!clavier.hasNextInt()) {
            clavier.nextLine();
            System.out.println("That was not a nomber.");
            System.out.println(message);
        }
        return clavier.nextInt();
    }

    /**
     * Asking for a specific character
     *
     * @param message
     * @return one of those character (N, S, E, W)
     */
    public String askChar(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.println(message);
        String letter = clavier.nextLine().toUpperCase();
        while (true) {
            if (letter.matches("N") || letter.matches("W") || letter.matches("E") || letter.matches("S")) {
                return letter;
            } else {
                System.out.println("The letter is not from the list(N, S, W, E)");
                System.out.println(message);
                letter = clavier.nextLine().toUpperCase();
            }
        }
    }

    /**
     * Asking for the direction, the method ask form the plyer a speific character and transform it to a direction
     *
     * @return one of direction(NORTH, SOUTH, WEST, EAST).
     */
    @Override
    public Direction askDirection() {
        //   Scanner clavier = new Scanner(System.in);
        String message = "Chose the direction(N for North)(S for South)(E for East)(W for West)";
        Direction direc = Direction.NORTH;
        switch (askChar(message)) {
            case "N":
                direc = Direction.NORTH;
                break;
            case "S":
                direc = Direction.SOUTH;
                break;
            case "W":
                direc = Direction.WEST;
                break;
            case "E":
                direc = Direction.EAST;
            default:

        }
        return direc;
    }

    /**
     * Display the remaing movements
     *
     */
    public void displayRemainingMoves(int nMoves) {
        System.out.println("Remain " + nMoves + " moves. ");
    }

    /**
     * asking for a level
     *
     * @param message the message
     * @return Number according the given level
     */
    @Override
    public int askLevel(String message) {
        return askInt(message);
    }

    /**
     * Display an message
     *
     * @param message the given message
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display the board consist first to fill the animals and the types of board (GRASS, STAR) together
     *
     * @param board the type of board ,there is two types (GRASS, STAR5
     * @param animals the difrents type of animales (Snail, Spider ,...)
     */
    public void displayBoard(Board board, Animal... animals) {
        TerminalColor clG = TerminalColor.BG_GREEN;
        TerminalColor foB = TerminalColor.BLUE;
        TerminalColor def = TerminalColor.DEFAULT;
        TerminalColor clW = TerminalColor.BG_WHITE;
        TerminalColor foR = TerminalColor.RED;

        String wallE = clG + "" + foR + "■" + def;
        String wallW = clG + "" + foR + "■" + def;
        String wallN = clG + "" + foR + "▀" + def;
        String wallS = clG + "" + foR + "▄" + def;

        String grass = clG + " " + def;
        String star = clG + "" + foR + "★" + def;
        String nul = clW + " " + def;
        String spider = clG + "" + foB + "P" + def;
        String snail = clG + "" + foB + "S" + def;
        String bumbelbee = clG + "" + foB + "B" + def;
        String butterfly = clG + "" + foB + "F" + def;
        String grasshopper = clG + "" + foB + "G" + def;
        String ladybird = clG + "" + foB + "L" + def;

        String[][][][] tab = new String[board.getNbRow()][3][board.getNbColumn()][3]; // i j x y
        System.out.print("    ");
        for (int index = 0; index < board.getNbColumn(); index++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print("    ");
                System.out.print("|");
                for (int x = 0; x < tab[i][j].length; x++) {
                    Position pos = new Position(i, x);
                    for (int y = 0; y < tab[i][j][x].length; y++) {
                        tab[i][j][x][y] = grass;
                        if (!board.isInside(pos)) {
                            tab[i][j][x][y] = nul;
                            System.out.print(tab[i][j][x][y]);
                        } else {
                            if (j == 1 && y == 1) {
                                for (int k = 0; k < animals.length; k++) {
                                    if (animals[k].getPositionOnBoard().equals(pos)) {
                                        if (animals[k].isOnStar()) {
                                            tab[i][j][x][y] = grass;
                                        } else if (animals[k] instanceof Snail) {
                                            tab[i][j][x][y] = snail;
                                        } else if (animals[k] instanceof Spider) {
                                            tab[i][j][x][y] = spider;
                                        } else if (animals[k] instanceof Bumbelbee) {
                                            tab[i][j][x][y] = bumbelbee;
                                        } else if (animals[k] instanceof Butterfly) {
                                            tab[i][j][x][y] = butterfly;
                                        } else if (animals[k] instanceof Grasshopper) {
                                            tab[i][j][x][y] = grasshopper;
                                        } else {
                                            tab[i][j][x][y] = ladybird;
                                        }
                                    }
                                }
                                if (board.getSquareType(pos) == STAR) {
                                    tab[i][j][x][y] = star;
                                }
                            }
                            if (j == 0 && y == 1 && board.getSquare(pos).hasWall(Direction.NORTH)) {
                                tab[i][j][x][y] = wallN;
                            }
                            if (j == 1 && y == 0 && board.getSquare(pos).hasWall(Direction.WEST)) {
                                tab[i][j][x][y] = wallW;
                            }
                            if (j == 2 && y == 1 && board.getSquare(pos).hasWall(Direction.SOUTH)) {
                                tab[i][j][x][y] = wallS;
                            }
                            if (j == 1 && y == 2 && board.getSquare(pos).hasWall(Direction.EAST)) {
                                tab[i][j][x][y] = wallE;
                            }
                            System.out.print(tab[i][j][x][y]);
                        }
                    }
                    System.out.print("|");
                }
                System.out.println();
            }
            System.out.print("    ");
            for (int index = 0; index < board.getNbColumn(); index++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }
}
