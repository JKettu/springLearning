package dbconnection.controller;

import dbconnection.client.ContactClient;
import dbconnection.model.ContactTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class ClientController {

    @Autowired
    ContactClient contactClient;

    @RequestMapping(path = "/readAllContacts")
    public @ResponseBody List<ContactTest> getAllContacts() {
        return contactClient.getAllContactsClient();
    }

    /**
     * Not necessary to set param by annotation
     */
    @RequestMapping(path = "/readContactById", method = RequestMethod.GET)
    public @ResponseBody ContactTest getContactById(Long id) {
        return contactClient.getContactByIdClient(id);
    }

    @RequestMapping(path = "/readContactByFirstName", method = RequestMethod.GET)
    public @ResponseBody ContactTest getContactByFirstName(String firstName) {
        return contactClient.getContactByFirstNameClient(firstName);
    }

    @RequestMapping(path = "/deleteByIdClient")
    public @ResponseBody void deleteContactById (Long id){
        contactClient.deleteByIdClient(id);
    }

    @RequestMapping(path = "/deleteAllClient")
    public @ResponseBody void deleteAll() {
        contactClient.deleteAllClient();
    }

    @GetMapping(path = "/createContactClient")
    public @ResponseBody ContactTest
    createNewContact(String lastName, String firstName) {
        return contactClient.createNewContactClient(firstName, lastName);
    }
}
