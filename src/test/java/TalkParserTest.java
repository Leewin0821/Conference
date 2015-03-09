import com.google.common.collect.ImmutableList;
import domain.Talk;
import org.junit.Test;
import service.TalkParser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class TalkParserTest {

    @Test
    public void should_return_correct_talkTitle_and_talkLength_given_correct_input() throws Exception {
        //Given
        ImmutableList<String> lineList = ImmutableList.of("Writing Fast Tests Against Enterprise Rails 60min",
                                                        "Rails for Python Developers lightning");
        TalkParser talkParser = new TalkParser();

        //When
        List<Talk> talkList = talkParser.parse(lineList);

        //Then
        assertThat(talkList.size(), is(2));
        assertThat(talkList.get(0).getTalkTitle(), is("Writing Fast Tests Against Enterprise Rails"));
        assertThat(talkList.get(0).getTalkLength(), is(60));
        assertThat(talkList.get(1).getTalkTitle(), is("Rails for Python Developers"));
        assertThat(talkList.get(1).getTalkLength(), is(5));
    }
}