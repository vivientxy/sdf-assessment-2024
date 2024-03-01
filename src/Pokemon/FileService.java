package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<String> ReadCSV(String fullPathFilename) throws IOException {
        // Task 1 - your code here
        File csvFile = new File(fullPathFilename);
        FileReader reader = new FileReader(csvFile);
        BufferedReader br = new BufferedReader(reader);

        List<String> pokemonStack = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            pokemonStack.add(line);
        }

        br.close();
        return pokemonStack;
    }

    public void writeAsCSV(String pokemons, String fullPathFilename) throws IOException {
        // check if file exists. if no, create new file
        File file = new File(fullPathFilename);
        if (!file.exists()) {
            file.createNewFile();
        }
        // write one row into the file
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(pokemons + "\n");
        bw.close();
    }
}
