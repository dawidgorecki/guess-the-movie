public class Main {
    public static void main(String [] args) {
        // Create game object and start the game
        Game game = new Game("movies.txt");

        try {
            game.start();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
