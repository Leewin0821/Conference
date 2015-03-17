package domain;

import algorithm.LoaderAlgorithm;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import service.YesOrNo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lwzhang on 3/10/15.
 */
public final class Track {

    private final int SESSION_LENGTH = 180;

    private List<Talk> originTalkList;
    private List<Talk> sortedTalkList;
    private Talk lunch;
    private Talk networkingEvent;

    public Track(List<Talk> originTalkList) {
        init(originTalkList);
    }

    private void init(List<Talk> talkList) {
        this.originTalkList = talkList;
        sortedTalkList = Lists.newLinkedList();
        lunch = new Talk("Lunch", 60);
        networkingEvent = new Talk("Networking Event", 60);
    }

    public List<Talk> sortTalk() {
        List<Integer> talkLengthList = Lists.newArrayList();
        for (Talk talk : originTalkList) {
            talkLengthList.add(talk.getTalkLength());
        }
        Integer[] talkLengthArray = Arrays.copyOf(talkLengthList.toArray(), talkLengthList.size(), Integer[].class);
        YesOrNo[] sortIndexes = new LoaderAlgorithm().arrange(SESSION_LENGTH, ArrayUtils.toPrimitive(talkLengthArray));

        for (int index = 0; index < sortIndexes.length; index++) {
            if (sortIndexes[index].equals(YesOrNo.YES)){
                Talk talk = originTalkList.get(index);
                sortedTalkList.add(talk);
                originTalkList.remove(talk);
            }
        }
        sortedTalkList.add(lunch);
        sortedTalkList.addAll(originTalkList);
        sortedTalkList.add(networkingEvent);
        return sortedTalkList;
    }
}
