package domain;

import java.util.List;

/**
 * Created by lwzhang on 3/9/15.
 */
public final class Session implements Measurable {
    private List<Talk> talkList;

    public Session(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    @Override
    public int countTimeConsumption() {
        int timeConsumption = 0;
        for (Talk talk : talkList){
            timeConsumption += talk.getTalkLength();
        }
        return timeConsumption;
    }
}
