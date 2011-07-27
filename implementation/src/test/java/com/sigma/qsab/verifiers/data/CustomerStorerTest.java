package com.sigma.qsab.verifiers.data;

import com.sigma.qsab.data.Customer;
import com.sigma.qsab.data.CustomerStorer;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerStorerTest {

    @Test
    public void newCustomerTest() {
        boolean expected = true;
        CustomerStorer customers = new CustomerStorer();
        Customer c = createTestCustomer();
        customers.put(c);
        boolean actual = customers.contains(c);
        assertThat(actual, is(expected));
    }

    @Test
    public void notEqualsAnotherCustomer() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorer();
        customers.put(createTestCustomer());
        boolean actual = customers.contains(createAnotherTestCustomer());
        assertThat(actual, is(expected));
    }

    @Test
    public void notEqualsAnotherCustomerWithSameID() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorer();
        customers.put(createTestCustomer());
        boolean actual = customers.contains(createAnotherTestCustomerWithSameIDAsFirstTestCustomer());
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldNotReplaceCustomer() {
        boolean expected = false;
        CustomerStorer customers = new CustomerStorer();
        customers.put(createTestCustomer());
        Customer c = customers.put(createAnotherTestCustomerWithSameIDAsFirstTestCustomer());
        customers.put(c);
        boolean actual = customers.contains(c);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testAddingTwoCustomers() {
        boolean expected = true;
        CustomerStorer customers = new CustomerStorer();
        Customer c1 = createTestCustomer();
        Customer c2 = createAnotherTestCustomer();
        customers.put(c1);
        customers.put(c2);
        boolean actual = customers.contains(c1);
        assertThat(actual, is(expected));
        actual = customers.contains(c2);
        assertThat(actual, is(expected));
    }

    private Customer createTestCustomer() {
        Customer c = new Customer("Test", "Testsson", "121212-1212",
                "Testvägen", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }

    private Customer createAnotherTestCustomer() {
        Customer c = new Customer("Test", "Testsson", "121212-1113",
                "Testvägen", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }

    private Customer createAnotherTestCustomerWithSameIDAsFirstTestCustomer() {
        Customer c = new Customer("AnnanKund", "MedSammaID", "121212-1212",
                "Testvägen", "12345", "Testort", "08-123456", "073-1234567",
                "test@test.com", "testpwd");
        return c;
    }
}
