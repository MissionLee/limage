package org.missionlee.limage.utils.file;

import java.io.File;

/**
 * @Author MissionLee
 * @Description
 * @Date Created in 19:19 2018/7/31
 **/
public class FileOperator {
    final static String sourcePath = "D:\\004.音乐电影\\03.图片\\图片";

    public static void main(String[] args) {
        File file = new File(sourcePath);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            System.out.println(fileList[i].getName());
        }
    }
}
