package algorithm;

import service.YesOrNo;

/**
 * Created by lwzhang on 3/10/15.
 */
public interface Algorithm {
    public YesOrNo[] arrange(int capacity, int[] weights);
}
