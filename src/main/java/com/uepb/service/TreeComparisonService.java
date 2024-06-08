package com.uepb.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.uepb.controller.AVLController;
import com.uepb.controller.BSTInterativeConstroller;
import com.uepb.controller.RedBlackController;
import com.uepb.controller.SplayTreeController;
import com.uepb.model.AVLTree;
import com.uepb.model.BSTIterative;
import com.uepb.model.RedBlackBST;
import com.uepb.model.SplayTree;

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
            int heightAVL = avlTree.getHeight();
            System.out.println("AVL Tree - Rotations: " + movesAVL + ", Height: " + heightAVL + ", Elapsed Time: " + elapsedTimeAVL / 1000000 + " ms");
            
            BSTIterative bstIterative = new BSTIterative();
            long startTimeBST = System.nanoTime();
            int movesBST = BSTInterativeConstroller.fillTree(bstIterative, file);
            long elapsedTimeBST = System.nanoTime() - startTimeBST;
            int heightBST = bstIterative.getHeight();
            System.out.println("BS Tree - Rotations: " + movesBST + ", Height: " + heightBST + ", Elapsed Time: " + elapsedTimeBST / 1000000 + " ms");
            
            RedBlackBST rbTree = new RedBlackBST();
            long startTimeRB = System.nanoTime();
            int movesRB = RedBlackController.fillTree(rbTree, file);
            long elapsedTimeRB = System.nanoTime() - startTimeRB;
            int heightRBT = rbTree.getHeight();
            System.out.println("Red-Black Tree - Rotations: " + movesRB + ", Height: " + heightRBT + ", Elapsed Time: " + elapsedTimeRB / 1000000 + " ms");

            SplayTree splayTree = new SplayTree();
            long startTimeSP = System.nanoTime();
            int movesSP = SplayTreeController.fillTree(splayTree, file);
            long elapsedTimeSP = System.nanoTime() - startTimeSP;
            int heightSP = splayTree.treeHeight(splayTree.getRoot());
            System.out.println("Splay Tree - Rotations: " + movesSP +  ", Height: " + heightSP + ", Elapsed Time: " + elapsedTimeSP / 1000000 + " ms");
            
            System.out.println();
        }
    }
}
