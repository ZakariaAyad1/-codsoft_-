package com.sms;


import java.io.*;
import java.util.List;

public class FileManager {

    public static void saveStudentsToFile(List<Student> students, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }
    }

    public static List<Student> loadStudentsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) ois.readObject();
        }
    }
}
