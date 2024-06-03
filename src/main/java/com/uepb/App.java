package com.uepb;

import com.uepb.service.TreeComparisonService;

public class App {
    public static void main( String[] args ) {
        TreeComparisonService service = new TreeComparisonService();
        String[] fileNames = {
                                "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test",
                                "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test2",
                            };
        service.compareTreeRotations(fileNames);
    }
}
