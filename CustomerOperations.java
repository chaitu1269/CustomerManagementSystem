
package com.codegnan.customer;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerOperations {

    private HashSet<Customer> customers = new HashSet<>();

    // Initialize five customers
    public CustomerOperations() {
        customers.add(new Customer(101, "Rahul", "Sharma", 'M'));
        customers.add(new Customer(102, "Priya", "Reddy", 'F'));
        customers.add(new Customer(103, "Arjun", "Kumar", 'M'));
        customers.add(new Customer(104, "Sneha", "Rao", 'F'));
        customers.add(new Customer(105, "Kiran", "Patel", 'M'));
    }

    // 1. Add customer
    public boolean addCustomer(int id, String firstname,
                               String lastname, char gender) {

        Customer customer =
                new Customer(id, firstname, lastname, gender);

        return customers.add(customer);
    }

    // 2. Update customer
    public boolean updateCustomer(int customerId,
                                  String firstname,
                                  String lastname,
                                  char gender) {

        Customer customer = findCustomerById(customerId);

        if (customer == null) {
            return false;
        }

        // Remove before changing fields used by hashCode()
        customers.remove(customer);

        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setGender(gender);

        customers.add(customer);

        return true;
    }

    // 3. Delete customer
    public boolean deleteCustomer(int customerId) {

        Iterator<Customer> iterator = customers.iterator();

        while (iterator.hasNext()) {
            Customer customer = iterator.next();

            if (customer.getId() == customerId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    // 4. Retrieve all customers
    public HashSet<Customer> getCustomers() {
        return customers;
    }

    // 5. Find customer by ID
    public Customer findCustomerById(int customerId) {

        for (Customer customer : customers) {

            if (customer.getId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    // 6. Find customer by first name
    public Customer findCustomerByFirstname(String firstname) {

        for (Customer customer : customers) {

            if (customer.getFirstname() != null
                    && customer.getFirstname().equals(firstname)) {
                return customer;
            }
        }

        return null;
    }
}
