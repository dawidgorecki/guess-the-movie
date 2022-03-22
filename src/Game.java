import java.io.File;
import java.util.Scanner;

public class Game {
    String fileName;

    public Game() {
        this.fileName = "list.txt";
    }

    public Game(String fileName) {
        this.fileName = fileName;
    }

    public void start() throws Exception {
        int points = 10;
        String randomTitle = getRandomMovieTitle(this.fileName);
        Scanner inputScanner = new Scanner(System.in);

        System.out.println(randomTitle); // TEST


    }

    private String getRandomMovieTitle(String fileName) throws Exception {
        // Load file and create array with movies titles
        Scanner sc = new Scanner(new File(fileName));
        String[] movies = new String[100];
        int n = 0;

        while (sc.hasNextLine()) {
            movies[n++] = sc.nextLine();
        }

        // Return random title
        int randomIndex = (int) (Math.random() * n);
        return movies[randomIndex];
    }
}
