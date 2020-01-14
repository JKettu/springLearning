package dbconnection.repository;

import dbconnection.model.TableContact;
import org.springframework.data.repository.CrudRepository;

public interface TableContactRepository extends CrudRepository<TableContact, Long> {
}
