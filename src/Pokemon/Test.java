package pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static List<String> listOfPokemonStacks = new ArrayList<>();
    public static Map<Integer, List<String>> pokemonStacksMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String csvDir = "Rush2.csv";
        FileService fs = new FileService();
        listOfPokemonStacks = fs.ReadCSV(csvDir);

        for (int i = 0; i < listOfPokemonStacks.size(); i++) {
            String[] pokemonSequence = listOfPokemonStacks.get(i).split(",");
            List<String> pokemonArray = new ArrayList<>();for(
            String pokemon:pokemonSequence)
            {
                pokemonArray.add(pokemon);
            }
        
            System.out.println(pokemonArray.toString());
        }

    }

}
