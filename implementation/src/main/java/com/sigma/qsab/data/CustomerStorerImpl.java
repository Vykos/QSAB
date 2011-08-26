package com.sigma.qsab.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorerImpl implements CustomerStorer, Serializable {

    private Map<String, Customer> customers;
    private String customersDataPath = System.getProperty("user.home") + File.separator + ".qsab";
    private String customersDataFile = customersDataPath + "/qsab.db";

    public CustomerStorerImpl() {
        //System.out.println("=====================\nDATAPATH: " + customersDataPath);
        if (customersDataExists()) {
            customers = loadCustomersData();
        } else {
            customers = createCustomersData();
        }
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        if (customers.containsKey(customer.getSocialID())) {
            return false; //don't overwrite!
        }
        customers.put(customer.getSocialID(), customer);
        writeCustomersData(customers);
        return true;
    }

    @Override
    public boolean containsCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        if (customers.containsKey(customer.getSocialID())) {
            return customer.equals(customers.get(customer.getSocialID()));
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        if (!containsCustomer(customer)) {
            return false;
        }
        customers.remove(customer.getSocialID());
        writeCustomersData(customers);
        return true;
    }

    @Override
    public Customer findCustomer(String socialID) {
        if (socialID == null) {
            return null;
        }
        return customers.get(socialID);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        Customer oldCustomer = customers.get(customer.getSocialID());
        if (!deleteCustomer(oldCustomer)) {
            return false;
        }
        if (addCustomer(customer)) {
            writeCustomersData(customers);
            return true;
        }
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

    private boolean customersDataExists() {
        File customersData = new File(customersDataFile);
        return customersData.exists();
    }

    @SuppressWarnings("CallToThreadDumpStack")
    private Map<String, Customer> loadCustomersData() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(customersDataFile));
            Map<String, Customer> customersData = (Map<String, Customer>) in.readObject();
            in.close();
            return customersData;
        } catch (Exception ex) {
            ex.printStackTrace();
            return createCustomersData();
        }
    }
    
    private Map<String, Customer> createCustomersData() {
        File customersData = new File(customersDataPath);        
        customersData.mkdirs();
        return new HashMap<String, Customer>();
    }

    @SuppressWarnings("CallToThreadDumpStack")
    private void writeCustomersData(Map<String, Customer> customers) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(customersDataFile));
            out.writeObject(customers);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
