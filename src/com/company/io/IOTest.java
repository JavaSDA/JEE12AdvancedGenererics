package com.company.io;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {
        String inputFile = "inputText.txt";
//        try {
////            byteStream(inputFile, "outputText.txt");
//            System.out.println("Operation successful");
//        } catch (FileNotFoundException e) {
//            System.err.println(inputFile + " was not found");
//        }
//        characterStream(inputFile, "outputText.txt");
//        bufferedStreams(inputFile, "outputBufferText.txt");

        System.out.println("Operation Successful");
    }

    // Data streaming
    public static void byteStream(String inputFilePath, String outputFilePath) throws FileNotFoundException {
        // File input and output streams throw a FileNotFoundException
        FileInputStream in  = new FileInputStream(inputFilePath);
        FileOutputStream out = new FileOutputStream(outputFilePath);
        // counter for each byte parsed from the input file.
        int byteCounter;

        // While there are unread bytes then keep writing to the
        // output file.
        // `surround with` shortcut: Ctrl + Alt + T
        try {
            while((byteCounter = in.read()) != -1) {

                out.write(byteCounter);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // Character Stream
    public static void characterStream(String inputFilePath, String outputFilePath) {
        try {
            FileReader in = new FileReader(inputFilePath);
            FileWriter out =  new FileWriter(outputFilePath);

            int character;
            while ((character = in.read()) != -1) {
                out.write((char) character);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void bufferedStreams(String inputFilePath, String outputFilePath) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFilePath));


            String line;

            while ((line = in.readLine()) != null) {
                out.write(line);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}
