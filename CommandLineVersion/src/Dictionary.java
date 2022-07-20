import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<Word> wordArray = new ArrayList<>();

    public void setWordArray(List<Word> wordArray) {
        this.wordArray = wordArray;
    }

    public List<Word> getWordArray() {
        return wordArray;
    }

    public Word getWordElement(int index) {
        return this.wordArray.get(index);
    }

    public void addWordElement(Word word) {
        this.wordArray.add(word);
    }

    public void removeWordElement(int index) {
        this.wordArray.remove(index);
    }
}
