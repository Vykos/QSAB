package com.sigma.qsab.data;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorerImpl implements CustomerStorer {
    
    private Map<String, Customer> customers ;

    public CustomerStorerImpl() {
        customers = new HashMap<String, Customer>();
    }
    
    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) return false;
        if (customers.containsKey(customer.getSocialID())) return false; //don't overwrite!
        customers.put(customer.getSocialID(), customer);        
        return true;
    }

    @Override
    public boolean containsCustomer(Customer customer) {
        if (customer == null) return false;
        if (customers.containsKey(customer.getSocialID())) {
            return customer.equals(customers.get(customer.getSocialID()));
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        if (customer == null) return false;
        if (!containsCustomer(customer)) return false;
        customers.remove(customer.getSocialID());
        return true;
    }

    @Override
    public Customer findCustomer(String socialID) {
        if (socialID == null) return null;        
        return customers.get(socialID);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if (customer == null) return false;
        Customer oldCustomer = customers.get(customer.getSocialID());
        if (!deleteCustomer(oldCustomer)) return false;
        if (addCustomer(customer)) return true;
        addCustomer(oldCustomer);
        return false;
    }   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : customers.keySet()) {
            Customer c = customers.get(key);
            sb.append("Customer: ").append(c.getSocialID()).append('\n');
            sb.append("Name: ").append(c.getFirstName()).append(' ').append(c.getLastName()).append('\n');
            sb.append("Address: ").append(c.getStreet()).append(", ").append(c.getZipCode()).append(' ').append(c.getCity()).append('\n');
            sb.append("Phone numbers: ").append(c.getPhone()).append(", ").append(c.getCellPhone()).append('\n');
            sb.append("Email: ").append(c.getEmail()).append('\n');
        }
        return sb.toString();
    }   
}
