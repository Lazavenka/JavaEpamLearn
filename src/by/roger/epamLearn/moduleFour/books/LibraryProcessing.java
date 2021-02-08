package by.roger.epamLearn.moduleFour.books;

import by.roger.epamLearn.moduleFour.customer.Common;

import java.io.*;
import java.util.Scanner;

public class LibraryProcessing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();
        System.out.println(library.toString());
        while(true){
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Обзор библиотеки\n" +
                            "2. Поиск по категориям\n"+
                            "-->>>>>> ");
            int choice = Common.inputNumber(in, 2);
            if (choice == 0)
                break;
            switch (choice) {
                case 1 -> editLibrary(in, library);
                case 2 -> searchByCategory(in, library);
            }
        }
    }
    private static void editLibrary(Scanner in, Library library){
        while(true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Назад\n" +
                            "1. Вывод списка книг по ID\n" +
                            "2. Добавить книгу в библиотеку\n" +
                            "3. Удалить книгу по ID\n" +
                            "4. Редактировать книгу по ID\n" +
                            "5. Сохранение библиотеки в файл\n" +
                            "6. Загрузка библиотеки из файла\n" +
                            "-->>>>>> ");
            int choice = Common.inputNumber(in, 6);
            if (choice == 0)
                break;
            switch (choice) {
                case 1 -> library.printBooks();
                case 2 -> library.addBook(Book.getBook(in));
                case 3 -> library.removeBookByID(Common.inputNumber("Введите ID книги:",
                                                    in,library.getLastId()));
                case 4 -> library.editBook(in);
                case 5 -> {
                    Serializator serializator = new Serializator();
                    serializator.serialization(library);
                }
                case 6 -> {
                    Serializator deserializator = new Serializator();
                    try {
                        library = deserializator.deserialization();
                    } catch (InvalidClassException e) {
                        e.printStackTrace();
                    }
                    Book.setCurrentID(library.getLastId());
                }
            }
        }
    }
    private static void searchByCategory(Scanner in, Library library){
        while(true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Назад\n" +
                            "1. Найти книги автора\n" +
                            "2. Найти книги издательства\n" +
                            "3. Найти книги выпущенные после заданного года\n" +
                            "-->>>>>> ");
            int choice = Common.inputNumber(in, 3);
            if (choice == 0)
                break;
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите имя автора:");
                    String author = Common.readNotEmptyString(in);
                    library.printByAuthor(author);
                }
                case 2 -> {
                    System.out.println("Введите издательство:");
                    String publisher = Common.readNotEmptyString(in);
                    library.printByPublisher(publisher);
                }
                case 3 -> {
                    System.out.println("Введите год:");
                    library.printAfterYear(Integer.parseInt(Common.readNotEmptyString(in)));
                }
            }
        }
    }

}
