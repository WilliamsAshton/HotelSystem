/**
 * CustomerContactRepositoryTest.java
 * Repository Test for the CustomerContact
 * Author: Brandon Wise - 220049173
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;
import za.ac.cput.repository.impl.CustomerContactRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerContactRepositoryImplTest {
    private static CustomerContactRepositoryImpl repository = CustomerContactRepositoryImpl.getRepository();
    private static CustomerContact customerContact = CustomerContactFactory.buildCustomerContact("0738395832","JoshBrown@gmail.com");

    @Test
    void a_create() {
        CustomerContact created = repository.create(customerContact);
        assertEquals(customerContact.getCustomerContactID(), created.getCustomerContactID());
        System.out.println("Create:" + created);
    }
    @Test
    void b_read() {
        CustomerContact read = repository.read(customerContact.getCustomerContactID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }
    @Test
    void c_update() {
        CustomerContact updated = new CustomerContact.Builder().copy(customerContact).setCellNo("0814859275")
                .setEmail("JoshBrown1@gmail.com")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }
    @Test
    void d_delete() {
        boolean success = repository.delete(customerContact.getCustomerContactID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }
    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}