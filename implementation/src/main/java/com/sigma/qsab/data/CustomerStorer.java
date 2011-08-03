package com.sigma.qsab.data;

public interface CustomerStorer {
    
    public boolean addCustomer(Customer customer);
    
    public boolean deleteCustomer(Customer customer);
    
    public boolean updateCustomer(Customer customer);
    
    public Customer findCustomer(String socialID);
    
    public boolean containsCustomer(Customer customer);
}
