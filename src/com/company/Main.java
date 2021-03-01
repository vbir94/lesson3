package com.company;

import com.company.chess.ChessMovement;
import com.company.chess.impl.QueenMovement;

import java.io.BufferedReader;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final static String SUCCESS_MESSAGE = "Inputfile: %s - Success";
    private final static String FAIL_MESSAGE = "Inputfile: %s - Fail: expectedResult=[%d,%s], actualResult=[%s,%s]";
    private final static String ERROR_MESSAGE = "Inputfile: %s - Error";

    public static void main(String[] args) {

//        File selectedDirectory = new File("C:\\Users\\Valery\\Downloads\\0.BITS-1801-662357\\0.BITS\\1.Bitboard - Король");
//        File selectedDirectory = new File("C:\\Users\\Valery\\Downloads\\0.BITS-1801-662357\\0.BITS\\2.Bitboard - Конь");
//        File selectedDirectory = new File("C:\\Users\\Valery\\Downloads\\0.BITS-1801-662357\\0.BITS\\3.Bitboard - Ладья");
//        File selectedDirectory = new File("C:\\Users\\Valery\\Downloads\\0.BITS-1801-662357\\0.BITS\\4.Bitboard - Слон");
        File selectedDirectory = new File("C:\\Users\\Valery\\Downloads\\0.BITS-1801-662357\\0.BITS\\5.Bitboard - Ферзь");
        List<File> files = getInFiles(selectedDirectory);
        String s = files.stream().map(file -> testOut(file)).collect(Collectors.joining("\n"));
        System.out.println(s);
    }

    private static String testOut(File inFile) {
        Path inPath = Paths.get(inFile.getAbsolutePath());
        Path outPath = Paths.get(inFile.getAbsolutePath().replace(".in", ".out"));
        String filename = inFile.getName();
        try (BufferedReader inReader = Files.newBufferedReader(inPath);
             BufferedReader outReader = Files.newBufferedReader(outPath)) {
            String inString = inReader.readLine();
            String outString1 = outReader.readLine();
            String outString2 = outReader.readLine();
            return test(inString, outString1, outString2, filename);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return String.format(ERROR_MESSAGE, filename);
    }

    private static String test(String in, String out1, String out2, String filename) {
        ChessMovement movement = new QueenMovement();
        BigInteger expectedResult = movement.solve(Integer.valueOf(in));
        int expectedBitCount = expectedResult.bitCount();

        int actualBitCount = Integer.valueOf(out1);
        BigInteger actualResult = new BigInteger(out2);

        if (expectedResult.equals(actualResult) && expectedBitCount == actualBitCount) {
            return String.format(SUCCESS_MESSAGE, filename);
        } else {
            return String.format(FAIL_MESSAGE, filename, expectedBitCount, expectedResult.toString(), out1, out2);
        }
    }

    private static List<File> getInFiles(File folder) {
        List<File> ins = new ArrayList<>();
        for (final File file : folder.listFiles()) {
            if (file.getName().contains("in"))
                ins.add(file);
        }
        return ins;
    }


}
