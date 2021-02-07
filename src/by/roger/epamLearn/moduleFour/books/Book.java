package by.roger.epamLearn.moduleFour.books;

import by.roger.epamLearn.moduleFour.customer.Common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book implements Serializable {
    private static int currentID;
    private int id;
    private String title;
    private String[] authors;
    private String publisher;
    private int year;
    private String cityPrint;
    private int pages;
    private boolean binding; //false = soft; true = hard

    public Book(String title, String authors, String publisher, int year, String cityPrint, int pages, boolean binding) {
        currentID++;
        this.id = currentID;
        this.title = title;
        this.authors = splitAuthors(authors);
        this.publisher = publisher;
        this.year = year;
        this.cityPrint = cityPrint;
        this.pages = pages;
        this.binding = binding;
    }

    public String getCityPrint() {
        return cityPrint;
    }

    public void setCityPrint(String cityPrint) {
        this.cityPrint = cityPrint;
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

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = splitAuthors(authors);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isBinding() {
        return binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }
    public static void setCurrentID(int id){
        currentID = id;
    }
    private String[] splitAuthors(String authors){
        ArrayList<String> ans = new ArrayList<>();
        Pattern ptrn = Pattern.compile("^\\s*([\\wА-Яа-я]+)" +
                "(\\s+([\\wА-Яа-я]?)\\S*)?(\\s+([\\wА-Яа-я]?)[\\wА-Яа-я]*.*)?");
        String[] ss = authors.split(",");
        for (String s: ss) {
            if ((s = s.trim()).isEmpty()) continue;
            Matcher m = ptrn.matcher(s);
            if (m.find()) {
                ans.add(m.group(1) + " "
                        + (m.group(3) == null? "" : (m.group(3).toUpperCase() + "."))
                        + (m.group(5) == null? "" : (m.group(5).toUpperCase() + ".")));
            }
        }
        return ans.toArray(new String[0]);
    }
    public static Book getBook(Scanner in){
        Book book = new Book("", "", "",0,"",0,false);
        System.out.println("Название книги: ");
        book.setTitle(Common.readNotEmptyString(in));
        System.out.println("Авторы: ");
        book.setAuthors(Common.readNotEmptyString(in));
        System.out.println("Издательство: ");
        book.setPublisher(Common.readNotEmptyString(in));
        System.out.println("Год издания: ");
        book.setYear(Integer.parseInt(Common.readNotEmptyString(in)));
        System.out.println("Город издания");
        book.setCityPrint(Common.readNotEmptyString(in));
        System.out.println("Количество страниц: ");
        book.setPages(Integer.parseInt(Common.readNotEmptyString(in)));
        System.out.println("Переплет (\"1\" для мягкого переплета, \"2\" для жесткого переплета):");
        String bind = Common.readNotEmptyString(in);
        while(!bind.equals("1")&&!bind.equals("2")){
            System.out.println("Введите \"1\" или \"2\"!");
            bind = Common.readNotEmptyString(in);
        }
        book.setBinding(bind.equals("2"));
        return book;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && year == book.year && pages == book.pages && binding == book.binding &&
                title.equals(book.title) && Arrays.equals(authors, book.authors) &&
                Objects.equals(publisher, book.publisher) && Objects.equals(cityPrint, book.cityPrint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, publisher, year, cityPrint, pages, binding);
    }
    private String firstAuthorProcessISO(String author){
        String[] name = author.split(" ");
        return name[0]+", "+name[1];
    }
    private String allAuthorProcessISO(String... author){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < author.length; i++) {
            String[] names = author[i].split(" ");
            sb.append(names[1]).append(" ").append(names[0]);
            if (i != author.length-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return id+".\t"+firstAuthorProcessISO(authors[0])+" "+title+" [Текст] / "+
                allAuthorProcessISO(authors)+". - "+cityPrint+": "+publisher+", "+year+
                ". - "+pages+" с.";
    }
}
