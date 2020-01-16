package dbconnection.service;

import dbconnection.model.ContactTest;
import dbconnection.model.TableContact;
import dbconnection.repository.ContactRepository;
import dbconnection.repository.TableContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service to work with contact's data.
 * Contains business logic (not in this example, but it should)
 */
@Service
public class ContactServiceImpl {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private TableContactRepository tableContactRepository;

    @Transactional
    public ContactTest addContact(ContactTest contact) {
        return contactRepository.save(contact);
    }

    public TableContact addContact(TableContact contact) {
        return tableContactRepository.save(contact);
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    public void deleteAll() {
        contactRepository.deleteAll();
    }

    public ContactTest getById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public TableContact getCrmContactById(Long id) {
        return tableContactRepository.findById(id).orElse(null);
    }

    public ContactTest getByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    public List<ContactTest> getAll() {
        return (List<ContactTest>) contactRepository.findAll();
    }
}
