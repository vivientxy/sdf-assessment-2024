package pokemon;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    private static List<String> pokemonStack;
    private static Map<Integer, List<String>> pokemonStacks;

    public static void main(String[] args) throws Exception {
        Console cons = System.console();

        String csvDir = args[0];
        FileService fs = new FileService();
        fs.ReadCSV(csvDir);

        // Run Your Code here
        printHeader();
        String selection = cons.readLine("Enter your selection >");

    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        // your code here
    }

    // Task 1
    public static void printHeader() {
        System.out.println("Welcome to Pokemon Gaole Legend 4 Rush 2" + "\n\n"
        + "(1) View the list of Pokemon in the selected stack" + "\n"
        + "(2) View unique list of Pokemon in the selected stack and cards count" + "\n"
        + "(3) Find next 5 stars Pokemon occurrence" + "\n"
        + "(4) Create new Pokemon stack and save (append) to csv file" + "\n"
        + "(q) to exit the program");
    }

    // Task 1
    public static void printExitMessage() {

        // Task 1 - your code here
    }

    // Task 1
    public static void savePokemonStack(String pokemonStack, String filename) {

        // Task 1 - your code here
    }

    // Task 2
    public static void printUniquePokemonStack(Integer stack) {
        // Task 2 - your code here
    }

    // Task 2
    public static void printNext5StarsPokemon(String enteredPokemon) {
        // Task 2 - your code here

    }

    // Task 2
    public static void printPokemonCardCount() {
        // Task 2 - your code here
    }

}
