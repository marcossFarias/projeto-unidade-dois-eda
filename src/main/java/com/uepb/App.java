package com.uepb;

import com.uepb.service.TreeComparisonService;
import com.uepb.utils.FilePathFinder;

public class App {
    public static void main( String[] args ) {
        TreeComparisonService service = new TreeComparisonService();
        String directoryPath = "/home/user/Documents/projects/projeto-unidade-dois-eda/resources";

        // PARA TODAS DENTRO DE /RESOUCES
        //String[] filePaths = FilePathFinder.getAbsoluteFilePaths(directoryPath); 

        // PARA UMA MASSA DE TESTE SÓ
        String[] filePaths = new String[] {"/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test-array-1M-ordenado-decrescente.txt"}; 

        service.compareTreeRotations(filePaths);
    }
}
