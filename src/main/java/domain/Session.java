package domain;

import java.util.List;

/**
 * Created by lwzhang on 3/9/15.
 */
public abstract class Session {

    private List<Talk> talkList;

    public Session(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public int sessionSize() {
        int sessionSize = 0;
        for (Talk talk : talkList){
            sessionSize += talk.getTalkLength();
        }
        return sessionSize;
    }
}
