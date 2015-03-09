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
    int restTimeCapacity = 0;
    int totalTalkQuantity;
    int currentTalkLength;
    int[] currentSolution;
    int[] currentBestSolution;

    public TalkDispatcher(List<Talk> talkList) {
        this.talkList = talkList;
    }

    @Override
    public List<Session> dispatch() {
        List<Session> sessionList = Lists.newArrayList();
        for (; talkList.size() != 0; ) {
            backtrace(0);
            List<Talk> schemedTalks = Lists.newLinkedList();
            for (Talk talk : talkList) {
                if (talk.isSchemed()) {
                    schemedTalks.add(talk);
                    talkList.remove(talk);
                }
            }
            Session session = new Session(schemedTalks);
            sessionList.add(session);
        }
        return sessionList;
    }

    private void backtrace(int index) {
        totalTalkQuantity = talkList.size();
        currentTalkLength = talkList.get(index).getTalkLength();
        for (Talk talk : talkList) {
            restTimeCapacity += talk.getTalkLength();
        }
        currentSolution = new int[totalTalkQuantity];
        currentBestSolution = new int[totalTalkQuantity];
        System.out.println(currentCapacity);
        System.out.println(currentTalkLength);
        System.out.println(currentBestCapacity);
        System.out.println(restTimeCapacity);
        System.out.println("***********************");
        if (index > totalTalkQuantity - 1) {
            if (currentCapacity > currentBestCapacity) {
                for (int j = 0; j < totalTalkQuantity; j++) {
                    currentBestSolution[j] = currentSolution[j];
                    currentBestCapacity = currentCapacity;
                }
                for (int indexOfBestArray = 0; indexOfBestArray<currentBestSolution.length; indexOfBestArray++ ){
                    if (currentBestSolution[indexOfBestArray]==1){
                        talkList.get(indexOfBestArray).setSchemed(true);
                    }
                }
                return;
            }
        }
        restTimeCapacity -= currentTalkLength;
        if (currentCapacity + currentTalkLength < SESSION_CAPACITY) {
            currentSolution[index] = 1;
            currentCapacity += currentTalkLength;
            backtrace(index + 1);
            currentCapacity -= currentTalkLength;
        }
        if (currentCapacity + restTimeCapacity > currentBestCapacity) {
            currentSolution[index] = 0;
            backtrace(index + 1);
        }
        restTimeCapacity += currentTalkLength;
    }

}
