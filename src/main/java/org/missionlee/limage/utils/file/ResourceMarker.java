package org.missionlee.limage.utils.file;

import java.io.File;
import java.util.List;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 16:21 2018/8/1
 **/
public interface ResourceMarker {
    // 标记文件夹为艺术家文件夹
    public boolean markAsArtist(File file);
    // 标记文件夹为站点文件夹
    public boolean markAsSite(File file);
    // 标记文件夹为跟
    public boolean markAsRoot(File file);
}
