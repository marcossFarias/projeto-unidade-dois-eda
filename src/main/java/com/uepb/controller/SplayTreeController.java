package com.uepb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uepb.model.SplayTree;

public class SplayTreeController {
    public static int fillTree(SplayTree tree, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                double value = scanner.nextInt();
                tree.insert(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }

        return tree.rotationCount;
    }
}
