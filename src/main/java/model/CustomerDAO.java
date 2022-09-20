package model;

import com.douzone.model.domain.Customer;
import lombok.Getter;

import java.util.ArrayList;

public class CustomerDAO {
    private static CustomerDAO isnstance = new CustomerDAO();

    private CustomerDAO() {
    }

    public static CustomerDAO getInstance(){
        return isnstance;
    }

    public static ArrayList<Customer> userData = new ArrayList<>();

    static {
        userData.add(new Customer("it1","it1","S"));
        userData.add(new Customer("it2","it2","A"));
        userData.add(new Customer("it3","it3","B"));
        userData.add(new Customer("it4","it4","C"));
        userData.add(new Customer("it5","it5","D"));
    }

    public ArrayList<Customer> findAll() {
        return userData;
    }
}
