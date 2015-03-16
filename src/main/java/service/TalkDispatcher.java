package service;

import algorithm.Algorithm;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import domain.Talk;
import domain.TalkList;
import domain.Track;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by leewin on 15/3/8.
 */
public final class TalkDispatcher implements Dispatcher {

    private final int TRACK_LENGTH = 420;
    private TalkList talkList;
    private Algorithm algorithm;
    private int count;
    private Map<Integer, List<Talk>> schemedTalkMap;

    public TalkDispatcher(List<Talk> talkList, Algorithm algorithm) {
        init(talkList, algorithm);
    }

    private void init(List<Talk> talkList, Algorithm algorithm) {
        count = 0;
        this.talkList = new TalkList(talkList);
        this.algorithm = algorithm;
        schemedTalkMap = Maps.newHashMap();
    }

    @Override
    public List<Track> dispatch() {
        loadTalksIntoTracks();
        return assembleTracks();
    }

    private List<Track> assembleTracks() {
        List<Track> trackList = Lists.newLinkedList();
        for (int index = 0; index < schemedTalkMap.size(); index++) {
            Track track = new Track(schemedTalkMap.get(index));
            trackList.add(track);
        }
        return trackList;
    }

    private void loadTalksIntoTracks() {

        if (talkList.getSize() == 0) {
            return;
        } else if (talkList.getTotalTimeLength() <= TRACK_LENGTH) {
            schemedTalkMap.put(count, talkList.getTalkList());
        } else {
            List<Integer> talkLengthList = talkList.getTalkLengthList();
            Integer[] originalTalkLengthArray = Arrays.copyOf(talkLengthList.toArray(), talkLengthList.size(), Integer[].class);
            YesOrNo[] schemedTalksPositions = algorithm.arrange(TRACK_LENGTH, ArrayUtils.toPrimitive(originalTalkLengthArray));

            List<Talk> arrangedTalks = Lists.newLinkedList();
            for (int index = 0; index < schemedTalksPositions.length; index++) {
                if (schemedTalksPositions[index] == YesOrNo.YES) {
                    arrangedTalks.add(talkList.getTalk(index));
                }
            }
            schemedTalkMap.put(count, arrangedTalks);
            talkList.removeTalks(arrangedTalks);
            count++;
            loadTalksIntoTracks();
        }
    }


}
