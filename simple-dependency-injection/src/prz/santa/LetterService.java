package prz.santa;

import java.util.ArrayList;
import java.util.List;

import prz.santa.letterProviders.InjectLetterProvider;
import prz.santa.letterProviders.LetterProvider;
import prz.santa.model.LetterToSanta;

public class LetterService implements InjectLetterProvider {

    private LetterProvider letterProvider;
    
    public LetterService() {}

    //constructor injection
    public LetterService(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
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

    @Override
    public void injectLetterProvider(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
    }
}
