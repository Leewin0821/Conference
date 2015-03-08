import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leewin on 15/3/7.
 */

public final class TalkParser implements Parser {
    private List<Talk> talkList = Lists.newArrayList();

    @Override
    public List<Talk> parse(List<String> lineList) {

        String regexForCommon = "(.*)(\\s)(\\d+)(min)";
        String regexForLightning = "(.*)(\\s)(lightning)";

        for (String inputLine : lineList) {
            if (!inputLine.contains("lightning")){
                matchAndAddTalk(regexForCommon, inputLine, false);
            } else {
                matchAndAddTalk(regexForLightning, inputLine, true);
            }
        }
        return talkList;
    }

    private void matchAndAddTalk(String regex, String inputLine, Boolean isLightning) {
        Talk talk;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.find()) {
            if (!isLightning){
                talk = new Talk(matcher.group(1), Integer.valueOf(matcher.group(3)));
            } else {
                talk = new Talk(matcher.group(1), 5);
            }
            talkList.add(talk);
        }
    }
}
