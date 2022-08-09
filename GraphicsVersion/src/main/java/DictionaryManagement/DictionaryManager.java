package DictionaryManagement;

import java.io.*;
import java.util.Scanner;

public class DictionaryManager {
    private final Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insert(String target, String type, String pronounce, String explain) {
        Word insertWord = new Word(target, type, pronounce, explain);
        dictionary.add(insertWord);
    }

    public void insertFromFile() throws IOException {
        String url = "src/dictionaries.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String target = input.split("@")[0].toLowerCase();
            String type = input.split("@")[1];
            String pronounce = input.split("@")[2];
            String explain = input.split("@")[3];
            Word wordInput = new Word(target, type, pronounce, explain);
            dictionary.add(wordInput);
        }
        fileInputStream.close();
        sc.close();
    }

    public void dictionaryLookup(String key) {
        key = key.toLowerCase();

        for (Word word : dictionary.getWordArray()) {
            String searchingWord = word.getWordTarget().trim().toLowerCase();
            if (searchingWord.equals(key)) {
                System.out.println(word.getWordPronounce() + " " + word.getWordExplain());
                return;
            }
        }
        System.out.println("Cannot find word " + key);
    }

    public void delete(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < dictionary.getWordArray().size(); i++) {
            String key = dictionary.getWordElement(i).getWordTarget().toLowerCase();
            if (key.equals(word)) {
                dictionary.removeWordElement(i);
                return;
            }
        }
        System.out.println("Dictionary doesn't have word " + word);
    }

    public String[] dictionarySearcher(String find) {
        find = find.toLowerCase();
        return dictionary.getTrie().findAllWord(find);
    }

    public void exportToFile() throws IOException {
        String url = "src/dictionaries.txt";
        File file = new File(url);
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        for (int i = 0; i < dictionary.getWordArray().size(); i++) {
            String target = dictionary.getWordElement(i).getWordTarget();
            String type = dictionary.getWordElement(i).getWordType();
            String pronounce = dictionary.getWordElement(i).getWordPronounce();
            String explain = dictionary.getWordElement(i).getWordExplain();
            String fullKey = target + "@" + type + "@" + pronounce + "@" + explain + "\n";
            outputStreamWriter.write(fullKey);
        }
        outputStreamWriter.flush();
    }
}