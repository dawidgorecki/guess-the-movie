import java.io.File;
import java.util.Scanner;

public class Game {
    private int points;
    private String randomTitle;
    private String matchedLetters;
    private String wrongLetters;
    private boolean guessed;

    public Game(String filename) throws Exception {
        points = 10;
        randomTitle = this.getRandomMovieTitle(filename);
        matchedLetters = "";
        wrongLetters = "";
        guessed = false;
    }

    public void start() throws Exception {
        while (points > 0) {
            System.out.println("You are guessing: " + getCoveredMovieTitle());
            System.out.println("You have guessed (" + wrongLetters.length() / 2 + ") wrong letters:" + wrongLetters);

            System.out.print("Guess a letter: ");
            Scanner input = new Scanner(System.in);
            String letter = input.nextLine().toLowerCase();

            if (!letter.matches("[a-z]")) {
                System.out.println("[!] " + letter + " is not a letter.");
                continue;
            }

            if (matchedLetters.contains(letter) || wrongLetters.contains(letter)) {
                System.out.println("[!] You already guessed letter \"" + letter + "\".");
                continue;
            }

            if (randomTitle.toLowerCase().contains(letter)) {
                matchedLetters += letter;
            } else {
                wrongLetters += " " + letter;
                points--;
            }

            if (!getCoveredMovieTitle().contains("_")) {
                guessed = true;
                break;
            }
        }

        if (guessed) {
            System.out.println("[!] You win! You have guessed '" + randomTitle + "' correctly.");
        } else {
            System.out.println("[!] You lose. Correct title was " + randomTitle + "'.");
        }
    }

    private String getRandomMovieTitle(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        String[] movies = new String[100];
        int n = 0;

        while (sc.hasNextLine()) {
            movies[n++] = sc.nextLine();
        }

        // Return random title
        int randomIndex = (int) (Math.random() * n);
        return movies[randomIndex];
    }

    private String getCoveredMovieTitle() {
        if (matchedLetters.isEmpty()) {
            return randomTitle.replaceAll("[a-zA-Z]", "_");
        }

        return randomTitle.replaceAll("[^" + matchedLetters + " ]", "_");
    }
}
