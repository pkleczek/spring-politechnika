package prz.santa.letterProviders;

import java.util.List;

import prz.santa.model.LetterToSanta;

/**
 * Created by Paweł on 05.12.13.
 */
public interface LetterProvider {
    List<LetterToSanta> getLetters();
}
