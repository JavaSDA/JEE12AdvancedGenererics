package com.company.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class BuffersAndChannels {
    public static void main(String[] args) {

        // capacity - the capacity of the buffer is the number of elements it
        // contains. It's never negative and never changes.

        // limit - is the index of the first element that should be read or written. It's n
        // never negative and never greater than the capacity.

        // position - is the index of the next byte or element to be read or written. It's never
        // negative and never greater than the limit.

        // Create a bytebuffer and assign the capacity
        // that you want it to be able to accommodate (in bits).
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // The size of each byte of data that is read or written.
//        byteBuffer.asCharBuffer().put("Hello world");
//
//        char counter;
//        while ((counter = byteBuffer.getChar())  != 0) {
//            System.out.print(counter + "");
//        }
//        System.out.println();


        // Channels
        // FileChannel
        // DatagramChannel - UDP
        // ServerSocketChannel - TCP
        // SocketChannel - TCP

        // Use a random access file to index and retrieve the channel of the file.
//        try {
//            RandomAccessFile file = new RandomAccessFile("inputText.txt", "r");
//            FileChannel fileChannel = file.getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(512); // Create and allocate size to buffer.
//
//            // While there is data to be read, do this.
//            while (fileChannel.read(byteBuffer) > 0) {
//                byteBuffer.flip(); // Prepare the buffer for a write operation by fetching the available data.
//                while (byteBuffer.hasRemaining()) { // while there is still data left in the buffer, do this.
//                    System.out.print((char) byteBuffer.get());
//                }
//                byteBuffer.clear();
//            }
//
//            file.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Using paths
        try {
            Path path = Paths.get("inputPath.txt");
            System.out.println(Files.isExecutable(path) ? "It is executable" : "It isn't");
            Files.createFile(path);
            Files.write(path, "Hello Beautiful world".getBytes(), StandardOpenOption.WRITE);
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
            Files.delete(path);
        } catch (FileAlreadyExistsException e) {
            System.err.println("The file already exists!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
