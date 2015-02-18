package prz.santa.letterProviders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import prz.santa.model.LetterToSanta;

public class FilesystemLetterProvider implements LetterProvider {
    private String filename;

    public FilesystemLetterProvider(String filename) {
        this.filename = filename;
    }

    @Override
    public List<LetterToSanta> getLetters() {
        List<LetterToSanta> letters = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(";");
                if (items.length == 3) {
                    LetterToSanta letter = buildLetter(items);
                    letters.add(letter);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return letters;
    }

    private static LetterToSanta buildLetter(String[] items) {
        return new LetterToSanta(items[0], items[1], Integer.parseInt(items[2]));
    }
}
