import java.util.Scanner;

public class Loading {
    private int boxNumber;//集装箱数
    private int[] boxWeights;//集装箱重量数组
    private int capacityOfFirstShip;//第一艘轮船的载重量
    private int currentCapacity;//当前载重量
    private int currentBestCapacity;//当前最优载重量
    private int weightOfRestBoxes;//剩余集装箱重量
    private int[] currentSolution;//当前解
    private int[] currentBestSolution;//当前最优解

    public void backtrace(int index) {
        //1.到达叶节点  
        if (index > boxNumber -1) {   //i此时的值=叶节点+1
            if (currentCapacity > currentBestCapacity) {
                for (int j = 0; j < boxNumber; j++) {
                    currentBestSolution[j] = currentSolution[j];
                    currentBestCapacity = currentCapacity;
                }
                return;
            }
        }
        weightOfRestBoxes -= boxWeights[index];
        //2.搜索左子树  
        if (currentCapacity + boxWeights[index] < capacityOfFirstShip) {
            currentSolution[index] = 1;
            currentCapacity += boxWeights[index];
            backtrace(index + 1);
            currentCapacity -= boxWeights[index];
        }
        //3.搜索右子树  
        if (currentCapacity + weightOfRestBoxes > currentBestCapacity) {
            currentSolution[index] = 0;
            backtrace(index + 1);
        }
        weightOfRestBoxes += boxWeights[index];
    }

    public static void main(String[] args) {
        Loading loading = new Loading();

        loading.boxNumber = 3;
        loading.boxWeights = new int[]{60, 30, 45};
        loading.currentSolution = new int[loading.boxNumber];
        loading.currentBestSolution = new int[loading.boxNumber];
        System.out.println("输出货物的重量数组：");
//        for (int i = 0; i < loading.boxNumber; i++) {
//            loading.boxWeights[i] = (int) (100 * Math.random());
//            System.out.println(loading.boxWeights[i]);
//        }

        loading.capacityOfFirstShip = 120;

        for (int i = 0; i < loading.boxNumber; i++)
            loading.weightOfRestBoxes += loading.boxWeights[i];
        loading.backtrace(0);
        System.out.print("输出当前最优解:");
        for (int i = 0; i < loading.boxNumber; i++) System.out.print(loading.currentBestSolution[i] + " ");
        System.out.println();
        System.out.println("最优解：" + loading.currentBestCapacity);
    }


}  