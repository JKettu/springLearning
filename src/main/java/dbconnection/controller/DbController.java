package dbconnection.controller;

import dbconnection.model.ContactTest;
import dbconnection.model.TableContact;
import dbconnection.model.TableCustomer;
import dbconnection.service.impl.ContactServiceImpl;
import dbconnection.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller represents bean, which can be called by web.
 * This example contains ContactService's methods calls.
 */

@Controller
@RequestMapping("/testDb")
public class DbController {

    @Autowired
    ContactServiceImpl contactService;

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public ModelAndView getHello(@PathVariable Long id) {
        ContactTest contactCrm = contactService.getById(id);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("person", contactCrm);
        return modelAndView;
    }

    @GetMapping(path = "/getAllContacts")
    public @ResponseBody Iterable<ContactTest> getAllContacts() {
        return contactService.getAll();
    }

    @GetMapping(path = "/getContactById")
    public @ResponseBody
    ContactTest getContactById(Long id) {
        return contactService.getById(id);
    }

    @GetMapping(path = "/getContactByFirstName")
    public @ResponseBody
    ContactTest getContactByFirstName(String firstName) {
        return contactService.getByFirstName(firstName);
    }

    @GetMapping(path = "/createContact", params = {"lastName", "firstName"})
    public @ResponseBody ContactTest
    createNewContact(String lastName, String firstName) {
        ContactTest contactTest = new ContactTest();
        contactTest.setFirstName(firstName);
        contactTest.setLastName(lastName);
        return contactService.addContact(contactTest);
    }

    @GetMapping(path = "/deleteById")
    public @ResponseBody void deleteContactById (Long id){
        contactService.delete(id);
    }

    @GetMapping(path = "/deleteAll")
    public @ResponseBody void deleteAll() {
        contactService.deleteAll();
    }

    @GetMapping(path = "/getCrmContactById")
    public @ResponseBody TableContact getCrmContactById(Long id) {
        return contactService.getCrmContactById(id);
    }

    @GetMapping(path = "/getCustomerByObjid")
    public @ResponseBody TableCustomer getCrmCustomerByObjid(Long id) {
        return customerService.getCustomerByObjid(id);
    }
}
