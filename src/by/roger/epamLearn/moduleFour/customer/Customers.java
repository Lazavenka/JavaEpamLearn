package by.roger.epamLearn.moduleFour.customer;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Customers implements Comparator<Customer>, Serializable {
    private ArrayList<Customer> customers;
    private int size;

    public Customers() {
        customers = new ArrayList<>();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Customers(ArrayList<Customer> customers) {
        this.customers = customers;
        size = customers.size();
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
        size++;
    }

    public void removeCustomerByID(int id){
        customers.remove(id);
        size--;
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getId()-o2.getId();
    }

    @Override
    public Comparator<Customer> reversed() {
        return null;
    }

    public int compareNames(Customer o1, Customer o2) {
        int firstNameComp = o1.getFirstName().compareTo(o2.getFirstName());
        if (firstNameComp!=0){
            return firstNameComp;
        }else{
            int lastNameComp = o1.getLastName().compareTo(o2.getLastName());
            if (lastNameComp!=0){
                return lastNameComp;
            }else{
                return o1.getPatronymic().compareTo(o2.getPatronymic());
            }
        }
    }
    public int compareByCards(Customer o1, Customer o2){
        return o1.getCreditCard().compareTo(o2.getCreditCard());
    }
    public void sortID(){
        customers.sort(this);
    }
    public void sortByNames(){
        customers.sort(this::compareNames);
    }
    public void sortByCards(){
        customers.sort(this::compareByCards);
    }
    public void printByCardRange(String start, String end) {
        for (Customer c : customers) {
            if (c.getCreditCard().compareTo(start) >= 0 && c.getCreditCard().compareTo(end) <= 0) {
                System.out.println(c);
            }
        }
    }
    public Customers getCustomerbyCardRangeArray(String start, String end){
        ArrayList<Customer> ans = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getCreditCard().compareTo(start) >= 0 && c.getCreditCard().compareTo(end) <= 0) {
                ans.add(c);
            }
        }
        return new Customers(ans);
    }
    public void printCustomers(){
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
