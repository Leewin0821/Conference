import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leewin on 15/3/7.
 */

public final class TalkParser implements Parser {

    @Override
    public List<Talk> parse(List<String> lineList) {
        List<Talk> talkList = Lists.newArrayList();
        String regexOne = "(.*)(\\s)(\\d+)(min)";
        String regexTwo = "(.*)(\\s)(lightning)";
        Pattern patternOne = Pattern.compile(regexOne);
        Pattern patternTwo = Pattern.compile(regexTwo);

        for (String inputLine : lineList) {
            if (!inputLine.contains("lightning")){
                Matcher matcher = patternOne.matcher(inputLine);
                if (matcher.find()) {
                    Talk talk = new Talk(matcher.group(1), Integer.valueOf(matcher.group(3)));
                    talkList.add(talk);
                }
            } else {
                Matcher matcher = patternTwo.matcher(inputLine);
                if (matcher.find()) {
                    Talk talk = new Talk(matcher.group(1), 5);
                    talkList.add(talk);
                }
            }
        }
        return talkList;
    }
}
