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
}
