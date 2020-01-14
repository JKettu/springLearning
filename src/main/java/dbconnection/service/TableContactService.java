package dbconnection.service;

import dbconnection.model.TableContact;

import java.util.List;

public interface TableContactService {

    TableContact addContact(TableContact contact);
    void delete(Long id);
    void deleteAll();
    TableContact getById(Long id);
    TableContact getByFirstName(String firstName);
    List<TableContact> getAll();
}
