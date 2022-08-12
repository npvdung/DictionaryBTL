package DictionaryManagement;

import dataStructure.Trie;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<Word> wordArray = new ArrayList<>();
    Trie trie = new Trie();

    public Trie getTrie() {
        return trie;
    }

    public List<Word> getWordArray() {
        return wordArray;
    }

    public Word getWordElement(int index) {
        return this.wordArray.get(index);
    }

    public void add(Word word) {
        this.wordArray.add(word);
        this.trie.insert(word.wordTarget);
    }

    public void removeWordElement(int index) {
        this.wordArray.remove(index);
    }
}