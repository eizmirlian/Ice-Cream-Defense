package application;

public class GameLoop {
    
    private static int gameCounter = 0;
    private static double gameSpeed = 1;
    private static double fps = 60;
    
    public static void start() {
        while (true) {
            if (!Level.getPause()) {
                gameCounter = 0;
            }
        }
    }
    public static double getfps() {
        return fps;
    }
}
