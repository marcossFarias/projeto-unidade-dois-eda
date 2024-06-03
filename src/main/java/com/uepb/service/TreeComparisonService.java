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

            System.out.println("File: " + fileName);

            AVLTree avlTree = new AVLTree();
            long startTimeAVL = System.nanoTime();
            int movesAVL = AVLController.fillTree(avlTree, file);
            long elapsedTimeAVL = System.nanoTime() - startTimeAVL;
            int heightAVL = avlTree.getTreeHeight();
            System.out.println("AVL Tree - Rotations: " + movesAVL + ", Height: " + heightAVL + ", Elapsed Time: " + elapsedTimeAVL / 1000000 + " ms");

            RedBlackBST rbTree = new RedBlackBST();
            long startTimeRB = System.nanoTime();
            int movesRB = RedBlackController.fillTree(rbTree, file);
            long elapsedTimeRB = System.nanoTime() - startTimeRB;
            int heightRBT = rbTree.getHeight();
            System.out.println("Red-Black Tree - Rotations: " + movesRB + ", Height: " + heightRBT + ", Elapsed Time: " + elapsedTimeRB / 1000000 + " ms");

            long startTimeSP = System.nanoTime();
            int movesSP = SplayTreeController.fillTree(file);
            long elapsedTimeSP = System.nanoTime() - startTimeSP;
            int heightSP = SplayTreeController.getSPHeight();
            System.out.println("Splay Tree - Rotations: " + movesSP +  ", Height: " + heightSP + ", Elapsed Time: " + elapsedTimeSP / 1000000 + " ms");

            System.out.println();
        }
    }
}
