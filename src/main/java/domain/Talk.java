package domain;

/**
 * Created by lwzhang on 3/6/15.
 */
public final class Talk implements Traceable {

    private final String talkTitle;
    private final int talkLength;
    private boolean isSchemed;

    public Talk(String talkTitle, int talkLength) {
        this.talkTitle = talkTitle;
        this.talkLength = talkLength;
        isSchemed = false;
    }

    public int getTalkLength() {
        return talkLength;
    }

    public String getTalkTitle() {
        return talkTitle;
    }

    @Override
    public boolean isSchemed() {
        return isSchemed;
    }

    @Override
    public void setSchemed(boolean isSchemed) {
        this.isSchemed = isSchemed;
    }
}
