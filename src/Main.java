public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game("movies.txt");
            game.start();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
