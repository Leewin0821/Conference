package domain;

import java.util.List;

/**
 * Created by lwzhang on 3/9/15.
 */
public final class MorningSession extends Session {

    private final int SESSION_CAPACITY = 180;

    public MorningSession(List<Talk> talkList) {
        super(talkList);
    }
}
