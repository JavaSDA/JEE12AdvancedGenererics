package com.company.nio;

import java.io.*;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String type;
    private final static String FILENAME = "outputSerialize.txt";

    public Movie(int id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
//        writeObject();
        readObject();
    }

    // Serialization
    public static void writeObject() {
        try {
            Movie movieToSerialize = new Movie(1, "Half Of A Yellow Sun", "PART 2");
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            // the actual serialization
            out.writeObject(movieToSerialize);
            out.flush();
            out.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        } catch (IOException e) {
            System.err.println("Error Message: " + e.getMessage());
        }
    }

    // Deserialization
    public static void readObject() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            Movie movieToDeserialize = (Movie) in.readObject(); // the actual deserialization

            in.close();
            fileInputStream.close();
            System.out.println("Movie ID: " + movieToDeserialize.getId());
            System.out.println("Movie Name: " + movieToDeserialize.getTitle());
            System.out.println("Movie Type: " + movieToDeserialize.getType());

        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error Message: " + e.getMessage());
        }
    }



}
