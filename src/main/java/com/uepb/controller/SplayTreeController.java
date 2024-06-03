package com.uepb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uepb.model.SplayTree;

public class SplayTreeController {
    public static int fillTree(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                SplayTree.add(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }

        return SplayTree.rotationCount;
    }
}
