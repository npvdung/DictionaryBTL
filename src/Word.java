public class Word {
    //new words
    String word_target;
    // definition
    String word_explain;
    // pronunciation
    String word_pronounce;
    // parts of speech
    String word_pos;

    public Word(String word_target, String word_explain,
                String word_pronounce, String word_pos) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.word_pronounce = word_pronounce;
        this.word_pos = word_pos;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_pronounce() {
        return word_pronounce;
    }

    public void setWord_pronounce(String word_pronounce) {
        this.word_pronounce = word_pronounce;
    }

    public String getWord_pos() {
        return word_pos;
    }

    public void setWord_pos(String word_pos) {
        this.word_pos = word_pos;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }
}
