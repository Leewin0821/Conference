import com.google.common.collect.ImmutableList;
import domain.Session;
import domain.Talk;
import org.junit.Test;
import service.TalkDispatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TalkDispatcherTest {

//    @Test
//    public void should_return_session_given_talk_list() throws Exception {
//        //Given
//        ImmutableList<Talk> talkList = ImmutableList.of(
//                new Talk("Writing Fast Tests Against Enterprise Rails", 60),
//                new Talk("Overdoing it in Python", 45),
//                new Talk("Lua for the Masses", 30),
//                new Talk("Ruby Errors from Mismatched Gem Versions", 45),
//                new Talk("Common Ruby Errors", 45),
//                new Talk("Rails for Python Developers", 5),
//                new Talk("Communicating Over Distance", 60),
//                new Talk("Accounting-Driven Development", 45),
//                new Talk("Woah", 30),
//                new Talk("Sit Down and Write", 30));
//        TalkDispatcher talkDispatcher = new TalkDispatcher(talkList);
//
//        //When
//        List<Session> sessions = talkDispatcher.dispatch();
//
//        //Then
//        assertThat(sessions.size(), is(4));
//        assertThat(sessions.get(0).countTimeConsumption(), is(120));
//        assertThat(sessions.get(1).countTimeConsumption(), is(120));
//        assertThat(sessions.get(2).countTimeConsumption(), is(120));
//        assertThat(sessions.get(3).countTimeConsumption(), is(35));
//    }


    @Test
    public void should_return_one_session_given_less_than_240min_talks_list() throws Exception {
        //Given
        List<Talk> talks = new ArrayList<Talk>();
        talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
        talks.add(new Talk("Lua for the Masses", 30));
        talks.add(new Talk("Ruby Errors from Mismatched Gem Versions", 45));
        talks.add(new Talk("Communicating Over Distance", 60));

        TalkDispatcher dispatcher = new TalkDispatcher(talks);

        //When
        List<Session> sessions = dispatcher.dispatch();

        //Then
        assertThat(sessions.size(), is(1));
        assertThat(sessions.get(0).countTimeConsumption(), is(120));
    }
}