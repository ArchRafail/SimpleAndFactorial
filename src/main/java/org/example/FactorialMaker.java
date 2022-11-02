package org.example;

import java.io.*;

public class FactorialMaker implements Runnable {
    private static String filepath;
    private String filename = "factorial.txt";

    public static String getFilepath() {
        return filepath;
    }

    private long factorial(long number) {
        if (number == 0)
            return 1;
        else
            return (number * factorial(number - 1));
    }

    @Override
    public void run() {
        filepath = FileFiller.pathToDir()+ File.separator+filename;
        File file = new File(filepath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create file " + filepath);
            }
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FileFiller.getFilepath()));
             DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            int inputNumber;
            while((inputNumber = bis.read()) != -1) {
                    dos.writeLong(factorial(inputNumber));
            }
        } catch (IOException e) {
            throw new RuntimeException("An issue while filling file with factorial numbers.");
        }
        System.out.println("File " + filename + " was filled with factorials!");
    }
}
