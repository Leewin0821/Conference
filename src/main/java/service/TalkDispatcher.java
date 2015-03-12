package service;

import algorithm.Algorithm;
import com.google.common.collect.Lists;
import domain.*;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by leewin on 15/3/8.
 */
public final class TalkDispatcher implements Dispatcher {

    private List<Talk> talkList;
    private Algorithm algorithm;
    private int count = 0;
    private List<Session> schemedSessionsList;
    private List<Track> trackList;
    private static final int MORNING_SESSION_CAPACITY = 180;
    private static final int AFTERNOON_SESSION_CAPACITY = 240;

    public TalkDispatcher(List<Talk> talkList, Algorithm algorithm) {
        this.talkList = talkList;
        this.algorithm = algorithm;
        schemedSessionsList = Lists.newLinkedList();
        trackList = Lists.newLinkedList();
    }

    @Override
    public List<Track> dispatch() {
        loadTalksIntoSessions();
        for (int index=0; index < schemedSessionsList.size(); index++){
            Track track = null;
            if (index%2 == 0){
                track = new Track();
                track.addSession(schemedSessionsList.get(index));
            } else {
                track.addSession(schemedSessionsList.get(index));
                trackList.add(track);
            }
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
            Integer[] originalTalkLengthArray = Arrays.copyOf(talkLengthList.toArray(),talkLengthList.size(), Integer[].class);
            int sessionCapacity = (count % 2 == 0) ? MORNING_SESSION_CAPACITY : AFTERNOON_SESSION_CAPACITY;
            //TODO: not 0 and 1, use enum
            int[] schemedTalksPositions = algorithm.arrange(sessionCapacity, ArrayUtils.toPrimitive(originalTalkLengthArray));

            List<Talk> arrangedTalks = Lists.newLinkedList();
            for (int index = 0; index < schemedTalksPositions.length; index++) {
                if (schemedTalksPositions[index] == 1) {
                    arrangedTalks.add(talkList.get(index));
                }
            }
            Session session = (count % 2 == 0) ? new MorningSession(arrangedTalks) : new AfternoonSession(arrangedTalks);
            schemedSessionsList.add(session);
            talkList.removeAll(arrangedTalks);
            count++;
            loadTalksIntoSessions();
        }
    }


}
