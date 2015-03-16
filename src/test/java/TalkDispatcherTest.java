import algorithm.Algorithm;
import algorithm.LoaderAlgorithm;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import domain.Talk;
import domain.Track;
import org.junit.Test;
import service.TalkDispatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TalkDispatcherTest {

    @Test
    public void should_return_track_list_given_talk_list_and_algorithm() throws Exception {

        //Given
        List<Talk> talkList = Lists.newArrayList(
                new Talk("TitleOne", 60),
                new Talk("TitleTwo", 60),
                new Talk("TitleThree", 30),
                new Talk("TitleFour", 45),
                new Talk("TitleFive", 45),
                new Talk("TitleSix", 30),
                new Talk("TitleSeven", 30),
                new Talk("TitleEight", 45),
                new Talk("TitleNine", 45),
                new Talk("TitleTen", 30),
                new Talk("TitleEleven", 30)
        );
        Algorithm algorithm = new LoaderAlgorithm();

        //When
        List<Track> trackList = new TalkDispatcher(talkList, algorithm).dispatch();

        //Then
        assertThat(trackList.size(), is(2));
    }
}