import com.google.common.collect.Lists;
import domain.Talk;
import domain.Track;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrackTest {

    @Test
    public void should_get_sorted_track_given_valid_track() throws Exception {
        //Given
        Talk talkOne = new Talk("TitleOne", 180);
        Talk talkTwo = new Talk("TitleTwo", 240);
        Talk lunch = new Talk("Lunch", 60);
        Talk networkingEvent = new Talk("Networking Event", 60);

        Track track = new Track(Lists.newArrayList(talkTwo, talkOne));

        //When
        List<Talk> sortedTalk = track.sortTalk();

        //Then
        assertThat(sortedTalk.get(0).getTalkTitle(), is(talkOne.getTalkTitle()));
        assertThat(sortedTalk.get(1).getTalkTitle(), is(lunch.getTalkTitle()));
        assertThat(sortedTalk.get(2).getTalkTitle(), is(talkTwo.getTalkTitle()));
        assertThat(sortedTalk.get(3).getTalkTitle(), is(networkingEvent.getTalkTitle()));
    }
}