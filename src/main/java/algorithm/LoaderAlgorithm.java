package algorithm;

/**
 * Created by lwzhang on 3/10/15.
 */
public class LoaderAlgorithm implements Algorithm {

    int sessionCapacity;
    int currentCapacity;
    int currentBestCapacity;
    int restTimeCapacity;
    int totalTalkQuantity;
    int[] currentSolution;
    int[] currentBestSolution;
    int[] talksLength;

    @Override
    public int[] arrange(int sessionCapacity, int[] talksLength) {
        init(sessionCapacity, talksLength);
        for (int index=0;index<totalTalkQuantity; index++){
            restTimeCapacity += talksLength[index];
        }
        backtrace(0);
        return currentBestSolution;
    }

    private void init(int sessionCapacity, int[] talksLength) {
        this.sessionCapacity = sessionCapacity;
        this.talksLength = talksLength;
        totalTalkQuantity = talksLength.length;
        currentSolution = new int[totalTalkQuantity];
        currentBestSolution = new int[totalTalkQuantity];
    }

    private void backtrace(int index) {
        if (index > totalTalkQuantity - 1) {
            if (currentCapacity > currentBestCapacity) {
                for (int j = 0; j < totalTalkQuantity; j++) {
                    currentBestSolution[j] = currentSolution[j];
                    currentBestCapacity = currentCapacity;
                }
                return;
            }
        }
        restTimeCapacity -= talksLength[index];
        if (currentCapacity + talksLength[index] <= sessionCapacity) {
            currentSolution[index] = 1;
            currentCapacity += talksLength[index];
            backtrace(index + 1);
            currentCapacity -= talksLength[index];
        }
        if (currentCapacity + restTimeCapacity > currentBestCapacity) {
            currentSolution[index] = 0;
            backtrace(index + 1);
        }
        restTimeCapacity += talksLength[index];
    }
}
