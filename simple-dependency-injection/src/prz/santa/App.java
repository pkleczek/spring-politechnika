package prz.santa;

import prz.santa.letterProviders.FilesystemLetterProvider;
import prz.santa.letterProviders.InMemoryLetterProvider;
import prz.santa.letterProviders.InjectLetterProvider;
import prz.santa.letterProviders.LetterProvider;
import prz.santa.model.LetterToSanta;

public class App {
    public static void main(String... args) {
        constructorInjection();
        setterInjection();
        interfaceInjection();
    }

    private static void constructorInjection() {
        //constructor injection
        LetterProvider letterProvider = new InMemoryLetterProvider();
        LetterService finder = new LetterService(letterProvider);
        for (LetterToSanta letter : finder.getLettersFrom("Janek")) {
            System.out.println(letter);
        }
    }

    private static void setterInjection() {
        //setter injection
        LetterProvider letterProvider = new FilesystemLetterProvider("../letters.txt");
        LetterService finder = new LetterService();
        finder.setLetterProvider(letterProvider);
        for (LetterToSanta letter : finder.getLettersFrom("Ania")) {
            System.out.println(letter);
        }
    }


    private static void interfaceInjection() {
        //interface injection
        //this is actually more complicated, container required
        LetterService finder = new LetterService();
        InjectLetterProvider anotherPerspectiveOnLetterFinder = finder;

        LetterProvider letterProvider = new InMemoryLetterProvider();
        anotherPerspectiveOnLetterFinder.injectLetterProvider(letterProvider);

        for (LetterToSanta letter : finder.getLettersFrom("Tomek")) {
            System.out.println(letter);
        }
    }

}
