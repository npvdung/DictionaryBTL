public class Word {
    String wordTarget;
    String wordExplain;

    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    public void setWord_target(String word_target) {
        this.wordTarget = word_target;
    }

    public void setWordExplain(String word_explain) {
        this.wordExplain = word_explain;
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }
}
