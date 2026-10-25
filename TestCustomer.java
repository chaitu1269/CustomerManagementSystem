
package com.codegnan.customer;

public class TestCustomer {

    public static void main(String[] args) {

        CustomerOperations operations = new CustomerOperations();

        // 1. Display initial customers
        System.out.println("===== Initial Customers =====");

        for (Customer customer : operations.getCustomers()) {
            System.out.println(customer);
        }

        // 2. Add new customer
        System.out.println("\n===== Add Customer =====");

        boolean added = operations.addCustomer(
                106, "Ananya", "Verma", 'F');

        System.out.println("Customer added: " + added);

        // 3. Attempt duplicate addition
        boolean duplicate = operations.addCustomer(
                106, "Ananya", "Verma", 'F');

        System.out.println("Duplicate added: " + duplicate);

        // 4. Update customer 103
        System.out.println("\n===== Update Customer =====");

        boolean updated = operations.updateCustomer(
                103, "Arjun", "Reddy", 'M');

        System.out.println("Customer updated: " + updated);

        // 5. Delete customer 104
        System.out.println("\n===== Delete Customer =====");

        boolean deleted = operations.deleteCustomer(104);

        System.out.println("Customer deleted: " + deleted);

        // 6. Find customer by ID 102
        System.out.println("\n===== Find By ID =====");

        Customer customerById = operations.findCustomerById(102);

        if (customerById != null) {
            System.out.println(customerById);
        } else {
            System.out.println("Customer not found");
        }

        // 7. Find customer by first name Kiran
        System.out.println("\n===== Find By First Name =====");

        Customer customerByName =
                operations.findCustomerByFirstname("Kiran");

        if (customerByName != null) {
            System.out.println(customerByName);
        } else {
            System.out.println("Customer not found");
        }

        // 8. Find non-existing customer
        System.out.println("\n===== Find ID 999 =====");

        Customer missingCustomer =
                operations.findCustomerById(999);

        if (missingCustomer != null) {
            System.out.println(missingCustomer);
        } else {
            System.out.println("Customer with ID 999 not found");
        }

        // 9. Display final customers
        System.out.println("\n===== Final Customers =====");

        for (Customer customer : operations.getCustomers()) {
            System.out.println(customer);
        }
    }
}
