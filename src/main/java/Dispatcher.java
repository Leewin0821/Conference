import java.util.Map;
import java.util.List;

/**
 * Created by leewin on 15/3/8.
 */
public interface Dispatcher {
    public Map<Integer, List<Talk>> dispatch(List<Talk> talkList);
}
