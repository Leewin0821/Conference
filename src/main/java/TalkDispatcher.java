import java.util.Map;
import java.util.List;

/**
 * Created by leewin on 15/3/8.
 */
public final class TalkDispatcher implements Dispatcher {

    @Override
    public Map<Integer, List<Talk>> dispatch(List<Talk> talkList) {

    }

    private void backtrace(int index) {
        if (index > boxNumber -1) {
            if (currentCapacity > currentBestCapacity) {
                for (int j = 0; j < boxNumber; j++) {
                    currentBestSolution[j] = currentSolution[j];
                    currentBestCapacity = currentCapacity;
                }
                return;
            }
        }
        weightOfRestBoxes -= boxWeights[index];

        if (currentCapacity + boxWeights[index] < capacityOfFirstShip) {
            currentSolution[index] = 1;
            currentCapacity += boxWeights[index];
            backtrace(index + 1);
            currentCapacity -= boxWeights[index];
        }

        if (currentCapacity + weightOfRestBoxes > currentBestCapacity) {
            currentSolution[index] = 0;
            backtrace(index + 1);
        }
        weightOfRestBoxes += boxWeights[index];
    }
}
