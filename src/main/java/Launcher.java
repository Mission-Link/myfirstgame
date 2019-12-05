import java.awt.*;

public class Launcher {

    /*
    //small screen
    public static int sWIDTH = 800;
    public static int sHEIGHT = (sWIDTH / 12) * 9;
    //full screen
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int fWIDTH = (int) screenSize.getWidth();
    public static int fHEIGHT = (int) screenSize.getHeight();
    */

    public static void main(String[] args) {
        boolean smallScreen = true;

        Game game;
        if (smallScreen) {
            game = new Game();
        } else {
            game = new Game(true);
        }
        game.run();

    }
}
