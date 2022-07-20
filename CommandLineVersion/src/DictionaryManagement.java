public class DictionaryManagement {
    private final Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void insertFromCommandline(String target, String explain) {
        Word insertWord = new Word(target, explain);
        dictionary.addWordElement(insertWord);
    }
}
