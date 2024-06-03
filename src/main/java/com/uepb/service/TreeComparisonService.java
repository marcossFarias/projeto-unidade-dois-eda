package com.uepb.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.uepb.controller.AVLController;
import com.uepb.controller.RedBlackController;
import com.uepb.controller.SplayTreeController;
import com.uepb.model.AVLTree;
import com.uepb.model.RedBlackBST;

public class TreeComparisonService {
    public void compareTreeRotations(String[] fileNames) {
        for (String fileName : fileNames) {
            Path path = Paths.get(fileName);
            File file = path.toFile();

            AVLTree avlTree = new AVLTree();
            int movesAVL = AVLController.fillTree(avlTree, file);
            System.out.println("AVL Tree - File: " + fileName + ", Rotations: " + movesAVL);

            RedBlackBST rbTree = new RedBlackBST();
            int movesRB = RedBlackController.fillTree(rbTree, file);
            System.out.println("Red-Black Tree - File: " + fileName + ", Rotations: " + movesRB);

            int movesSP = SplayTreeController.fillTree(file);
            System.out.println("Splay Tree - File: " + fileName + ", Rotations: " + movesSP);

            System.out.println();
        }
    }
}
