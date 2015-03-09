package service;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import service.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by leewin on 15/3/7.
 */
public final class TalkFileReader implements FileReader {

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        List<String> readLines = Lists.newArrayList();
        try {
            readLines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines;
    }
}
