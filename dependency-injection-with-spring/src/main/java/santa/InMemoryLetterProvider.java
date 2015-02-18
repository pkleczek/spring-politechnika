package santa;

import java.util.Arrays;
import java.util.List;

public class InMemoryLetterProvider implements LetterProvider {
    @Override
    public List<LetterToSanta> getLetters() {
        return Arrays.asList(
                new LetterToSanta("Janek", "Byłem niegrzeczny ale nie przynoś mi rózgi", 3),
                new LetterToSanta("Tomek", "Lego Mindstorms!", 16)
        );
    }
}
