package domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by lwzhang on 3/10/15.
 */
public class Track {

    private List<Talk> talkList;

    public Track(List<Talk> talkList) {
        init(talkList);
    }

    private void init(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public void addTalk(Talk talk) {
        talkList.add(talk);
    }

    public List<Talk> getTalkList(){
        return talkList;
    }

}
