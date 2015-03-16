package algorithm;

import domain.Track;
import service.YesOrNo;

import java.util.List;

/**
 * Created by lwzhang on 3/10/15.
 */
public interface Algorithm {
    public YesOrNo[] arrange(int capacity, int[] weights);
}
