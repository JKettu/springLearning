package connectionKotlin.db.controller

import connectionKotlin.db.model.ContactTest
import connectionKotlin.db.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(path = ["/db"])
class DbController (@Autowired private val contactService: ContactService) {

    @GetMapping(path = ["/getAllContacts"])
    @ResponseBody fun getAllContacts(): List<ContactTest>? {
        return contactService.getAllContactTest()
    }

    @GetMapping(path = ["/getContactTestById"])
    @ResponseBody fun getContactTestById(id: Long): ContactTest? {
        return contactService.getContactTestById(id)
    }

    @GetMapping(path = ["/getContactTestByFirstName"])
    @ResponseBody fun getContactTestByFirstName(firstName: String): List<ContactTest>? {
        return contactService.getContactTestByFirstName(firstName)
    }

    @GetMapping(path = ["/createContactTest"])
    @ResponseBody fun createContactTest(firstName: String, lastName: String): ContactTest {
        val contact = ContactTest()
        contact.firstName = firstName
        contact.lastName = lastName
        return contactService.createContactTest(contact)
    }

    @GetMapping(path = ["/deleteContactTestById"])
    @ResponseBody fun deleteContactTestById(id: Long) {
       contactService.deleteContactTestById(id)
    }

    @GetMapping(path = ["/deleteAllContactTest"])
    @ResponseBody fun deleteAllContactTest() {
        contactService.deleteAllContactTest()
    }
}