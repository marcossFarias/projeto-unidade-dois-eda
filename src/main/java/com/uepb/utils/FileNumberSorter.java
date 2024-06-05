package com.uepb.utils;

import java.io.*;
import java.util.*;

public class FileNumberSorter {
    public static void sortAndExportNumbers(String inputFile, String ascendingOutputFile, String descendingOutputFile) {
        try {
            // Lê os números do arquivo de entrada
            List<Integer> numbers = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            reader.close();

            // Ordena os números em ordem crescente e decrescente
            Collections.sort(numbers);
            List<Integer> ascendingNumbers = new ArrayList<>(numbers);
            List<Integer> descendingNumbers = new ArrayList<>(numbers);
            Collections.reverse(descendingNumbers);

            // Exporta os arrays ordenados para os arquivos de saída
            exportNumbersToFile(ascendingNumbers, ascendingOutputFile);
            exportNumbersToFile(descendingNumbers, descendingOutputFile);
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever arquivos: " + e.getMessage());
        }
    }

    private static void exportNumbersToFile(List<Integer> numbers, String outputFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (int number : numbers) {
                writer.write(String.valueOf(number));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFile = "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test-array-3M-desordenado.txt";
        String ascendingOutputFile = "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test-array-3M-ordenado-crescente.txt";
        String descendingOutputFile = "/home/user/Documents/projects/projeto-unidade-dois-eda/resources/test-array-3M-ordenado-decrescente.txt";
        sortAndExportNumbers(inputFile, ascendingOutputFile, descendingOutputFile);
    }
}
