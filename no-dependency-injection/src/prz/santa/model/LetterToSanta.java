package prz.santa.model;

public class LetterToSanta {
    private String from;
    private String text;
    private int age;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LetterToSanta(String from, String text, int age) {
        this.from = from;
        this.text = text;
        this.age = age;
    }

    @Override
    public String toString() {
        return "LetterToSanta{" +
                "from='" + from + '\'' +
                ", text='" + text + '\'' +
                ", age=" + age +
                '}';
    }
}
