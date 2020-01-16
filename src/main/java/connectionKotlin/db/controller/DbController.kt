package connectionKotlin.db.controller

import connectionKotlin.db.model.ContactTest
import connectionKotlin.db.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path = ["/db"])
class DbController (@Autowired private val contactService: ContactService) {

    @GetMapping(path = ["/getAllContacts"])
    fun getAllContacts(): List<ContactTest>? {
        return contactService.getAllContactTest()
    }

    @GetMapping(path = ["/getContactTestById"])
    fun getContactTestById(id: Long): ContactTest? {
        return contactService.getContactTestById(id)
    }

    @GetMapping(path = ["/getContactTestByFirstName"])
    fun getContactTestByFirstName(firstName: String): List<ContactTest>? {
        return contactService.getContactTestByFirstName(firstName)
    }

    @GetMapping(path = ["/createContactTest"])
    fun createContactTest(firstName: String, lastName: String): ContactTest {
        val contact = ContactTest()
        contact.firstName = firstName
        contact.lastName = lastName
        return contactService.createContactTest(contact)
    }

    @GetMapping(path = ["/deleteContactTestById"])
    fun deleteContactTestById(id: Long) {
       contactService.deleteContactTestById(id)
    }

    @GetMapping(path = ["/deleteAllContactTest"])
    fun deleteAllContactTest() {
        contactService.deleteAllContactTest()
    }
}