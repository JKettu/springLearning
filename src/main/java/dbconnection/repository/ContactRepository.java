package dbconnection.repository;

import dbconnection.model.ContactTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository represents DAO layer.
 * This one defines extra methods to work with table contacttest
 */
public interface ContactRepository extends CrudRepository<ContactTest, Long> {

    @Query("select c from ContactTest c where c.firstName = :firstName")
    ContactTest findByFirstName(@Param("firstName") String firstName);
}
