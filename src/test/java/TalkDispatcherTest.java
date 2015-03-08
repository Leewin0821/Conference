import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TalkDispatcherTest {

    @Test
    public void should_return_map_of_talks_given_talk_list() throws Exception {
        //Given
        TalkDispatcher talkDispatcher = new TalkDispatcher();
        ImmutableList<Talk> talkList = ImmutableList.of(
                new Talk("Writing Fast Tests Against Enterprise Rails", 60),
                new Talk("Overdoing it in Python", 45),
                new Talk("Lua for the Masses", 30),
                new Talk("Ruby Errors from Mismatched Gem Versions", 45),
                new Talk("Common Ruby Errors", 45),
                new Talk("Rails for Python Developers", 5),
                new Talk("Communicating Over Distance", 60),
                new Talk("Accounting-Driven Development", 45),
                new Talk("Woah", 30),
                new Talk("Sit Down and Write", 30));

        //When
        Map<Integer, List<Talk>> listMap = talkDispatcher.dispatch(talkList);

        //Then
        assertThat(listMap.size(), is(4));
    }
}