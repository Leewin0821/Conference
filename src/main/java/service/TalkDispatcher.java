package service;

import algorithm.Algorithm;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import domain.Talk;
import domain.Track;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by leewin on 15/3/8.
 */
public final class TalkDispatcher implements Dispatcher {

    private static final int TRACK_LENGTH = 420;
    private List<Talk> talkList;
    private Algorithm algorithm;
    private int count;
    private List<Track> trackList;
    private Map<Integer, List<Talk>> schemedTalkMap;

    public TalkDispatcher(List<Talk> talkList, Algorithm algorithm) {
        init(talkList, algorithm);
    }

    private void init(List<Talk> talkList, Algorithm algorithm) {
        count = 0;
        this.talkList = talkList;
        this.algorithm = algorithm;
        trackList = Lists.newLinkedList();
        schemedTalkMap = Maps.newHashMap();
    }

    @Override
    public List<Track> dispatch() {
        loadTalksIntoSessions();
        for (int index = 0; index < schemedTalkMap.size(); index++) {
            Track track = new Track(schemedTalkMap.get(index));
            trackList.add(track);
        }
        return trackList;
    }

    private void loadTalksIntoSessions() {

        if (talkList.size() == 0) {
            return;
        } else {
            List<Integer> talkLengthList = Lists.newLinkedList();
            for (Talk talk : talkList) {
                talkLengthList.add(talk.getTalkLength());
            }
            Integer[] originalTalkLengthArray = Arrays.copyOf(talkLengthList.toArray(), talkLengthList.size(), Integer[].class);
            //TODO: not 0 and 1, use enum
            int[] schemedTalksPositions = algorithm.arrange(TRACK_LENGTH, ArrayUtils.toPrimitive(originalTalkLengthArray));

            List<Talk> arrangedTalks = Lists.newLinkedList();
            for (int index = 0; index < schemedTalksPositions.length; index++) {
                if (schemedTalksPositions[index] == 1) {
                    arrangedTalks.add(talkList.get(index));
                }
            }
            schemedTalkMap.put(count, arrangedTalks);
            talkList.removeAll(arrangedTalks);
            count++;
            loadTalksIntoSessions();
        }
    }


}
