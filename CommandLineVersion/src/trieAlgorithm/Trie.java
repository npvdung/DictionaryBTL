package trieAlgorithm;

public class Trie {
    public static TrieNode root = new TrieNode();

    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (trieNode.getChildren()[index] == null) {
                trieNode.getChildren()[index] = new TrieNode();
            }
            trieNode = trieNode.getChildren()[index];
        }
        trieNode.setEndOfWord(true);
        trieNode.setWordData(word);
    }

    public TrieNode search(String prefix) {
        prefix = prefix.toLowerCase();
        TrieNode trieNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (trieNode.getChildren()[index] == null) {
                return null;
            }
            trieNode = trieNode.getChildren()[index];
        }
        return trieNode;
    }

    public String find(TrieNode keyNode) {
        if (keyNode == null) {
            return "";
        }
        String ans = (keyNode.isEndOfWord() ? keyNode.getWordData() + "@" : "");
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if (keyNode.getChildren()[i] != null) {
                ans = ans.concat(find(keyNode.getChildren()[i]));
            }
        }
        return ans;
    }

    public String[] findAllWord(String key) {
        key = key.toLowerCase();
        TrieNode trieNode = this.search(key);
        return this.find(trieNode).split("@");
    }
}
