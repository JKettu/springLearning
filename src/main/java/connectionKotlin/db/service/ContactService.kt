package connectionKotlin.db.service

import connectionKotlin.db.model.ContactTest
import connectionKotlin.db.repository.ContactTestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContactService (@Autowired private val contactTestRepository: ContactTestRepository) {

    fun getAllContactTest(): List<ContactTest> {
        return contactTestRepository.findAll() as List<ContactTest>
    }

    fun getContactTestById(id: Long): ContactTest? {
        return contactTestRepository.findById(id).orElse(null)
    }

    fun getContactTestByFirstName(firstName: String): List<ContactTest>? {
        return contactTestRepository.findByFirstName(firstName)
    }

    fun createContactTest(contact: ContactTest): ContactTest {
        return contactTestRepository.save(contact)
    }

    fun deleteContactTestById(id: Long) {
        contactTestRepository.deleteById(id)
    }

    fun deleteAllContactTest() {
        contactTestRepository.deleteAll()
    }
}