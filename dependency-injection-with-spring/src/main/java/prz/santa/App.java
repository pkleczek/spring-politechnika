package prz.santa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import prz.santa.model.LetterToSanta;
import santa.config.BeansConfig;

public class App {
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfig.class);

        LetterService lf1 = (LetterService) ctx.getBean("letterFinder");
        LetterService lf2 = ctx.getBean("letterFinder", LetterService.class);
        LetterService lf3 = ctx.getBean(LetterService.class);

        String text = ctx.getBean("inneZiarno", String.class);
        Long longVal = ctx.getBean(Long.class);

        System.out.println(text + " / " + longVal);

        for (LetterToSanta l : lf1.getLettersFrom("Ania")) {
            System.out.println(l);
        }

        System.out.println((lf1 == lf2) && (lf1 == lf3));

    }
}
