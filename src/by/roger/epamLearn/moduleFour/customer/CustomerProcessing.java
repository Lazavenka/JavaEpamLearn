package by.roger.epamLearn.moduleFour.customer;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
/*
Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class CustomerProcessing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Customers customers = new Customers();
        while(true){
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. выйти\n" +
                            "1. добавить покупателя\n" +
                            "2. вывод списка покупателей по ID\n"+
                            "3. вывод покупателей в алфавитном порядке\n" +
                            "4. вывод покупателей с кредитной картой в интервале\n" +
                            "5. сохранение покупателей в файл\n"+
                            "6. загрузка покупателей из файла\n"+
                            "-->>>>>> ");
            int choice = in.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 6) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice){
                case 1:
                    customers.addCustomer(Customer.getCustomer(in));
                    break;
                case 2:
                    customers.sortID();
                    customers.printCustomers();
                    break;
                case 3:
                    customers.sortByNames();
                    customers.printCustomers();
                    break;
                case 4:
                    System.out.print("Input card range...\nStart:");
                    String start = Common.readNotEmptyString(in);
                    System.out.print("End:");
                    String end = Common.readNotEmptyString(in);
                    customers.printByCardRange(start, end);
                    break;
                case 5:
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("customers.txt");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(customers);
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream("customers.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ObjectInputStream objectInputStream;
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                        customers = (Customers) Objects.requireNonNull(objectInputStream).readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Customer.setID(customers.getSize());
            }
        }
    }
}
