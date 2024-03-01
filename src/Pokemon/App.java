package pokemon;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static List<String> listOfPokemonStacks = new ArrayList<>();
    public static Map<Integer, List<String>> pokemonStacksMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Console cons = System.console();

        // try-catch exceptions instead of throw!

        // to fix this -- terminate program if no filepath is passed in command line argument
        String csvDir = "Rush2.csv";
        try {
            csvDir = args[0];
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("Error - please pass in csv filepath as command line argument.");
        }
        FileService fs = new FileService();

        // add to global variables (list and map)
        listOfPokemonStacks = fs.ReadCSV(csvDir);
        for (int i = 0; i < listOfPokemonStacks.size(); i++) {
            List<String> pokemons = new ArrayList<>();
            for (String pokemon : listOfPokemonStacks.get(i).split(",")) {
                pokemons.add(pokemon);
            }
            pokemonStacksMap.put(i, pokemons);
        }

        // Run Your Code here
        boolean gameOn = true;

        while (gameOn) {
            clearConsole();
            printHeader();
            String selection = cons.readLine("Enter your selection >");
            switch (selection.toLowerCase()) {
                case "1":
                    String stackChoiceString = cons.readLine("Display the list of unique Pokemon in stack (1-8) >\n");
                    try {
                        // check for valid selection
                        int choice = Integer.parseInt(stackChoiceString);
                        if (choice < 1 || choice > 8) {
                            System.out.println("Please enter a valid number between 1 and 8.");
                        }
                        // valid selection
                        else {
                            printUniquePokemonStack(choice);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error! Please enter a valid number between 1 and 8.");
                    }
                    pressAnyKeyToContinue();
                    break;
                case "2":

                    pressAnyKeyToContinue();
                    break;
                case "3":

                    pressAnyKeyToContinue();
                    break;
                case "4":
                    String pokemonStackString = cons.readLine("Create a new Pokemon stack and save to a new file >\n");
                    String filename = cons.readLine("Enter filename to save (e.g. path/filename.csv) >\n");
                    savePokemonStack(pokemonStackString, filename);
                    break;
                case "q":
                    printExitMessage();
                    gameOn = false;
                    break;
                default:
                    break;
            }
        }

    }

    public static void clearConsole() throws IOException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Task 1
    public static void pressAnyKeyToContinue() {
        Console cons = System.console();
        cons.readLine("Press any key to continue...");
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
        System.out.println("\nThank you for using the program..." + "\n"
                + "Hope to see you soon...");
    }

    // Task 1
    public static void savePokemonStack(String pokemonStack, String filename) throws IOException {
        FileService fs = new FileService();
        fs.writeAsCSV(pokemonStack, filename);
    }

    // Task 2
    public static void printUniquePokemonStack(Integer stack) {
        List<String> pokemons = pokemonStacksMap.get(stack);
        Set<String> uniquePokemons = new HashSet<>();
        for (String pokemon : pokemons) {
            uniquePokemons.add(pokemon);
        }
        int counter = 1;
        for (String pokemon : uniquePokemons) {
            System.out.println(counter + " ==> " + pokemon);
            counter++;
        }
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
