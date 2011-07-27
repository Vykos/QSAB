package com.sigma.qsab.data;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorer extends HashMap<String, Customer> {

    public CustomerStorer(Map<? extends String, ? extends Customer> m) {
        super(m);
    }

    public CustomerStorer() {
        super();
    }

    @Override
    public Customer put(String socialID, Customer customer) {
        if (containsKey(socialID)) return customer; //don't overwrite!
        Customer previousValue = super.put(socialID, customer);
        //Save to disk
        return previousValue;
    }

    public Customer put(Customer customer) {
        return put(customer.getSocialID(), customer);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Customer> customers) {
        super.putAll(customers);
        //Save to disk
    }

    @Override
    public Customer remove(Object key) {
        return remove((String) key);
    }

    public Customer remove(String socialID) {
        Customer previousValue = super.remove(socialID);
        //Save to disk
        return previousValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : keySet()) {
            Customer c = get(key);
            sb.append("Customer: ").append(c.getSocialID()).append('\n');
            sb.append("Name: ").append(c.getFirstname()).append(' ').append(c.getLastname()).append('\n');
            sb.append("Address: ").append(c.getStreet()).append(", ").append(c.getZipCode()).append(' ').append(c.getCity()).append('\n');
            sb.append("Phone numbers: ").append(c.getPhone()).append(", ").append(c.getCellPhone()).append('\n');
            sb.append("Email: ").append(c.getEmail()).append('\n');
        }
        return sb.toString();
    }
    
    public boolean contains(Customer customer) {
        if (containsKey(customer.getSocialID())) {
            return customer.equals(get(customer.getSocialID()));
        }
        return false;
    }
}
