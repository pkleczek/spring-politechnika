package santa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import prz.santa.LetterService;
import prz.santa.letterProviders.FilesystemLetterProvider;
import prz.santa.letterProviders.LetterProvider;

@Configuration
public class BeansConfig {

    @Bean
    //@Scope(value = "prototype")
    public LetterService letterFinder() {
        LetterService finder = new LetterService();
        finder.setLetterProvider(letterProvider1());
        //finder.setLetterProvider(new InMemoryLetterProvider());
        return finder;
    }

    @Bean
    public LetterProvider letterProvider1() {
        LetterProvider provider = new FilesystemLetterProvider("../letters.txt");
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
