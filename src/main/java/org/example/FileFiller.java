package org.example;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FileFiller implements Runnable {
    private static String filepath;

    public static String getFilepath() {
        return filepath;
    }

    /**
     When method ask you to enter the path to file, enter YourPath\SimpleAndFactorial\src\main\resources\example.txt.
     For example D:\Projects\Java\SimpleAndFactorial\src\main\resources\example.txt.
     */
    private String pathToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the full path to file where we will put the numbers: ");
        String prePath = scanner.nextLine();
        try {
            Paths.get(prePath);
        } catch (InvalidPathException | NullPointerException ex) {
            throw new RuntimeException("Can't create the file. Incorrect path to file.");
        }
        return prePath.replace("\\", "\\\\");
    }

    private void dirCreate() {
        String dirPath = pathToDir();
        File dir = new File(dirPath);
        if (!dir.exists())
            dir.mkdirs();
    }

    public static String pathToDir() {
        return filepath.substring(0, (filepath.lastIndexOf("\\")-1));
    }

    /**
     When method ask you to enter the quantity of numbers, input 15.
     */
    private int numbersQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the quantity of numbers: ");
        int number;
        try {
            number = scanner.nextInt();
            if (number <= 0) throw new NegativeArraySizeException();
        }
        catch(InputMismatchException ex) {
            throw new RuntimeException("The quantity of numbers has to be in integer format!");
        } catch (NegativeArraySizeException ex) {
        throw new RuntimeException("The quantity of numbers has to be more then 0!");
        }
        return number;
    }

    @Override
    public void run() {
        filepath = pathToFile();
        File file = new File(filepath);
        if (file.isDirectory())
            throw new RuntimeException("File can not be created. Incorrect file name/extension.");
        if (!file.exists()) {
            dirCreate();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("An issue with creating file " + filepath);
            }
        }
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            int quantity = numbersQuantity();
            for (int i = 0; i < quantity; i++) {
                bos.write(ThreadLocalRandom.current().nextInt(1, 20 + 1));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write random numbers to file.");
        }
        System.out.println("\nFile was already filled!");
    }
}
