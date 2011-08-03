package com.sigma.qsab.data;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerStorerTest {

    @Test
    public void newCustomerTest() {
        boolean expected = true;
        CustomerStorer customers = new CustomerStorerImpl();
        Customer c = createTestCustomer();
        customers.addCustomer(c);
        boolean actual = customers.containsCustomer(c);
        assertThat(actual, is(expected));
    }

    @Test
    public void notEqualsAnotherCustomer() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorerImpl();
        customers.addCustomer(createTestCustomer());
        boolean actual = customers.containsCustomer(createAnotherTestCustomer());
        assertThat(actual, is(expected));
    }

    @Test
    public void notEqualsAnotherCustomerWithSameID() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorerImpl();
        customers.addCustomer(createTestCustomer());
        boolean actual = customers.containsCustomer(createAnotherTestCustomerWithSameIDAsFirstTestCustomer());
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldNotReplaceCustomer() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorerImpl();
        customers.addCustomer(createTestCustomer());
        Customer c = createAnotherTestCustomerWithSameIDAsFirstTestCustomer();
        customers.addCustomer(c);
        boolean actual = customers.containsCustomer(c);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testAddingTwoCustomers() {
        boolean expected = true;
        CustomerStorer customers = new CustomerStorerImpl();
        Customer c1 = createTestCustomer();
        Customer c2 = createAnotherTestCustomer();
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        boolean actual = customers.containsCustomer(c1);
        assertThat(actual, is(expected));
        actual = customers.containsCustomer(c2);
        assertThat(actual, is(expected));
    }

    private Customer createTestCustomer() {
        Customer c = new Customer("Test", "Testsson", "121212-1212",
                "Testgatan", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }

    private Customer createAnotherTestCustomer() {
        Customer c = new Customer("Test", "Testsson", "121212-1113",
                "Testgatan", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }

    private Customer createAnotherTestCustomerWithSameIDAsFirstTestCustomer() {
        Customer c = new Customer("AnnanKund", "MedSammaID", "121212-1212",
                "Testgatan", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }
}
