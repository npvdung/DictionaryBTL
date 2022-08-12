package DictionaryManagement;

public class Word {
    String wordTarget;
    String wordPronounce;
    String wordExplain;

    String wordType;

    public Word(String wordTarget, String wordType, String wordPronounce, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordType = wordType;
        this.wordPronounce = wordPronounce;
        this.wordExplain = wordExplain;
    }

    public void setWord_target(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public void setWordPronounce(String wordPronounce) {
        this.wordPronounce = wordPronounce;
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public String getWordPronounce() {
        return wordPronounce;
    }

    public String getWordType() {
        return wordType;
    }
}