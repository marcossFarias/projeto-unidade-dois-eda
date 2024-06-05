package com.uepb;

import com.uepb.service.TreeComparisonService;
import com.uepb.utils.FilePathFinder;

public class App {
    public static void main( String[] args ) {
        TreeComparisonService service = new TreeComparisonService();
        String directoryPath = "/home/user/Documents/projects/projeto-unidade-dois-eda/resources";
        String[] filePaths = FilePathFinder.getAbsoluteFilePaths(directoryPath);
        service.compareTreeRotations(filePaths);
    }
}
