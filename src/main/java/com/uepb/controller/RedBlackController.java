package com.uepb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uepb.model.RedBlackBST;

public class RedBlackController {
    public static int fillTree(RedBlackBST tree, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                RedBlackBST.Node node = tree.new Node(value);
                tree.insert(node);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return -1;
        }

        return tree.rotationCount;
    }
}
