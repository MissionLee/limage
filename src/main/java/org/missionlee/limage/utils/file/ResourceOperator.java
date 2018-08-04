package org.missionlee.limage.utils.file;

import org.missionlee.limage.Resource.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 19:32 2018/7/31
 **/
public class ResourceOperator implements StructuredResource,ResourceMarker {
    private String rootPath = "D:\\004.音乐电影\\03.图片\\图片";
    private Resource resource;
    public ResourceOperator(String rootPath) throws Exception {
        this.rootPath=rootPath;
        this.resource = new Resource(rootPath);
    }

    private List<File> directoryFilter(File[] fileList) {
        List<File> directoryFileList = new ArrayList<>();
        int length = fileList.length;
        for (int i = 0; i < length; i++) {
            if (fileList[i].isDirectory())
                directoryFileList.add(fileList[i]);
        }
        return directoryFileList;
    }

    @Override
    public List<File> getSites() {
        //List<File> tmpSiteList = directoryFilter(root.listFiles());
        return null;
    }

    @Override
    public List<File> getArtists(String siteName) {
        return null;
    }

    public List<File> getArtists() {
        return null;
    }

    @Override
    public List<File> getWorks(String artistName) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        ResourceOperator ro = new ResourceOperator("D:\\004.音乐电影\\03.图片");
        List<File> list = ro.getSites();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    @Override
    public boolean markAsArtist(File file) {
        return false;
    }

    @Override
    public boolean markAsSite(File file) {
        return false;
    }

    @Override
    public boolean markAsRoot(File file) {
        return false;
    }
}
