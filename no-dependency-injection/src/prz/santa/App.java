package prz.santa;

import prz.santa.model.LetterToSanta;

public class App {
    public static void main(String... args) {
        LetterService finder = new LetterService();
        for (LetterToSanta letter : finder.getLettersFrom("Ania")) {
            System.out.println(letter);
        }
    }
}
