package by.roger.epamLearn.moduleFour.books;

import by.roger.epamLearn.moduleFour.customer.Common;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Library implements Serializable, Comparator<Book> {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBookByID(int id){
        books.remove(findBookByID(id));
    }
    private int findBookByID(int id){
        sortById();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public void sortById(){
        books.sort(this);
    }
    public void printByAuthor(String author){
        boolean flag = false;
        for (Book book : books) {
            if (findEntry(author, book.getAuthors())) {
                System.out.println(book);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Книг с автором \""+author+"\" не найдено.");
        }
    }
    public  void printByPublisher(String publisher){
        boolean flag = false;
        for (Book book : books) {
            if (findEntry(publisher, book.getPublisher())) {
                System.out.println(book);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Книг издательства \""+publisher+"\" не найдено.");
        }
    }
    public void printAfterYear(int year){
        boolean flag = false;
        for (Book book : books) {
            if (book.getYear()>year) {
                System.out.println(book);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Книг изданных после "+year+"-го года не найдено.");
        }
    }
    private boolean findEntry(String name, String... array){
        for (String s:array) {
            if (s.toLowerCase().contains(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public void editBook(Scanner in){
        System.out.println("Введите номер ID книги:");
        int id = Integer.parseInt(Common.readNotEmptyString(in));
        int arrayId = findBookByID(id);
        if (arrayId!=-1){
            Book bookToEdit = this.books.get(arrayId);
            System.out.println("Выбрана книга: "+bookToEdit);
            while(true) {
                System.out.print(
                        "Что хотите откорректировать:\n" +
                                "0. Завершить\n" +
                                "1. Название\n" +
                                "2. Авторов\n" +
                                "3. Издательство\n" +
                                "4. Год издания\n" +
                                "5. Город издания\n" +
                                "6. Количество страниц\n" +
                                "7. Переплет\n" +
                                "-->>>>>> ");
                int choice = in.nextInt();
                if (choice == 0)
                    break;
                if (choice < 1 || choice > 7) {
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
                    continue;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println("Введите название:");
                        bookToEdit.setTitle(Common.readNotEmptyString(in));
                    }
                    case 2 -> {
                        System.out.println("Введите авторов (формат \"Фамилия имя отчество\\Фамилия и.о.\"):");
                        bookToEdit.setAuthors(Common.readNotEmptyString(in));
                    }
                    case 3 -> {
                        System.out.println("Введите издательство:");
                        bookToEdit.setPublisher(Common.readNotEmptyString(in));
                    }
                    case 4 -> {
                        System.out.println("Введите год издательства:");
                        bookToEdit.setYear(Integer.parseInt(Common.readNotEmptyString(in)));
                    }
                    case 5 -> {
                        System.out.println("Введите город где издана книга:");
                        bookToEdit.setCityPrint(Common.readNotEmptyString(in));
                    }
                    case 6 -> {
                        System.out.println("Введите количество страниц:");
                        bookToEdit.setPages(Integer.parseInt(Common.readNotEmptyString(in)));
                    }
                    case 7 -> {
                        System.out.println("Тип переплета (\"1\" для мягкого переплета, \"2\" для жесткого переплета):");
                        String bind = Common.readNotEmptyString(in);
                        while (!bind.equals("1") && !bind.equals("2")) {
                            System.out.println("Введите \"1\" или \"2\"!");
                            bind = Common.readNotEmptyString(in);
                        }
                        bookToEdit.setBinding(bind.equals("2"));
                    }
                }
            }
            this.books.set(arrayId, bookToEdit);
        }
        else System.out.println("Такого ID не существует.");
    }
    public void printBooks(){
        for (Book book: books) {
            System.out.println(book);
        }
    }
    public int getLastId(){
        return books.get(books.size()-1).getId();
    }
    @Override
    public int compare(Book o1, Book o2) {
        Integer idOne = o1.getId();
        Integer idTwo = o2.getId();
        return idOne.compareTo(idTwo);
    }
}
