package by.roger.epamLearn.moduleFour.customer;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Customer implements Serializable {
    private static int ID;
    final private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String creditCard;
    private String bankAccount;
    private String adress;

    public Customer(String firstName, String lastName, String patronymic, String creditCard, String bankAccount, String adress) {
        ID++;
        id = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
        this.adress = adress;
    }

    public static int getID() {
        return ID;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getAdress() {
        return adress;
    }
    public static void setID(int id){
        ID = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(patronymic, customer.patronymic) &&
                Objects.equals(creditCard, customer.creditCard) &&
                Objects.equals(bankAccount, customer.bankAccount) &&
                Objects.equals(adress, customer.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic, creditCard, bankAccount, adress);
    }

    @Override
    public String toString() {
        return "Customer #" + id + ": " + firstName + " " + lastName + " " + patronymic +
                "\nAdress: " + adress + "; Bank account: " + bankAccount + "; Credit Card: " + creditCard;
    }

    public static Customer getCustomer(Scanner in){
        Customer customer = new Customer("", "", "", "", "", "");
        System.out.println("First name: ");
        customer.setFirstName(Common.readNotEmptyString(in));
        System.out.println("Last name: ");
        customer.setLastName(Common.readNotEmptyString(in));
        System.out.println("Patronymic: ");
        customer.setPatronymic(Common.readNotEmptyString(in));
        System.out.println("Address: ");
        customer.setAdress(Common.readNotEmptyString(in));
        System.out.println("Credit сard number: ");
        customer.setCreditCard(Common.readNotEmptyString(in));
        System.out.println("Bank account number: ");
        customer.setBankAccount(Common.readNotEmptyString(in));
        return customer;
    }
}
