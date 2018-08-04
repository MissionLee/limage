package org.missionlee.limage.Resource;

import org.missionlee.limage.Resource.Filter.Identifier.DicMarker;
import org.missionlee.limage.Resource.Filter.Identifier.sourcePropertiesIdentifier;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author MissionLee
 * @Description : 存储一个本地图片结构的实体，包括根，站点，作者 信息，和常用的方法
 * @Date Created in 9:48 2018/8/2
 **/
public class Resource {
    private String rootPath;
    private File root;
    private File[] sites;
    private Map<String,File[]> artists;
    public Resource(String rootPath) throws Exception {
        this.rootPath = rootPath;
        this.root = new File(rootPath);
        //检测 root 内是否有 root标记文件
        if(!root.isDirectory() || root.list(new sourcePropertiesIdentifier(DicMarker.ROOT)).length!=1){
            throw new Exception("Wrong root path:"+rootPath);
        }else{
            // root中 所有带有 site标记的文件为 site 文件
            this.sites = root.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            });
            int length = this.sites.length;
            this.artists = new HashMap<>();
            for (int i = 0; i < length; i++) {
                this.artists.put(sites[i].getName(),sites[i].listFiles());
            }
        }
    }

    public File[] getSites() {
        return sites;
    }

    public Map<String, File[]> getArtists() {
        return artists;
    }

    public String toString(){
        String list = "root:"+root.getName()+"\n";
        for (int i = 0; i < sites.length; i++) {
            System.out.println(sites[i].getName());
        }
//        System.out.println(artists);
        for (String site: artists.keySet()
             ) {
//            System.out.println(site);
            list = list+"|--"+site+"\n";
//            System.out.println(artists.get(site));
            for (int i = 0; i < artists.get(site).length; i++) {
                list = list + "  |--"+artists.get(site)[i].getName()+"\n";
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        Resource resource = new Resource("D:\\004.音乐电影\\03.图片");
        System.out.println("===================");
        System.out.println(resource);
    }
}
