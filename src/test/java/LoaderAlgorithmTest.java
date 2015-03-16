import algorithm.LoaderAlgorithm;
import org.junit.Test;
import service.YesOrNo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoaderAlgorithmTest {

    @Test
    public void should_return_correct_array_given_right_parameter() throws Exception {
        //Given
        int sessionCapacity = 180;
        int[] talksLength = new int[]{60, 1, 1, 60, 1, 60};
        LoaderAlgorithm algorithm = new LoaderAlgorithm();

        //When
        YesOrNo[] arrangedTalkIndex = algorithm.arrange(sessionCapacity, talksLength);

        //Then
        assertThat(arrangedTalkIndex[0], is(YesOrNo.YES));
        assertThat(arrangedTalkIndex[1], is(YesOrNo.NO));
        assertThat(arrangedTalkIndex[2], is(YesOrNo.NO));
        assertThat(arrangedTalkIndex[3], is(YesOrNo.YES));
        assertThat(arrangedTalkIndex[4], is(YesOrNo.NO));
        assertThat(arrangedTalkIndex[5], is(YesOrNo.YES));
    }
}