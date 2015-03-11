import algorithm.LoaderAlgorithm;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoaderAlgorithmTest {

    @Test
    public void should_return_correct_array_given_right_parameter() throws Exception {
        //Given
        int sessionCapacity = 180;
        int[] talksLength = new int[]{60, 10, 45, 60, 15, 40};
        LoaderAlgorithm algorithm = new LoaderAlgorithm();

        //When
        int[] arrangedTalkIndex = algorithm.arrange(sessionCapacity, talksLength);

        //Then
        assertThat(arrangedTalkIndex[0], is(1));
        assertThat(arrangedTalkIndex[1], is(0));
        assertThat(arrangedTalkIndex[2], is(1));
        assertThat(arrangedTalkIndex[3], is(1));
        assertThat(arrangedTalkIndex[4], is(1));
        assertThat(arrangedTalkIndex[5], is(0));
    }
}