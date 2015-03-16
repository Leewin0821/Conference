package domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by lwzhang on 3/16/15.
 */
public final class TalkList {
    private List<Talk> talkList;

    public TalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public int getSize() {
        return talkList.size();
    }

    public Talk getTalk(int index) {
        return talkList.get(index);
    }

    public int getTotalTimeLength(){
        int totalTimeLength = 0;
        for (Talk talk : talkList) {
            totalTimeLength += talk.getTalkLength();
        }
        return totalTimeLength;
    }

    public void removeTalks(List<Talk> talks) {
        talkList.removeAll(talks);
    }

    public List<Integer> getTalkLengthList() {
        List<Integer> talkLengthList = Lists.newArrayList();
        for (Talk talk : talkList) {
            talkLengthList.add(talk.getTalkLength());
        }
        return talkLengthList;
    }
}
