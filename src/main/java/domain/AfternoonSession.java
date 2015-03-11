package domain;

import java.util.List;

/**
 * Created by lwzhang on 3/11/15.
 */
public final class AfternoonSession extends Session {

    private final int SESSION_CAPACITY = 240;

    public AfternoonSession(List<Talk> talkList) {
        super(talkList);
    }
}
