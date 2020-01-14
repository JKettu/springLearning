package dbconnection.service;

import dbconnection.model.ContactTest;

import java.util.List;

/**
 * Interface for service to work with contact's data
 */
public interface ContactService {

    ContactTest addContact(ContactTest contact);
    void delete(Long id);
    void deleteAll();
    ContactTest getById(Long id);
    ContactTest getByFirstName(String firstName);
    List<ContactTest> getAll();
}
