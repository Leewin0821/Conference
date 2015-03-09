package domain;

/**
 * Created by lwzhang on 3/6/15.
 */
public final class Talk {

    private final String talkTitle;
    private final int talkLength;

    public Talk(String talkTitle, int talkLength) {
        this.talkTitle = talkTitle;
        this.talkLength = talkLength;
    }

    public int getTalkLength() {
        return talkLength;
    }

    public String getTalkTitle() {
        return talkTitle;
    }
}
