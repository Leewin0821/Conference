package service;

import com.google.common.collect.Lists;
import domain.Session;
import domain.Talk;

import java.util.List;

/**
 * Created by leewin on 15/3/8.
 */
public final class TalkDispatcher implements Dispatcher {

    private final int SESSION_CAPACITY = 120;
    private List<Talk> talkList;

    int currentCapacity = 0;
    int currentBestCapacity = 0;
    int restTimeCapacity;
    int totalTalkQuantity;
    int[] currentSolution;
    int[] currentBestSolution;

    public TalkDispatcher(List<Talk> talkList) {
        this.talkList = talkList;
        totalTalkQuantity = talkList.size();
        currentSolution = new int[totalTalkQuantity];
        currentBestSolution = new int[totalTalkQuantity];
    }

    @Override
    public List<Session> dispatch() {
        List<Session> sessionList = Lists.newArrayList();
        for (Talk talk : talkList) {
            restTimeCapacity += talk.getTalkLength();
        }
        backtrace(0);
        List<Talk> schemedTalks = Lists.newLinkedList();
        for (Talk talk : talkList) {
            if (talk.isSchemed()) {
                schemedTalks.add(talk);
//                talkList.remove(talk);
            }
        }
        Session session = new Session(schemedTalks);
        sessionList.add(session);
        return sessionList;
    }

    private void backtrace(int index) {
        if (index > totalTalkQuantity - 1) {
            if (currentCapacity > currentBestCapacity) {
                for (int j = 0; j < totalTalkQuantity; j++) {
                    currentBestSolution[j] = currentSolution[j];
                    currentBestCapacity = currentCapacity;
                }
                return;
            }
        }
        restTimeCapacity -= talkList.get(index).getTalkLength();
        if (currentCapacity + talkList.get(index).getTalkLength() < SESSION_CAPACITY) {
            currentSolution[index] = 1;
            talkList.get(index).setSchemed(true);
            currentCapacity += talkList.get(index).getTalkLength();
            backtrace(index + 1);
            currentCapacity -= talkList.get(index).getTalkLength();
        }
        if (currentCapacity + restTimeCapacity > currentBestCapacity) {
            currentSolution[index] = 0;
            talkList.get(index).setSchemed(false);
            backtrace(index + 1);
        }
        restTimeCapacity += talkList.get(index).getTalkLength();
    }

}
