public class Main {
    public static void main(String[] args) {
        String path = "movies.txt";

        if (args.length > 0) {
            path = args[0];
        }

        try {
            Game game = new Game(path);
            game.start();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
