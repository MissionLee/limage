package org.missionlee.limage.utils.file;

import java.io.File;
import java.util.List;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 19:34 2018/7/31
 **/
public interface StructuredResource {
    // 返回站点列表
    public List<File> getSites();
    // 返回作者列表
    public List<File> getArtists(String siteName);
    // 返回作品列表
    public List<File> getWorks(String artistName);
}
