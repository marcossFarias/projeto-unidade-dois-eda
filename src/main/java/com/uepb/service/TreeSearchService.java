package com.uepb.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

public class TreeSearchService {
    public static void main(String[] args) {
        Path path = Paths.get("/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test-array-3M-desordenado.txt");
        File file = path.toFile();

        // busca avl
        AVLTree avlTree = new AVLTree();
        int voids = AVLController.fillTree(avlTree, file);
        
        long startTime = System.currentTimeMillis();
        voids = performSearch(avlTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-sem-repetir.txt");
        long endTime = System.currentTimeMillis();
        long uniqueSearchDuration = endTime - startTime;
        System.out.println("Tempo total para busca única: " + uniqueSearchDuration + " milissegundos");

        startTime = System.currentTimeMillis();
        voids = performSearch(avlTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-repetindo.txt");
        endTime = System.currentTimeMillis();
        long repeatedSearchDuration = endTime - startTime;
        System.out.println("Tempo total para busca repetida: " + repeatedSearchDuration + " milissegundos");


        // busca rb
        RedBlackBST redBlackTree = new RedBlackBST();
        voids = RedBlackController.fillTree(redBlackTree, file);

        long startTimeRB = System.currentTimeMillis();
        voids = redBlackTree.performSearch("/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-sem-repetir.txt");
        long endTimeRB = System.currentTimeMillis();
        long uniqueSearchDurationRB = endTimeRB - startTimeRB;
        System.out.println("Tempo total para busca única (RB): " + uniqueSearchDurationRB + " milissegundos");

        startTimeRB = System.currentTimeMillis();
        voids= redBlackTree.performSearch("/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-repetindo.txt");
        endTimeRB = System.currentTimeMillis();
        long repeatedSearchTimeRB = endTimeRB - startTimeRB;
        System.out.println("Tempo total para busca repetida (RB): " + repeatedSearchTimeRB + " milissegundos");


        //busca sp
        SplayTree splayTree = new SplayTree();
        voids = SplayTreeController.fillTree(splayTree, file);

        long startTimeSplayUnique = System.currentTimeMillis();
        voids = performSearch(splayTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-sem-repetir.txt");
        long endTimeSplayUnique = System.currentTimeMillis();
        long uniqueSearchDurationSplay = endTimeSplayUnique - startTimeSplayUnique;
        System.out.println("Tempo total para busca única (Splay): " + uniqueSearchDurationSplay + " milissegundos");

        long startTimeSplayRepeated = System.currentTimeMillis();
        voids = performSearch(splayTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-repetindo.txt");
        long endTimeSplayRepeated = System.currentTimeMillis();
        long repeatedSearchDurationSplay = endTimeSplayRepeated - startTimeSplayRepeated;
        System.out.println("Tempo total para busca repetida (Splay): " + repeatedSearchDurationSplay + " milissegundos");


        // bs
        BSTIterative binarySearchTree = new BSTIterative();
        voids= BSTInterativeConstroller.fillTree(binarySearchTree, file);

        long startTimeBSTUnique = System.currentTimeMillis();
        voids = performSearch(binarySearchTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-sem-repetir.txt");
        long endTimeBSTUnique = System.currentTimeMillis();
        long uniqueSearchDurationBST = endTimeBSTUnique - startTimeBSTUnique;
        System.out.println("Tempo total para busca única (BST): " + uniqueSearchDurationBST + " milissegundos");

        long startTimeBSTRepeated = System.currentTimeMillis();
        voids = performSearch(binarySearchTree, "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/busca/1m-repetindo.txt");
        long endTimeBSTRepeated = System.currentTimeMillis();
        long repeatedSearchDurationBST = endTimeBSTRepeated - startTimeBSTRepeated;
        System.out.println("Tempo total para busca repetida (BST): " + repeatedSearchDurationBST + " milissegundos");
    }

    public static int performSearch(AVLTree avlTree, String filePath) {
        int totalMoves = 0;
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                int key = Integer.parseInt(line.trim());
                if (avlTree.search(key)) {
                    totalMoves++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalMoves;
    }
    public static int performSearch(SplayTree splayTree, String filePath) {
        int totalFound = 0;
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                int key = Integer.parseInt(line.trim());
                if (splayTree.find(key) != null) {
                    totalFound++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalFound;
    }
    public static int performSearch(BSTIterative binarySearchTree, String filePath) {
        int totalFound = 0;
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                int key = Integer.parseInt(line.trim());
                if (binarySearchTree.find(key)) {
                    totalFound++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalFound;
    }
}
