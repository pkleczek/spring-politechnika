package santa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import santa.FilesystemLetterProvider;
import santa.LetterFinder;
import santa.LetterProvider;

@Configuration
public class BeansConfig {

    @Bean
    //@Scope(value = "prototype")
    public LetterFinder letterFinder() {
        LetterFinder finder = new LetterFinder();
        finder.setLetterProvider(letterProvider1());
        //finder.setLetterProvider(new InMemoryLetterProvider());
        return finder;
    }

    @Bean
    public LetterProvider letterProvider1() {
        LetterProvider provider = new FilesystemLetterProvider("letters.txt");
        return provider;
    }

    @Bean
    public Long magicValue() {
        return Long.valueOf(42L);
    }

    @Bean
    public String inneZiarno() {
        return "Ala ma kota";
    }
}
