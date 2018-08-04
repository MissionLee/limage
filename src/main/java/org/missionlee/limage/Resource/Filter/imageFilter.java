package org.missionlee.limage.Resource.Filter;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 20:03 2018/8/2
 **/
public class imageFilter implements FileFilter {
    private static Pattern imagePattern =Pattern.compile("^.+\\.(jpg|png|jpeg|gif)$",Pattern.CASE_INSENSITIVE);
//    private static String pattern = "^.+\\.(jpg|png|jpeg|gif)$";
    @Override
    public boolean accept(File pathname) {
//        return Pattern.matches(pattern,pathname.getName());
        return imagePattern.matcher(pathname.getName()).matches();
    }
}
