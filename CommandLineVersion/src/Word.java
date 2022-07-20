public class Word {
    String wordTarget;
    String wordPronounce;
    String wordExplain;

    public Word(String wordTarget, String wordPronounce, String wordExplain) {
        this.wordTarget = wordTarget;
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
}
