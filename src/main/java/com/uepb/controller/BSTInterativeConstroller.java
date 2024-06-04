package com.uepb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uepb.model.BSTIterative;

public class BSTInterativeConstroller {
    public static int fillTree(BSTIterative tree, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                tree.add(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }
        return 0;
    }
}
