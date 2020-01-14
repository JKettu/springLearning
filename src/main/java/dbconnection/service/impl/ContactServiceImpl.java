package dbconnection.service.impl;

import dbconnection.model.ContactTest;
import dbconnection.model.TableContact;
import dbconnection.repository.ContactRepository;
import dbconnection.repository.TableContactRepository;
import dbconnection.service.ContactService;
import dbconnection.service.TableContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to work with contact's data.
 * Contains business logic (not in this example, but it should)
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private TableContactRepository tableContactRepository;

    @Override
    public ContactTest addContact(ContactTest contact) {
        return contactRepository.save(contact);
    }

    public TableContact addContact(TableContact contact) {
        return tableContactRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }

    @Override
    public ContactTest getById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public TableContact getCrmContactById(Long id) {
        return tableContactRepository.findById(id).orElse(null);
    }

    @Override
    public ContactTest getByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public List<ContactTest> getAll() {
        return (List<ContactTest>) contactRepository.findAll();
    }
}
