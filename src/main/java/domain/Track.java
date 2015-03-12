package domain;

import java.util.List;

/**
 * Created by lwzhang on 3/10/15.
 */
public class Track {

    private List<Session> sessionList;

    public void addSession(Session session) {
        sessionList.add(session);
    }

    public Session getMorningSessions(){
        for (Session session : sessionList){
            if (session instanceof MorningSession){
                return session;
            }
        }
        return null;
    }

    public Session getAfternoonSessions(){
        for (Session session : sessionList){
            if (session instanceof AfternoonSession){
                return session;
            }
        }
        return null;
    }
}
