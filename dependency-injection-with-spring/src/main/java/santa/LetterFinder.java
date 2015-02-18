package santa;

import java.util.ArrayList;
import java.util.List;

public class LetterFinder {

    private LetterProvider letterProvider;

    //constructor injection
    public LetterFinder(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
    }

    public LetterFinder() {
    }

    public List<LetterToSanta> getLettersFrom(String name) {
        List<LetterToSanta> matched = new ArrayList<>();
        for (LetterToSanta letter : letterProvider.getLetters()) {
            if (letter.getFrom().equals(name)) {
                matched.add(letter);
            }
        }
        return matched;
    }

    //setter injection
    public void setLetterProvider(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
    }


}
