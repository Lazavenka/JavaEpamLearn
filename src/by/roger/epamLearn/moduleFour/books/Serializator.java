package by.roger.epamLearn.moduleFour.books;

import by.roger.epamLearn.moduleFour.customer.Customers;

import java.io.*;
import java.util.Objects;

public class Serializator implements Serializable {


    public boolean serialization (Library library){
        boolean flag = false;
        File file = new File("books.txt");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null){
                oos = new ObjectOutputStream(fos);
                oos.writeObject(library);
                flag = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    public Library deserialization() throws InvalidClassException {
        File file = new File("books.txt");
        ObjectInputStream ois = null;
        Library library = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null){
                ois = new ObjectInputStream(fis);
                library = (Library) Objects.requireNonNull(ois).readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }
}
