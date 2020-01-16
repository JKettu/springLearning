package connectionKotlin.db.repository

import connectionKotlin.db.model.ContactTest
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ContactTestRepository: CrudRepository<ContactTest, Long> {

    @Query("select ct from ContactTest ct where ct.firstName = :firstName")
    fun findByFirstName(firstName: String): List<ContactTest>?
}