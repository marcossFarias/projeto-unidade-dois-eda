package com.uepb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uepb.model.AVLTree;

public class AVLController {
    public static int fillTree(AVLTree tree, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                tree.insert(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }

        return tree.rotationCount;
    }
}
