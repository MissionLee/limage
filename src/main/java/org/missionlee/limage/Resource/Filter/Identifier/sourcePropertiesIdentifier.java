package org.missionlee.limage.Resource.Filter.Identifier;

import java.io.File;
import java.io.FilenameFilter;


/**
 * @Author MissionLee
 * @Description
 * @Date Created in 20:20 2018/7/31
 **/
public class sourcePropertiesIdentifier implements FilenameFilter {
    static String rootMark = "resource.root.properties";
    static String siteMark = "resource.site.properties";
    static String artistMark = "resource.artist.properties";
    String dicMark;
    public sourcePropertiesIdentifier(DicMarker dicMarker) {
        switch (dicMarker){
            case ROOT:this.dicMark=rootMark; break;
            case SITE:this.dicMark=siteMark; break;
            case ARTIST:this.dicMark=artistMark; break;
        }
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.equals(dicMark);
    }
}
