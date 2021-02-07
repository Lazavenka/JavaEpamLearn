package by.roger.epamLearn.moduleFour.books;

import by.roger.epamLearn.moduleFour.customer.Common;

import java.io.*;
import java.util.Scanner;

public class LibraryProcessing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();
        while(true){
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить книгу в библиотеку\n" +
                            "2. Вывод списка книг по ID\n"+
                            "3. Редактировать книгу\n"+
                            "4. Найти книги автора\n" +
                            "5. Найти книги издательства\n" +
                            "6. Найти книги выпущенные после заданного года\n" +
                            "7. Сохранение библиотеки в файл\n"+
                            "8. Загрузка библиотеки из файла\n"+
                            "-->>>>>> ");
            int choice = in.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 8) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1 -> library.addBook(Book.getBook(in));
                case 2 -> library.printBooks();
                case 3 -> library.editBook(in);
                case 4 -> {
                    System.out.println("Введите имя автора:");
                    String author = Common.readNotEmptyString(in);
                    library.printByAuthor(author);
                }
                case 5 -> {
                    System.out.println("Введите издательство:");
                    String publisher = Common.readNotEmptyString(in);
                    library.printByPublisher(publisher);
                }
                case 6 -> {
                    System.out.println("Введите год:");
                    library.printAfterYear(Integer.parseInt(Common.readNotEmptyString(in)));
                }
                case 7 -> {
                    Serializator serializator = new Serializator();
                    serializator.serialization(library);
                }
                case 8 -> {
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
}
