package com.uepb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilePathFinder {
    public static String[] getAbsoluteFilePaths(String directoryPath) {
        File directory = new File(directoryPath);
        List<String> filePaths = new ArrayList<>();

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        filePaths.add(file.getAbsolutePath());
                    }
                }
            }
        }

        return filePaths.toArray(new String[0]);
    }
}
