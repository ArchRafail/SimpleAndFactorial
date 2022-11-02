package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Thread fillerThread = new Thread(new FileFiller());
        Thread lookerThread = new Thread(new SimpleLooker());
        Thread factorialThread = new Thread(new FactorialMaker());
        fillerThread.start();
        try {
            fillerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(fillerThread.getName() + " can't be forced!");
        }
        lookerThread.start();
        factorialThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException("Main thread is not able to sleep.");
        }
        showResults();
    }

    private static void showResults() {
        System.out.println("\nMain file:");
        fileExtractorWithBuffer(FileFiller.getFilepath());
        System.out.println("\nFile with prime numbers:");
        fileExtractorWithBuffer(SimpleLooker.getFilepath());
        System.out.println("\nFile with factorial numbers:");
        fileExtractorWithData(FactorialMaker.getFilepath());
        System.out.println();
    }

    private static void fileExtractorWithBuffer(String filepath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath))) {
            int info;
            while((info = bis.read()) != -1) {
                System.out.print(info + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file " + filepath + " to read");
        }
    }

    private static void fileExtractorWithData(String filepath) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {
            long info;
            while(dis.available() > 0) {
                info = dis.readLong();
                System.out.print(info + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file " + filepath + " to read");
        }
    }

}