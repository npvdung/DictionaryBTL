import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class DictionaryManagement {
    private final Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insertFromCommandline(String target, String pronounce, String explain) {
        Word insertWord = new Word(target, pronounce, explain);
        dictionary.add(insertWord);
    }

    public void insertFromFile() throws FileNotFoundException {
        String url = "src/dictionaries.txt";

        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);
        while (sc.hasNextLine()) {
            String WordInput = sc.nextLine();
            String target = WordInput.split("@")[0];
            String pronounce = WordInput.split("@")[2];
            String explain = WordInput.split("@")[3];
            Word wordInput = new Word(target, pronounce, explain);
            dictionary.add(wordInput);
        }

    }

    public void dictionaryLookup(String key) {
        key = key.toLowerCase();
        boolean flag = false;
        for (Word word : dictionary.getWordArray()) {
            String searchingWord = word.getWordTarget().trim().toLowerCase();
            if (searchingWord.equals(key)) {
                System.out.println(word.getWordPronounce() + " "+ word.getWordExplain());
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Cannot find word " + key);
        }
    }


}
