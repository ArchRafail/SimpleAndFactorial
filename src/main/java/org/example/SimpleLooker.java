package org.example;

import java.io.*;

public class SimpleLooker implements Runnable {

    private static String filepath;
    private String filename = "prime.txt";

    public static String getFilepath() {
        return filepath;
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= number/2; i++) {
            if (number%i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        filepath = FileFiller.pathToDir()+File.separator+filename;
        File file = new File(filepath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create file " + filepath);
            }
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FileFiller.getFilepath()));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));) {
            int inputNumber;
            while((inputNumber = bis.read()) != -1) {
                if(isPrimeNumber(inputNumber))
                    bos.write(inputNumber);
            }
        } catch (IOException e) {
            throw new RuntimeException("An issue while filling file with prime numbers.");
        }
        System.out.println("File " + filename + " was filled with prime numbers!");
    }
}
