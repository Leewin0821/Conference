import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TalkFileReaderTest {

    @Test
    public void should_return_correct_String_given_existing_filePath() throws Exception {
        //Given
        String filePath = getClass().getClassLoader().getResource("testFile.txt").getPath();
        TalkFileReader talkFileReader = new TalkFileReader();

        //When
        List<String> actualStringList = talkFileReader.read(filePath);

        //Then
        assertThat(actualStringList.size(), is(2));
        assertThat(actualStringList.get(0), is("Writing Fast Tests Against Enterprise Rails 60min"));
        assertThat(actualStringList.get(1), is("Rails for Python Developers lightning"));
    }
}